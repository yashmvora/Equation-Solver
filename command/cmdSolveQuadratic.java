package command;

import equation.CubicEquation;
import equation.QuadraticEquation;
import factory.factoryCubic;
import factory.factoryQuadratic;

public class cmdSolveQuadratic implements Command {
	
	private static cmdSolveQuadratic instance = new cmdSolveQuadratic();
	
	private cmdSolveQuadratic() {
		
	}

	@Override
	public void execute(String[] args) {
		QuadraticEquation eq = (QuadraticEquation) factoryQuadratic.getInstance().factoryMethod(args[1]);

	}
	
	public static cmdSolveQuadratic getInstance() {
		return instance;
	}

}
