from collections import namedtuple, Counter, defaultdict
import random
import math
import functools

cache = functools.lru_cache(10**6)


class Game:
    """A game is similar to a problem, but it has a terminal test instead of
    a goal test, and a utility for each terminal state. To create a game,
    subclass this class and implement `actions`, `result`, `is_terminal`,
    and `utility`. You will also need to set the .initial attribute to the
    initial state; this can be done in the constructor."""

    def actions(self, state):
        """Return a collection of the allowable moves from this state."""
        raise NotImplementedError

    def result(self, state, move):
        """Return the state that results from making a move from a state."""
        raise NotImplementedError

    def is_terminal(self, state):
        """Return True if this is a final state for the game."""
        return not self.actions(state)

    def utility(self, state, player):
        """Return the value of this final state to player."""
        raise NotImplementedError


def play_game(game, strategies: dict, verbose=False):
    """Play a turn-taking game. `strategies` is a {player_name: function} dict,
    where function(state, game) is used to get the player's move."""
    state = game.initial
    # count = 100
    # while count > 0 or not game.is_terminal(state):
    # print(count)
    while not game.is_terminal(state):
        player = state.to_move
        move = strategies[player](game, state)
        state = game.result(state, move)
        if verbose:
            print("Player", player, "move:", move)
            print(state)
        # count = count - 1
    return state


def minimax_search(game, state):
    """Search game tree to determine best move; return (value, move) pair."""

    player = state.to_move

    def max_value(state):
        if game.is_terminal(state):
            return game.utility(state, player), None
        v, move = -infinity, None
        for a in game.actions(state):
            v2, _ = min_value(game.result(state, a))
            if v2 > v:
                v, move = v2, a
        return v, move

    def min_value(state):
        if game.is_terminal(state):
            return game.utility(state, player), None
        v, move = +infinity, None
        for a in game.actions(state):
            v2, _ = max_value(game.result(state, a))
            if v2 < v:
                v, move = v2, a
        return v, move

    return max_value(state)


infinity = math.inf


def alphabeta_search(game, state):
    """Search game to determine best action; use alpha-beta pruning.
    As in [Figure 5.7], this version searches all the way to the leaves."""

    player = state.to_move

    def max_value(state, alpha, beta):
        if game.is_terminal(state):
            return game.utility(state, player), None
        v, move = -infinity, None
        for a in game.actions(state):
            v2, _ = min_value(game.result(state, a), alpha, beta)
            if v2 > v:
                v, move = v2, a
                alpha = max(alpha, v)
            if v >= beta:
                return v, move
        return v, move

    def min_value(state, alpha, beta):
        if game.is_terminal(state):
            return game.utility(state, player), None
        v, move = +infinity, None
        for a in game.actions(state):
            v2, _ = max_value(game.result(state, a), alpha, beta)
            if v2 < v:
                v, move = v2, a
                beta = min(beta, v)
            if v <= alpha:
                return v, move
        return v, move

    return max_value(state, -infinity, +infinity)


class friends(Game):
    def __init__(self, n=5):
        self.n = n
        self.initial = Board(height=1, width=n, to_move="X").friendInit(n)

    def actions(self, state):
        """Return a collection of the allowable moves from this state."""
        player = state.to_move
        opponent = "O" if player == "X" else "X"

        valid = []

        for currentCoord, p in state.items():
            if p == player:
                x, y = currentCoord

                for dx, dy in ((1, 0), (-1, 0)):
                    if state[x + dx, y + dy] == ".":
                        valid.append((dx, dy))

                    elif (
                        state[x + dx, y + dy] == opponent
                        and state[x + dx + 1, y + dy] == "."
                    ):
                        valid.append((2, 0))

        return valid

    def result(self, state, move):
        """Return the state that results from making a move from a state."""
        player = state.to_move
        opponent = "O" if player == "X" else "X"

        newState = state.new2({move: player}, to_move=opponent)
        newState.visit[str(state)] = 1

        if self.is_terminal(newState):
            if newState.visit.get(str(newState), -999) == 1:
                newState.utility = 0
            elif newState[self.n - 1, 0] == "X":
                newState.utility = 1
            elif newState[0, 0] == "O":
                newState.utility = -1

        old_new_state = {**state.visit, **newState.visit}
        newState.visit = old_new_state
        # print(newState.utility)

        return newState

    def is_terminal(self, state):
        """Return True if this is a final state for the game."""
        win = False
        if state[self.n - 1, 0] == "X" or state[0, 0] == "O":
            win = True
            return win
        if state.visit.get(str(state), -999) == 1:
            win = True
            state.draw = True
            return win

        return win

    def utility(self, state, player):
        """Return the value state.utility"""

        win = self.is_terminal(state)

        if win:
            if player == "X" and not state.draw:
                utility = 1
            if player == "O" and not state.draw:
                utility = -1
            if state.draw:
                utility = 0

        return utility


