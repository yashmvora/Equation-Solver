package command;

public class cmdSolveCubic implements Command {
	
	private static cmdSolveCubic instance = new cmdSolveCubic();
	
	private cmdSolveCubic() {
		
	}

	@Override
	public void execute(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static cmdSolveCubic getInstance() {
		return instance;
	}

}
