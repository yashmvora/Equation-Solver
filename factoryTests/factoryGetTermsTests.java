package factoryTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import equation.Term;
import equation.VariableTerm;
import factory.Factory;
import factory.factoryCubic;

public class factoryGetTermsTests {
	@Test
	public void testConstructor1() {
		 ArrayList<Term> result = factoryCubic.getInstance().getTerms("");
		assertEquals("22.0x^1", result.toString());
	}

}
