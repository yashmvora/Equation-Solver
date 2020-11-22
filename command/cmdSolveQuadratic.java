package command;

import java.util.Scanner;

import equation.CubicEquation;
import equation.QuadraticEquation;
import equation.SimultaneousEquation;
import factory.factoryCubic;
import factory.factoryQuadratic;
import factory.factorySimultaneous;
import input.InputValidator;
import input.TextInput;

public class cmdSolveQuadratic implements Command {
	
	private static cmdSolveQuadratic instance = new cmdSolveQuadratic();
	
	private cmdSolveQuadratic() {
		
	}

	@Override
	public void execute() {
		Scanner in = TextInput.getInstance().getScanner();
		String inEq = in.nextLine();
		
		if (InputValidator.getInstance().isValid(inEq)) {
			QuadraticEquation eq = (QuadraticEquation) factoryQuadratic.getInstance().factoryMethod(inEq);
			System.out.println("Simplified: "+eq.toString());
		}	
	}
	
	public static cmdSolveQuadratic getInstance() {
		return instance;
	}

}
