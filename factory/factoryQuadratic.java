
package factory;
import java.util.ArrayList;


import equation.Equation;
import equation.QuadraticEquation;
import equation.Term;

public class factoryQuadratic extends Factory {
	
	private static factoryQuadratic instance = new factoryQuadratic();

	public static factoryQuadratic getInstance() {
		return instance;
	}

	private factoryQuadratic() {
	}

	@Override
	public Equation factoryMethod(String input) {
		ArrayList<Term>terms = this.simplify(input);
		return new QuadraticEquation(terms);
	}

}
