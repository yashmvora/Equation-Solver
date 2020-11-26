package input;

import java.util.*;

import command.cmdSolveCubic;
import command.cmdSolveLinear;
import command.cmdSolveQuadratic;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hi! Welcome to your friendly neighbourhood Equation Solver!");
		System.out.println("This program can simplify the equations you input and then solve them for you!");
		Scanner in = TextInput.getInstance().getScanner();
		int input;
		do {
			
			System.out.println("Enter the type of equation you wish to solve:\n1 : Simultaneous Linear Equations\n2: Quadratic Equation\n3: Cubic Equation\n-1: Terminate the program");
					
			input = in.nextInt();
			String input1 = in.nextLine();
			if (input==1) {
				cmdSolveLinear.getInstance().execute();
			} else if (input==2) {
				cmdSolveQuadratic.getInstance().execute();
			} else if (input==3) {
				cmdSolveCubic.getInstance().execute();
			}
			else if(input==-1) {
				System.out.println("Thank you for using the Equation Solver! Have a good day!");
			}
			else if(input<-1||input>3){
				System.out.println("Invalid choice.");
				
			}
		} while(input==-1);
	}
}
