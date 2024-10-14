import itertools
from ortools.linear_solver import pywraplp
from pick import pick

solver = pywraplp.Solver.CreateSolver("GLOP")
infinity = solver.infinity()

model_data = {}

q1 = input("¿Desea escribir a mano las variables? (s/n): ")
q1 = True if q1 == "s" else False

if q1:
    n = int(input("Numero de variables: "))
    model_data["num_variables"] = n
    model_data["Nombres variables"] = []

x = {}

if not q1:
    conjuntos = int(input("Cuantos conjuntos: "))
    con = []

    for i in range(conjuntos):
        con.append(input(f"{i} Fruits(apple,orange): ").split(","))

    model_data["Nombres variables"] = [
        "|".join(permu) for permu in itertools.product(*con)
    ]

    model_data["num_variables"] = len(model_data["Nombres variables"])

for i in range(model_data["num_variables"]):
    if q1:
        variable = input(f"Nombre de la variable {i + 1}: ")
        model_data["Nombres variables"].append(variable)
        x[i] = solver.Var(0, infinity, integer=False, name=variable)
    else:
        x[i] = solver.Var(
            0, infinity, integer=False, name=model_data["Nombres variables"][i]
        )


print("Numero de variables =", solver.NumVariables())

r = int(input("Numero de restricciones:"))

model_data["num_restricciones"] = r
model_data["Nombres restricciones"] = []
model_data["coeficientes_restricciones"] = []
model_data["valores_lado_derecho"] = []

for i in range(r):
    print("Nombre de la restriccion ", i + 1)

    variable = input()
    model_data["Nombres restricciones"].append(variable)

    selected = pick(
        model_data["Nombres variables"],
        variable,
        multiselect=True,
        min_selection_count=1,
    )

    row = [0 for _ in range(model_data["num_variables"])]

    for j in selected:
        value, index = j
        print(index, value)
        row[index] = 1

    model_data["coeficientes_restricciones"].append(row)

    rightSide = float(input("Ingrese el valor del lado derecho de la restriccion: "))

    model_data["valores_lado_derecho"].append(rightSide)

for i in range(model_data["num_restricciones"]):
    restricciones = solver.RowConstraint(
        0, model_data["valores_lado_derecho"][i], model_data["Nombres restricciones"][i]
    )

    for j in range(model_data["num_variables"]):
        restricciones.SetCoefficient(
            x[j], model_data["coeficientes_restricciones"][i][j]
        )

print("Numero de restricciones =", solver.NumConstraints())


model_data["coeficientes_funcionOb"] = []

print("Funcion objetivo")

for i in range(model_data["num_variables"]):
    model_data["coeficientes_funcionOb"].append(
        float(input(f"Coeficiente de variable {x[i]}: "))
    )


funcion_Objetivo = solver.Objective()

for j in range(model_data["num_variables"]):
    funcion_Objetivo.SetCoefficient(x[j], model_data["coeficientes_funcionOb"][j])

op, i = pick(title="Que desea?", options=["Minimizar", "Maximizar"], indicator="->")

if i == 0:
    helper = "Valor de la Función Objetivo a Minimizar: "
    funcion_Objetivo.SetMinimization()
if i == 1:
    helper = "Valor de la Función Objetivo a Maximizar: "
    funcion_Objetivo.SetMaximization()


modelo = solver.Solve()

if modelo == pywraplp.Solver.OPTIMAL:
    print("Solución")
    print(helper, solver.Objective().Value())

    for j in range(model_data["num_variables"]):
        print(x[j].name(), " = ", x[j].solution_value())
else:
    print("El modelo no tiene una solución optima")
