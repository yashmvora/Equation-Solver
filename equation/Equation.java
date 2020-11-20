package equation;
import java.util.*;
public abstract class Equation {
    // class for breaking down the equation

    private ArrayList<Term> terms;

    public Equation(ArrayList<Term> terms){
        this.terms=terms;
    }
    

    public String toString(){
      return null;  
    }
    
    public ConstantTerm getConstant() {
    	for(Term term:terms) {
    		if(term instanceof ConstantTerm ) {
    			return (ConstantTerm) term;
    		}
    	}
    	return new ConstantTerm("0.0");
    }
}