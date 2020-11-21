package input;

import java.util.ArrayList;
import java.util.Stack;
import java.util.HashMap;

public class InputValidator {
	private static InputValidator instance = new InputValidator();

	public static InputValidator getInstance() {
		return instance;

	}

	public boolean isValid(String exps) {
		String[] exp = exps.split("");
		if (!bracketsValid(exp)) {
			return false;
		}
		if (!operatorsValid(exp)) {
			return false;
		}
		return true;
	}

	public boolean operatorsValid(String[] exp) {
		if (exp[0].matches("[*/^]+") || exp[exp.length - 1].matches("[+\\-*/^]+")) {
			return false;
		}
		for (int i = 1; i < exp.length - 1; i++) {
			if (exp[i].equals("+") || exp[i].equals("-")) {
				if (exp[i + 1].matches("[*/^]+")) {
					return false;
				}
				if (!exp[i - 1].matches("[A-Za-z0-9]+") && !exp[i + 1].matches("[A-Za-z0-9]+")) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean bracketsValid(String[] exp) {
		Stack<String> stack = new Stack<>();
		for (String e : exp) {
			if (e.matches("[({\\[]+")) {
				stack.push(e);
			} else if (e.equals(")")) {
				if (stack.isEmpty()) {
					return false;
				}
				if (stack.peek().equals("(")) {
					stack.pop();
				} else {
					return false;
				}

			} else if (e.equals("}")) {
				if (stack.isEmpty()) {
					return false;
				}
				if (stack.peek().equals("{")) {
					stack.pop();
				} else {
					return false;
				}

			} else if (e.equals("]")) {
				if (stack.isEmpty()) {
					return false;
				}
				if (stack.peek().equals("[")) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		if (!stack.empty()) {
			return false;
		}
		return true;
	}

	public int checkDegree(char[] exp) {
		int degree = 0;
		boolean lessthan2 = true;

		for (int i = 0; i < exp.length; i++) {
			if (exp[i] == '^') {
				lessthan2 = false;
			}
		}

		if (lessthan2) {
			for (int i = 0; i < exp.length; i++) {
				if (Character.toString(exp[i]).matches("[A-Za-z]")) {
					degree = 1;
				}
			}
		}

		if (!lessthan2) {
			for (int i = 0; i < exp.length - 1; i++) {
				if (exp[i] == '^') {
					degree = Math.max(degree, Character.getNumericValue(exp[i + 1]));
				}
			}
		}

		return degree;
	}

	public boolean checkInvalidChars(String[] exp) {
		for (int i = 0; i < exp.length; i++) {
			if (exp[i].matches("[A-Za-z0-9+\\-/(){}\\[\\]*^]")) {
				continue;
			} else {
				return true;
			}
		}
		return false;
	}

//postchecking
	public boolean checkNumberofEqs(String[] exp) {
		int eqs = 0;
		HashMap<Character, Integer> variables = new HashMap<Character, Integer>();

		for (int i = 0; i < exp.length; i++) {
			eqs++;
			for (int j = 0; j < exp[i].length(); j++) {
				if (Character.toString(exp[i].charAt(j)).matches("[A-Za-z]")) {
					if (variables.containsKey(exp[i].charAt(j))) {
						int num = variables.get(exp[i].charAt(j));
						variables.replace(exp[i].charAt(j), num += 1);
					} else {
						variables.put(exp[i].charAt(j), 0);
					}
				}
			}
		}
		if (eqs == variables.size()) {
			return true;
		}
		return false;
	}

	public boolean checkDecimal(String[] exp) {
		for (int i = 0; i < exp.length; i++) {
			if (exp[i] == ".") {
				for (int j = 0; j < exp.length; j++) {
					if (exp[j].matches("[A-Za-z]")) {
						return false;
					} else if (exp[j].matches("[+*/-]+")) {
						break;
					}
				}
			}
		}
		return true;
	}

	public boolean checkConstantPowers(String[] exp) {
		for (int i = 1; i < exp.length; i++) {
			if (exp[i] == "^") {
				if (exp[i - 1].matches("[0-9]")) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean checkAfterVariable(String[] exp) {
		for (int i = 0; i < (exp.length - 1); i++) {
			if (exp[i].matches("[A-Za-z]")) {
				if (exp[i + 1].matches("[0-9]")) {
					return false;
				}
			}
		}
		return true;
	}

}
