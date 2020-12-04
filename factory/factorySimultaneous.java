
package factory;

import java.util.ArrayList;

import equation.*;
import input.linearPostValidator;
import input.quadraticPostValidator;

public class factorySimultaneous {

	private static factorySimultaneous instance = new factorySimultaneous();

	public static factorySimultaneous getInstance() {
		return instance;
	}

	private factorySimultaneous() {
	}

	public SimultaneousEquation factoryMethod(ArrayList<String> input) {
		ArrayList<LinearEquation> equations = new ArrayList<>();

		for (int i = 0; i < input.size(); i++) {
			LinearEquation temp = (LinearEquation) factoryLinear.getInstance().factoryMethod(input.get(i));
			if(temp==null) {
				return null;
			}
			equations.add(temp);
		}

		if (linearPostValidator.getInstance().isValidSimul(equations))
			return new SimultaneousEquation(equations);
		return null;
	}

}
