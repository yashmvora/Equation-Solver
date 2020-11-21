

package equation;

import java.util.ArrayList;

public class CubicEquation extends PolynomialEquation {

	public CubicEquation(ArrayList<Term> terms) {
		super(terms);
		// TODO Auto-generated constructor stub
	}
	
	public void solve() {
		ConstantTerm c = getConstant();
		double cCo = c.getCoefficient();
		
		ArrayList<VariableTerm> VTerms = getVTerms(); 
		double coef = VTerms.get(index).getCoefficient();
		int power = VTerms.get(index).getPower();
		char v = VTerms.get(i).getVar();
			
	}

}
