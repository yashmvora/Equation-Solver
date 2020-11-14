package command;

import equation.CubicEquation;
import factory.factoryCubic;

public class cmdSolveCubic implements Command {
	
	private static cmdSolveCubic instance = new cmdSolveCubic();
	
	private cmdSolveCubic() {
		
	}

	@Override
	public void execute(String[] args) {
		CubicEquation eq = factoryCubic.getInstance().factoryMethod(args[1]);
	}
	
	public static cmdSolveCubic getInstance() {
		return instance;
	}

}
