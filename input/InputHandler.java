package input;
import java.util.Scanner;

import command.cmdSolveCubic;
import command.cmdSolveLinear;

public class InputHandler {
	private static InputHandler instance = new InputHandler();

	
	public static InputHandler getInstance() {
		return instance;
	}
	
	public String handleInput(String exp){
		String updated;
		updated=removeSpaces(exp);
		updated=changeBrackets(updated);
		return updated;
	}

	public String removeSpaces(String exp) {
    	return exp.replaceAll(" ", "");
    }
    
    public String changeBrackets(String exp) {
    	for (int i=0;i<exp.length();i++){
    		if (exp.charAt(i)=='{'||exp.charAt(i)=='[') {
    			exp=exp.substring(0,i)+'('+exp.substring(i+1);
    		}
    		else if(exp.charAt(i)=='}'||exp.charAt(i)==']') {
    			exp=exp.substring(0,i)+')'+exp.substring(i+1);
    		}
    	}
    	return exp;
    }

}
