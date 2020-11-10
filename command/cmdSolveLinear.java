package command;

public class cmdSolveLinear implements Command {
	
	private static cmdSolveLinear instance = new cmdSolveLinear();
	
	private cmdSolveLinear() {
		
	}

	@Override
	public void execute(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static cmdSolveLinear getInstance() {
		return instance;
	}

}
