package input;

import java.util.*;

import command.cmdSolveCubic;
import command.cmdSolveLinear;

public class Main {
	public static void main(String[] args) {
		Scanner in = TextInput.getInstance().getScanner();
		System.out.print("");
		int input = in.nextInt();
		String input1 = in.nextLine();
		if (input==1) {
			cmdSolveLinear.getInstance().execute();
		} else if (input==2) {
			cmdSolveLinear.getInstance().execute();
		} else if (input==3) {
			cmdSolveCubic.getInstance().execute();
		}
	}
}
