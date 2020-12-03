package input;
import java.util.*;

import equation.LinearEquation;
import equation.Term;
import equation.VariableTerm;

public class SimultaneousPostValidator{

    private static SimultaneousPostValidator instance = new SimultaneousPostValidator();

	public static SimultaneousPostValidator getInstance() {
		return instance;
    }

    public boolean isValid(ArrayList<LinearEquation> equations){
    	HashMap<Character, Integer> variables = new HashMap<Character, Integer>();
    	for(LinearEquation eq :equations) {
    		ArrayList<VariableTerm>terms=eq.getVTerms();
    		for(VariableTerm t:terms) {
    			variables.put(t.getVar(),t.getPower());
    		}
    	}
    	
    	if(variables.size()==equations.size()) {
    		return true;
    	}
    	return false;
    	
    }
}