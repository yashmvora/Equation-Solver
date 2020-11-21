package command;

import equation.CubicEquation;
import factory.factoryCubic;
import input.InputValidator;

public class cmdSolveCubic implements Command {

	private static cmdSolveCubic instance = new cmdSolveCubic();

	private cmdSolveCubic() {

	}

	@Override
	public void execute(String[] args) {
		if (InputValidator.getInstance().isValid(args[1])) {
			CubicEquation eq = (CubicEquation) factoryCubic.getInstance().factoryMethod(args[1]);
		}

	}

	public static cmdSolveCubic getInstance() {
		return instance;
	}

}
