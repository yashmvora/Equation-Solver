package factory;

import java.util.ArrayList;

import equation.Equation;
import equation.LinearEquation;
import equation.QuadraticEquation;
import equation.Term;

public class factoryLinear extends Factory {

	private static factoryLinear instance = new factoryLinear();

	public static factoryLinear getInstance() {
		return instance;
	}

	private factoryLinear() {
	}

	@Override
	public Equation factoryMethod(String input) {
		ArrayList<Term> terms = this.simplifyInput(input);
		return new LinearEquation(terms);
	}

}