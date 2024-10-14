import pygame
import numpy as np
import time

def main():
    pygame.init()
    width, height,margin = 600,600, 40
    bg = 25, 25, 25

    screen = pygame.display.set_mode((width,height+margin))
    pygame.display.set_caption('Game of life - JP')
    font = pygame.font.SysFont("Arial", 18)
    screen.fill(bg)

    msg1 = " START "
    msg2 = " ADD "
    msg3 = " RANDOM "

    colorButton1 = (59, 167, 16)
    colorButton2 = (16, 201, 188)
    colorButton3 = (102, 0, 0) 

    pauseGame = True
    cellAdd= 1

    # Size of matrix 
    nxC, nyC = 60, 60

    # create matrix with [[0,0,0,...],[0,0,0 ...],[0,0,0 ...],[0,0,0 ...], ...] 
    gameState = np.zeros((nxC,  nyC))

    # dimensions of each cell UI
    dimCW = width / nxC
    dimCH = (height / nyC) 

    def getGameState(x,y):
        if(x < 0 or y < 0 or x >= nxC or y >= nyC):
            return 0
        return gameState[x,y]

    def randomGame():
        matrix= np.random.randint(0, 2,(nxC, nyC))
        return matrix

    while True:
        # copy matrix of previous state
        newGameState = np.copy(gameState)
        # slow down execution to 0.1 seconds
        time.sleep(0.1)
        # clean
        screen.fill(bg) 

        # Get event from mouse and keyboard
        ev = pygame.event.get()
        for event in ev:
            if event.type == pygame.QUIT:
                pygame.quit()
                exit(0)

            if event.type == pygame.MOUSEBUTTONDOWN:
                if positionButton1.collidepoint(event.pos):
                    if not pauseGame:
                        msg1 = " START "
                        pauseGame = True
                    else:
                        msg1 = " PAUSE "
                        pauseGame = False
                if positionButton2.collidepoint(event.pos):
                    if not cellAdd:
                        msg2 = " ADD "
                        cellAdd = 1
                    else:
                        msg2 = " REMOVE "
                        cellAdd = 0
                if positionButton3.collidepoint(event.pos):
                    newGameState=randomGame()


            mouseClick = pygame.mouse.get_pressed()
            if sum(mouseClick) > 0:
                posX, posY = pygame.mouse.get_pos()
                if posY <= margin:
                    posY = -1
                if posY >= margin:
                    posY -= margin

                celX, celY = int(np.floor(posX / dimCW)), int(np.floor(posY / dimCH))
                if celX >= 0 and celY >=0  and (celX < (gameState.shape[0]) and celY < (gameState.shape[1])): 
                    newGameState[celX, celY] = cellAdd

        # 3. Muere si se genera en una esquina de la celda (muere si esta en estas coordenadas [0,0],[0,60],[60,0],[60,60]).
        if (gameState[0,0] == 1 ):
            newGameState[0,0] = 0

        if(gameState[0,nyC -1] == 1):
            newGameState[0,nyC -1] = 0

        if(gameState[nxC-1,0] == 1):
            newGameState[nxC-1,0] = 0

        if(gameState[nxC-1,nyC-1] == 1):
            newGameState[nxC-1,nyC-1] = 0
       
        for y in range(0, nxC):
            for x in range (0, nyC):
                if not pauseGame:
                    # find all neighbors.
                    # 000
                    # 0x0
                    # 000
                    n_neigh =   getGameState((x - 1), (y - 1)) + \
                                getGameState((x)    , (y - 1)) + \
                                getGameState((x + 1), (y - 1)) + \
                                getGameState((x - 1), (y)    ) + \
                                getGameState((x + 1), (y)    ) + \
                                getGameState((x - 1), (y + 1)) + \
                                getGameState((x)    , (y + 1)) + \
                                getGameState((x + 1), (y + 1))

                    # 1. Nace una célula si solo hay 2   
                    if (gameState[x ,y] == 0 and n_neigh == 2):
                        newGameState[x, y] = 1
                    # 2. Muere una célula si hay más de 3 
                    if(gameState[x ,y] == 1 and n_neigh > 3):
                        newGameState[x, y] = 0
                    # 4. Las celular no mueren por soledad (muere si vecinos = 0)
                    
                # shape of cell.
                poly = [((x)   * dimCW, y * dimCH+margin),
                        ((x+1) * dimCW, y * dimCH+margin),
                        ((x+1) * dimCW, (y+1) * dimCH+margin),
                        ((x)   * dimCW, (y+1) * dimCH+margin)]

                if newGameState[x, y] == 0:
                    # "dead" paint to square with border gray 
                    pygame.draw.polygon(screen, (40, 40, 40), poly, 1)
                else:
                    # "live" paint to square with fill red
                    pygame.draw.polygon(screen, colorButton2, poly, 0)

        # Draw buttons
        textButton1 = font.render(msg1, True, colorButton1)
        positionButton1 = textButton1.get_rect(topleft=(10,10))
        screen.blit(textButton1, positionButton1)

        textButton2 = font.render(msg2, True, colorButton2)
        p = (width-60,10)
        if cellAdd == 0:
            p = (width-120,10)
        positionButton2 = textButton2.get_rect(topleft=p)
        screen.blit(textButton2, positionButton2)

        textButton3 = font.render(msg3, True, colorButton3)
        positionButton3 = textButton3.get_rect(topleft=((width/2)-20,10))
        screen.blit(textButton3, positionButton3)

        pygame.draw.rect(screen, colorButton1,positionButton1,2)
        pygame.draw.rect(screen, colorButton2,positionButton2,2)
        pygame.draw.rect(screen, colorButton3,positionButton3,2)

        # update game
        gameState = np.copy(newGameState)
        # show results
        pygame.display.flip()

if __name__ == "__main__":
    main()