package InputHandlerTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import input.InputHandler;

class changeBracketsTest{

	@Test
	void test1() {
		InputHandler inputHandler = InputHandler.getInstance();
		String input="{[x+1]}";
		String result = inputHandler.changeBrackets(input);
		assertEquals("((x+1))", result);
	}

	@Test
	void test2() {
		InputHandler inputHandler = InputHandler.getInstance();
		String input="";
		String result = inputHandler.changeBrackets(input);
		assertEquals("", result);
	}
}

