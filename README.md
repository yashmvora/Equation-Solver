# Equation Solver

Equation Roots Calculator
1. Simultaneous Linear
2. Quadratic 
3. Cubic
4. Simplify an equation

FLOW  
- User input (type of equation)
    - break the input string to lhs string and rhs string 
- Validation of equation (checking brackets, equal)
    - sending rhs string to lhs string (concate)
- Simplify (using one string to store and update the equation)
- Method: finding the first ')' 
    - removing brackets 
    - getting standardized form
- Solving for the roots

Input Conditions:
- no '/' in the input

Term -> coefficient, var and power 
Equation -> ArrayList<Term>

Bugs in Simplify:
1. removeConstantPower is not working
•	Empty String in main
•	Empty String in Simultaneous
•	Simultaneous equations variable and no of equations thing (first equation)
•	Remove some singleton classes
