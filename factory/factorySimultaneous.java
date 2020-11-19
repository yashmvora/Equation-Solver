
package factory;
import java.util.ArrayList;

import equation.*;

public class factorySimultaneous{
	
	private static factorySimultaneous instance = new factorySimultaneous();

	public static factorySimultaneous getInstance() {
		return instance;
	}

	private factorySimultaneous() {
	}


	public SimultaneousEquation factoryMethod(String[]input) {
		ArrayList<LinearEquation> result = new ArrayList<>();
		
		for(int i =1; i<input.length;i++) {
			result.add((LinearEquation) factoryLinear.getInstance().factoryMethod(input[i]));
		}
		
		return new SimultaneousEquation(result);
	}

}
