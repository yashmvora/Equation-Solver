package input;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		System.out.print("");
		String input = in.nextLine();
		in.close();
		InputHandler.getInstance().handleInput(input);
    }
}
