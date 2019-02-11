#!python3

from cvxopt import matrix, solvers

# Solve the linear program: "maximize 2x + 3y subject to 4x + 5y <= 6, x >= 0, y >= 0"
A = matrix([[4.0, 1.0, 0.0], [5.0, 0.0, 1.0]])
b = matrix([6.0, 0.0, 0.0])
c = matrix([2.0, 3.0])
sol=solvers.lp(c,A,b)
print(sol['x'])
