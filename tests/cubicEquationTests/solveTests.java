package tests.cubicEquationTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import equation.ConstantTerm;
import equation.LinearEquation;
import equation.Term;
import equation.VariableTerm;

public class solveTests {
	@Test
	public void testToString() {
		ArrayList<Term> terms = new ArrayList<>();
		terms.add(new VariableTerm("x^3"));
		terms.add(new VariableTerm(""));
		terms.add(new ConstantTerm("5"));
	}
}
