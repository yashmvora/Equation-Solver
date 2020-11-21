package command;

import equation.CubicEquation;
import equation.QuadraticEquation;
import equation.SimultaneousEquation;
import factory.factoryCubic;
import factory.factorySimultaneous;
import input.InputValidator;

public class cmdSolveLinear implements Command {
	
	private static cmdSolveLinear instance = new cmdSolveLinear();
	
	private cmdSolveLinear() {
		
	}

	@Override
	public void execute(String[] args) {
		if (InputValidator.getInstance().isValid(args[1])) {
			SimultaneousEquation eq = factorySimultaneous.getInstance().factoryMethod(args);
		}
		
		

	}
	
	public static cmdSolveLinear getInstance() {
		return instance;
	}

}
