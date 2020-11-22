package input;
import java.util.*;

public class cubicPostValidator extends PostValidator{

    private static cubicPostValidator instance = new cubicPostValidator();

	public static cubicPostValidator getInstance() {
		return instance;
    }

    public boolean isValid(String exp){
        if(checkDegree(exp)==3 && checkVariables(exp)){
            return true;
        }
        return false;
    }
}