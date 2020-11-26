package input;

import java.util.*;

import command.cmdSimplify;
import command.cmdSolveCubic;
import command.cmdSolveLinear;
import command.cmdSolveQuadratic;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hi! Welcome to your friendly neighbourhood Equation Solver!");
		System.out.println("This program can simplify the equations you input and then solve them for you!");
		Scanner in = TextInput.getInstance().getScanner();
		String input;
		do {
			
			System.out.println("\nEnter the type of equation you wish to solve:\n1 : Simultaneous Linear Equations\n2: Quadratic Equation\n3: Cubic Equation\n-1: Terminate the program");
					
			input = in.nextLine();
			String input1 = in.nextLine();
			if (input.equals("1")) {
				new cmdSolveLinear().execute();
			} else if (input.equals("2")) {
				new cmdSolveQuadratic().execute();
			} else if (input.equals("3")) {
				new cmdSolveCubic().execute();
			}
			else if(input.equals("4")) {
				new cmdSimplify().execute();
			}
			else if(input.equals("-1")) {
				System.out.println("Thank you for using the Equation Solver! Have a good day!\n____________________________________________________");
			}
			else {
				System.out.println("Invalid choice.");
				
			}
		} while(!input.equals("-1"));
	}
}
