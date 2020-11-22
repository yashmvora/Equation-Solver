package equation;
import java.util.*;
public abstract class Equation {
    // class for breaking down the equation

    private ArrayList<Term> terms;

    public Equation(ArrayList<Term> terms){
        this.terms=terms;
    }
    

    public abstract String toString();
    
    public ConstantTerm getConstant() {
    	for(Term term:terms) {
    		if(term instanceof ConstantTerm ) {
    			return (ConstantTerm) term;
    		}
    	}
    	return new ConstantTerm("0.0");
    }
    
    public ArrayList<VariableTerm> getVTerms(){
    	ArrayList<VariableTerm>result = new ArrayList<>();
    	for(Term term:terms) {
    		if(term instanceof VariableTerm ) {
    			result.add( (VariableTerm) term);
    		}
    	}
    	return result;
    }
    
    public void addTerm(Term term) {
    	terms.add(term);
    }
    
}