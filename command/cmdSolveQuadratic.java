package command;

import java.util.ArrayList;
import java.util.Scanner;

import equation.CubicEquation;
import equation.QuadraticEquation;
import equation.SimultaneousEquation;
import factory.factoryCubic;
import factory.factoryQuadratic;
import factory.factorySimultaneous;
import input.InputProcessor;
import input.InputValidator;
import input.TextInput;
import solution.Solution;

public class cmdSolveQuadratic implements Command {
	
	private static cmdSolveQuadratic instance = new cmdSolveQuadratic();
	
	private cmdSolveQuadratic() {
		
	}

	@Override
	public void execute() {
		Scanner in = TextInput.getInstance().getScanner();
		String inEq = in.nextLine();
		inEq= InputProcessor.getInstance().handleInput(inEq);
		if (InputValidator.getInstance().isValid(inEq)) {
			inEq=InputProcessor.getInstance().changeBrackets(inEq);
			QuadraticEquation eq = (QuadraticEquation) factoryQuadratic.getInstance().factoryMethod(inEq);
			ArrayList<Solution>solutions = eq.solve();
			System.out.println("Simplified: "+eq.toString());
			for(Solution s: solutions)
				System.out.println(s.toString());
		}	
	}
	
	public static cmdSolveQuadratic getInstance() {
		return instance;
	}

}
