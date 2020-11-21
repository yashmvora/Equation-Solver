package variableTests;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Test;

import factory.*;

import equation.Term;
import equation.VariableTerm;
public class ConstructorVariableTerm{
	public String ListToString(ArrayList<Term> terms) {
		return terms.get(0).toString();
	}
	
	@Test
	public void testConstructor1() {
		VariableTerm result = new VariableTerm("22x");
		assertEquals("22.0x^1", result.toString());
	}
	@Test
	public void testConstructor2() {
		VariableTerm result = new VariableTerm("22x^2");
		assertEquals("22.0x^2", result.toString());
	}
	@Test
	public void testConstructor3() {
		VariableTerm result = new VariableTerm("-22x^2");
		assertEquals("-22.0x^2", result.toString());
	}
	@Test
	public void testConstructor4() {
		VariableTerm result = new VariableTerm("+22x^2");
		assertEquals("22.0x^2", result.toString());
	}
}
