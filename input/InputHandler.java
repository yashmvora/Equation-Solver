package input;
import java.util.Scanner;

import command.cmdSolveCubic;
import command.cmdSolveLinear;

public class InputHandler {
	private static InputHandler instance = new InputHandler();

	
	public static InputHandler getInstance() {
		return instance;
	}
    
}
