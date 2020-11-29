package tests.InputValidatorTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import input.InputValidator;

public class isValidTest {
	@Test
	void test1() {
		InputValidator inputValidator = new InputValidator();
		String input= "$";
		boolean result = inputValidator.isValid(input);
		assertEquals(false, result);
	}
	@Test
	void test2() {
		InputValidator inputValidator = new InputValidator();
		String input= "(";
		boolean result = inputValidator.isValid(input);
		assertEquals(false, result);
	}
	@Test
	void test3() {
		InputValidator inputValidator = new InputValidator();
		String input= "2+";
		boolean result = inputValidator.isValid(input);
		assertEquals(false, result);
	}
	@Test
	void test4() {
		InputValidator inputValidator = new InputValidator();
		String input= ".x";
		boolean result = inputValidator.isValid(input);
		assertEquals(false, result);
	}

}
