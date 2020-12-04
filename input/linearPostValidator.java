package input;
import java.util.*;

import equation.LinearEquation;
import equation.Term;
import equation.VariableTerm;

public class linearPostValidator extends PostValidator{

    private static linearPostValidator instance = new linearPostValidator();

	public static linearPostValidator getInstance() {
		return instance;
    }

    public boolean isValid(ArrayList<Term>terms){
    	String exp = arrayToString(terms);
        if(checkDegree(exp)==1){
            return true;
        }
        System.out.println("The Equation is not a Linear one");
        return false;
    }
    
    public boolean isValidSimul(ArrayList<LinearEquation> equations){
    	
    	for(LinearEquation eq :equations) {
    		HashMap<Character, Integer> variables = new HashMap<Character, Integer>();
    		ArrayList<VariableTerm>terms=eq.getVTerms();
    		for(VariableTerm t:terms) {
    			variables.put(t.getVar(),t.getPower());
    		}
    		if(variables.size()!=equations.size()) {
        		return false;
        	}
    	}
    	
    	
    	return true;
    	
    }
}