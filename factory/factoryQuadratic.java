
package factory;
import java.util.ArrayList;


import equation.Equation;
import equation.QuadraticEquation;
import equation.Term;

public class factoryQuadratic extends Factory {

	@Override
	public Equation factoryMethod(String input) {
		ArrayList<Term>terms = this.simplify(input);
		return new QuadraticEquation(terms);
	}

}
