package command;
import input.TextInput;
import java.util.*;
import simplify.Simplify;

public class cmdSimplify implements Command{
	public void execute() {
		System.out.println("Enter an expression to simplify:");
		Scanner abc = TextInput.getInstance().getScanner();
		String input = abc.nextLine();
		System.out.println(Simplify.getInstance().simplify(input));
	}
}
