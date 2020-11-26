package command;

import java.util.ArrayList;
import java.util.Scanner;

import equation.CubicEquation;
import equation.QuadraticEquation;
import equation.SimultaneousEquation;
import factory.factoryCubic;
import factory.factorySimultaneous;
import input.InputProcessor;
import input.InputValidator;
import input.TextInput;
import solution.Solution;

public class cmdSolveLinear implements Command {

	private static cmdSolveLinear instance = new cmdSolveLinear();

	private cmdSolveLinear() {

	}

	@Override
	public void execute() {
		ArrayList<String> inEqs = new ArrayList<>();
		String temp;
		Scanner in = TextInput.getInstance().getScanner();
		boolean valid = true;
		do {
			temp = in.nextLine();
			if (!temp.equals("done"))
				inEqs.add(InputProcessor.getInstance().handleInput(temp));
		} while (!temp.equals("done"));
		for (String eq : inEqs) {
			if (!InputValidator.getInstance().isValid(eq)) {
				valid = false;
			}
		}

		for (int i = 0; i < inEqs.size(); i++) {
			inEqs.set(i, InputProcessor.getInstance().changeBrackets(inEqs.get(i)));
		}

		if (valid) {
			SimultaneousEquation eq = factorySimultaneous.getInstance().factoryMethod(inEqs);
			ArrayList<Solution>solutions= eq.solve();
			for(Solution s:solutions) {
				System.out.println(s.toString());
			}
			
		}
		
	}

	public static cmdSolveLinear getInstance() {
		return instance;
	}

}
