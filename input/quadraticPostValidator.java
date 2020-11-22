package input;
import java.util.*;

public class quadraticPostValidator extends PostValidator{

    private static quadraticPostValidator instance = new quadraticPostValidator();

	public static quadraticPostValidator getInstance() {
		return instance;
    }

    public boolean isValid(String exp){
        if(checkDegree(exp)==2 && checkVariables(exp)){
            return true;
        }
        return false;
    }
}