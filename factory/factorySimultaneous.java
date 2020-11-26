
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


	public SimultaneousEquation factoryMethod(ArrayList<String>input) {
		ArrayList<LinearEquation> result = new ArrayList<>();
		
		for(int i =0; i<input.size();i++) {
			result.add((LinearEquation) factoryLinear.getInstance().factoryMethod(input.get(i)));
		}
		
		return new SimultaneousEquation(result);
	}

}
