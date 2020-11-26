package command;

import java.util.ArrayList;
import java.util.Scanner;

import equation.CubicEquation;
import factory.factoryCubic;
import input.InputValidator;
import input.TextInput;
import solution.Solution;

public class cmdSolveCubic implements Command {

	private static cmdSolveCubic instance = new cmdSolveCubic();

	private cmdSolveCubic() {

	}

	@Override
	public void execute() {
		Scanner in = TextInput.getInstance().getScanner();
		String inEq = in.nextLine();
		
		if (InputValidator.getInstance().isValid(inEq)) {
			CubicEquation eq = (CubicEquation) factoryCubic.getInstance().factoryMethod(inEq);
			ArrayList<Solution>solutions = eq.solve();
			System.out.println("Simplified: "+eq.toString());
			for(Solution s: solutions)
				System.out.println(s.toString());
		}

	}

	public static cmdSolveCubic getInstance() {
		return instance;
	}

}
