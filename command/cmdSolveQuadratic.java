package command;

import java.util.Scanner;

import equation.CubicEquation;
import equation.QuadraticEquation;
import equation.SimultaneousEquation;
import factory.factoryCubic;
import factory.factoryQuadratic;
import factory.factorySimultaneous;
import input.InputValidator;

public class cmdSolveQuadratic implements Command {
	
	private static cmdSolveQuadratic instance = new cmdSolveQuadratic();
	
	private cmdSolveQuadratic() {
		
	}

	@Override
	public void execute() {
		Scanner in = new Scanner(System.in);
		String in.nextLine();
		
		
		if (InputValidator.getInstance().isValid(args[1])) {
			QuadraticEquation eq = (QuadraticEquation) factoryQuadratic.getInstance().factoryMethod(args[1]);
		}	
	}
	
	public static cmdSolveQuadratic getInstance() {
		return instance;
	}

}
