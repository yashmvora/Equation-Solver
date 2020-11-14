
package factory;
import java.util.ArrayList;

import equation.*;

public class factorySimulteneous{
	
	private static factorySimulteneous instance = new factorySimulteneous();

	public static factorySimulteneous getInstance() {
		return instance;
	}

	private factorySimulteneous() {
	}


	public SimultaneousEquation factoryMethod(String[]input) {
		ArrayList<LinearEquation> result = new ArrayList<>();
		
		for(int i =1; i<input.length;i++) {
			result.add((LinearEquation) factoryLinear.getInstance().factoryMethod(input[i]));
		}
		
		return new SimultaneousEquation(result);
	}

}
