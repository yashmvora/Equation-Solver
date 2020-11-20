package solution;

import equation.VariableTerm;

public class Solution {
	private VariableTerm variable;
	private double value;
	
	public Solution(VariableTerm var, double val) {
		this.variable=var;
		this.value=val;
	}
	
	@Override
	public String toString() {
		return String.format("%s=%d", variable.toString(), value);
	}

}
