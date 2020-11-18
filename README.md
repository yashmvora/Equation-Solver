# Equation Solver

FLOW  
User input
- break the input string to lhs string and rhs string (waleed/mutasim)
Validation of equation (checking brackets, equal)
- sending rhs string to lhs string (concate)
Simplify (using one string to store and update the equation)
Method: finding the first ')' 
- removing brackets 
- getting standardized form
Solving for the roots

calc - Yash 
to finish -3x+2x, 3x^2-2x^2, qudratic as well

multi func - shrivatsa
- 3+(x+1)
- 3(x-2)+1
- (x+2)3+1
- (x+2)(x-3)
- (x-1)(x-3)(x+2)


Input Conditions:
- no '/' in the input
- 

Term -> coefficient, var and power 
Equation -> ArrayList<Term>

ArrayList<Equation>
Equation -> 2 Arraylist - one variables and one constant

Simplify-> String calculate(ArrayList<String> terms) NEEDS TO BE CHECKED

Bugs in Simplify:

1. correctPower: split("+") instead of split("\\+")
2. simplifyTerms: split("*") instead of split("\\*")
3. getCoefficient: Wrote: if(x>='0'&& x=='.' && x<='9')
    should have been: if((x>='0' && x<='9')|| x=='.')
4. getVar could not handle signs, modified it to be able to do so
5. getCoefficient could not handle signs, modified it to be able to do so
6. splitIntoTerms did not give the last term in the expression, fixed it
7. removeConstantPower is not working
8. calc: 
     fin = '+'+sum; so the ascii code of '+' was getting added to sum
9. splitIntoTerms cannot handle '-' sign


Problems left to solve:
3. removeConstantPower is not working