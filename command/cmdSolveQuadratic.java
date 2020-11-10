package command;

public class cmdSolveQuadratic implements Command {
	
	private static cmdSolveQuadratic instance = new cmdSolveQuadratic();
	
	private cmdSolveQuadratic() {
		
	}

	@Override
	public void execute(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static cmdSolveQuadratic getInstance() {
		return instance;
	}

}
