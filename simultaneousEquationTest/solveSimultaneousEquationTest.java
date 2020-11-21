package simultaneousEquationTest;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import equation.ConstantTerm;
import equation.LinearEquation;
import equation.SimultaneousEquation;
import equation.Term;
import equation.VariableTerm;

public class solveSimultaneousEquationTest {

	@BeforeEach
	public void setUp() throws Exception {  }
	
	public void tearDown() {}

	@Test
	public void test() {
		
		ArrayList<Term> eq1= new ArrayList<>();
		eq1.add(new VariableTerm("2x"));
		eq1.add(new VariableTerm("2y"));
		eq1.add(new ConstantTerm("2"));
		
		ArrayList<Term>eq2= new ArrayList<>();
		eq2.add(new VariableTerm("3x"));
		eq2.add(new VariableTerm("-4y"));
		eq2.add(new ConstantTerm("5"));
		

		ArrayList<LinearEquation> equations = new ArrayList<>();
		equations.add(new LinearEquation(eq1));
		equations.add(new LinearEquation(eq2));
		
		SimultaneousEquation simul = new SimultaneousEquation(equations);
		
	}
	
}
