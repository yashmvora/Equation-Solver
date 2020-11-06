package input;
import java.util.Scanner;

import command.cmdSolveCubic;
import command.cmdSolveLinear;

public class InputHandler {
	private static InputHandler instance = new InputHandler();

	
	public static InputHandler getInstance() {
		return instance;
	}
    public void handleInput(String input){
    	String[]args = input.split(" ");
    	if(args[0].equals("1")) {
    		cmdSolveLinear.getInstance().execute(args);
    	}else if(args[0].equals("2")) {
    		cmdSolveLinear.getInstance().execute(args);
    	}else if(args[0].equals("3")) {
    		cmdSolveCubic.getInstance().execute(args);
    	}
    }
}
