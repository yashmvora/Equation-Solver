package command;

import equation.QuadraticEquation;
import equation.SimultaneousEquation;
import factory.factorySimulteneous;
import input.InputValidator;

public class cmdSolveLinear implements Command {
	
	private static cmdSolveLinear instance = new cmdSolveLinear();
	
	private cmdSolveLinear() {
		
	}

	@Override
	public void execute(String[] args) {
		
		SimultaneousEquation eq = factorySimulteneous.getInstance().factoryMethod(args);

	}
	
	public static cmdSolveLinear getInstance() {
		return instance;
	}

}
