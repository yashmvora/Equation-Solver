package equation;
import java.util.*;
public abstract class Equation {
    // class for breaking down the equation

    private ArrayList<Term> terms=new ArrayList<Term>();

    public Equation(ArrayList<Term> terms){
        this.terms=terms;
    }
    

    public String toString(){
		return null;
        
    }
}