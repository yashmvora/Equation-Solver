package factory;


import java.util.ArrayList;

import equation.CubicEquation;
import equation.Equation;
import equation.Term;

public class factoryCubic extends Factory {

	@Override
	public Equation factoryMethod(String input) {
		ArrayList<Term>terms = this.simplify(input);
		return new CubicEquation(terms);
	}

}
