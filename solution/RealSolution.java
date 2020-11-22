package solution;

import equation.VariableTerm;

public class RealSolution implements Solution {
	private VariableTerm variable;
	private double value;
	private boolean solutionExists;
	
	public RealSolution(VariableTerm var, double val) {
		this.variable=var;
		this.value=val;
	}
	
	@Override
	public String toString() {
		return String.format("%s=%d", variable.toString(), value);
	}

}
