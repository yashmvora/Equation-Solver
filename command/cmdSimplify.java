package command;
import input.TextInput;
import java.util.*;
import simplify.Simplify;
import input.InputProcessor;

public class cmdSimplify implements Command{
	public void execute() {
		System.out.println("Enter an expression to simplify:");
		Scanner abc = TextInput.getInstance().getScanner();
		String input = abc.nextLine();
		input = InputProcessor.getInstance().removeSpaces(input);
		input = InputProcessor.getInstance().changeBrackets(input);
		System.out.println("Answer:\n"+Simplify.getInstance().simplify(input));
	}
}
