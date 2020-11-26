package input;
import java.util.*;

public class quadraticPostValidator extends PostValidator{

    private static quadraticPostValidator instance = new quadraticPostValidator();

	public static quadraticPostValidator getInstance() {
		return instance;
    }

    public boolean isValid(String exp){
        if(checkDegree(exp)!=2){
            System.out.println("Equation is not a Quadratic one");
            return false;
        }

        if(!checkVariables(exp)){
            System.out.println("More than one variable in equation");
            return false;
        }
        return true;
    }
}