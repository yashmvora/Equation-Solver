package variableTests;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Test;

import factory.*;

import equation.Term;
import equation.VariableTerm;
public class getTermsTest{
	public String ListToString(ArrayList<Term> terms) {
		return terms.get(0).toString();
	}
	
	@Test
	public void testToString() {
		VariableTerm result = new VariableTerm("");
		result.setCoefficient(2);
		result.setVar('x');
		result.setPower(1);
		assertEquals("2.0x^1", result.toString());
	}
	@Test
	public void testConstructor() {
		VariableTerm result = new VariableTerm("22x^2");
		assertEquals("22.0x^2", result.toString());
	}
}
