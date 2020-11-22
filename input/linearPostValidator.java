package input;
import java.util.*;

public class linearPostValidator extends PostValidator{

    private static linearPostValidator instance = new linearPostValidator();

	public static linearPostValidator getInstance() {
		return instance;
    }

    public boolean isValid(String exp){
        if(checkDegree(exp)==1 && checkVariables(exp)){
            return true;
        }
        return false;
    }
}