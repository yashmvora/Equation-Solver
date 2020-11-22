package command;

import java.util.ArrayList;
import java.util.Scanner;

import equation.CubicEquation;
import equation.QuadraticEquation;
import equation.SimultaneousEquation;
import factory.factoryCubic;
import factory.factorySimultaneous;
import input.InputValidator;
import input.TextInput;

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
			inEqs.add(temp);
		} while (!temp.equals("done"));
		inEqs.remove(inEqs.size());
		for (String eq : inEqs) {
			if (!InputValidator.getInstance().isValid(eq)) {
				valid = false;
			}
		}

		if (valid) {
			SimultaneousEquation eq = factorySimultaneous.getInstance().factoryMethod((String[])inEqs.toArray());
		}
	}

	public static cmdSolveLinear getInstance() {
		return instance;
	}

}
