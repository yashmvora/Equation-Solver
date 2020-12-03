package input;
import java.util.*;

import equation.Term;

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
}