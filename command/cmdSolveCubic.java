package command;

import java.util.ArrayList;
import java.util.Scanner;

import equation.CubicEquation;
import factory.factoryCubic;
import input.InputProcessor;
import input.InputValidator;
import input.TextInput;
import solution.Solution;

public class cmdSolveCubic implements Command {

	private static cmdSolveCubic instance = new cmdSolveCubic();

	private cmdSolveCubic() {

	}

	@Override
	public void execute() {
		System.out.println("Enter a cubic equation:");
		Scanner in = TextInput.getInstance().getScanner();
		String inEq = in.nextLine();
		inEq= InputProcessor.getInstance().handleInput(inEq);
		if (InputValidator.getInstance().isValid(inEq)) {
			inEq=InputProcessor.getInstance().changeBrackets(inEq);
			CubicEquation eq = (CubicEquation) factoryCubic.getInstance().factoryMethod(inEq);
			ArrayList<Solution>solutions = eq.solve();
			System.out.println("Answers:");
			for(Solution s: solutions)
				System.out.println(s.toString());
		}
	}

	public static cmdSolveCubic getInstance() {
		return instance;
	}

}
