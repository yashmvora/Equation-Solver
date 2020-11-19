package command;

import equation.QuadraticEquation;
import equation.SimultaneousEquation;
import factory.factorySimultaneous;
import input.InputValidator;

public class cmdSolveLinear implements Command {
	
	private static cmdSolveLinear instance = new cmdSolveLinear();
	
	private cmdSolveLinear() {
		
	}

	@Override
	public void execute(String[] args) {
		
		SimultaneousEquation eq = factorySimultaneous.getInstance().factoryMethod(args);

	}
	
	public static cmdSolveLinear getInstance() {
		return instance;
	}

}