class Board(defaultdict):
    """A board has the player to move, a cached utility value,
    and a dict of {(x, y): player} entries, where player is 'X' or 'O'."""

    empty = "."
    off = "#"

    def friendInit(self, n):
        ok0 = self.new({(0, 0): "X"}, to_move="O")
        ok1 = ok0.new({(n - 1, 0): "O"}, to_move="X")
        return ok1

    def __init__(self, width=8, height=8, to_move=None, **kwds):
        self.draw = False
        self.visit = {}
        self.utility = 0
        self.__dict__.update(width=width, height=height, to_move=to_move, **kwds)

    def new(self, changes: dict, **kwds) -> "Board":
        "Given a dict of {(x, y): contents} changes, return a new Board with the changes."
        board = Board(width=self.width, height=self.height, **kwds)
        board.update(self)
        board.update(changes)
        return board

    def new2(self, changes: dict, **kwds) -> "Board":
        "Given a dict of {(x, y): contents} changes, return a new Board with the changes."
        old = {}
        newfx = {}
        currentPlayer = list(changes.values())[0]

        for currentCoord, p in self.items():
            if p == currentPlayer:
                x, y = currentCoord
                dx, dy = list(changes.keys())[0]

                old[currentCoord] = "."
                newfx[x + dx, y + dy] = currentPlayer

        board = Board(width=self.width, height=self.height, **kwds)
        board.update(self)
        board.update(old)
        board.update(newfx)

        return board

    def __missing__(self, loc):
        x, y = loc
        if 0 <= x < self.width and 0 <= y < self.height:
            return self.empty
        else:
            return self.off

    def __hash__(self):
        return hash(tuple(sorted(self.items()))) + hash(self.to_move)

    def __repr__(self):
        def row(y):
            return " ".join(self[x, y] for x in range(self.width))

        return "\n".join(map(row, range(self.height))) + "\n"


def random_player(game, state):
    return random.choice(list(game.actions(state)))


def player(search_algorithm):
    """A game player who uses the specified search algorithm"""
    return lambda game, state: search_algorithm(game, state)[1]


fx = friends(6)
ffx = play_game(fx, dict(X=random_player, O=player(alphabeta_search)), verbose=True)
ffx = play_game(fx, dict(X=random_player, O=player(minimax_search)), verbose=True)
print("End", ffx.utility)
# ffx = play_game(fx, dict(X=random_player, O=random_player), verbose=True)
# print(fx.visit)


""" XGame = friends(6)
print(XGame.initial)

moveX = XGame.actions(XGame.initial)
xmove1 = XGame.result(XGame.initial, moveX[0])
print(xmove1)

moveX2 = XGame.actions(xmove1)
xmove2 = XGame.result(xmove1, moveX2[0])
print(xmove2)

moveX3 = XGame.actions(xmove2)
xmove3 = XGame.result(xmove2, moveX3[0])
print(xmove3)

moveX4 = XGame.actions(xmove3)
xmove4 = XGame.result(xmove3, moveX4[1])
print(xmove4)

moveX5 = XGame.actions(xmove4)
xmove5 = XGame.result(xmove4, moveX5[0])
print(xmove5)

moveX6 = XGame.actions(xmove5)
xmove6 = XGame.result(xmove5, moveX6[1])
print(xmove6)

moveX7 = XGame.actions(xmove6)
xmove7 = XGame.result(xmove6, moveX7[0])
print(xmove7)

print(XGame.is_terminal(xmove7)) """
