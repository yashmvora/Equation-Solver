package tests.postValidatorTests;
import org.junit.Test;
import static org.junit.Assert.*;
import input.*;

public class checkDegreeTest{

	@Test
	public void test1() {
		PostValidator postValidator = PostValidator.getInstance(); 
		String input = "x";
		int degree=postValidator.checkDegree(input);
		assertEquals(1,degree);
	}

	
	@Test
	public void test2() {
		PostValidator postValidator = PostValidator.getInstance(); 
		String input = "x^2";
		int degree=postValidator.checkDegree(input);
		assertEquals(2,degree);
	}
	
	
	@Test
	public void test3() {
		PostValidator postValidator = PostValidator.getInstance(); 
		String input = "x^2+x^3";
		int degree=postValidator.checkDegree(input);
		assertEquals(3,degree);
	}
	
	@Test
	public void test5() {
		PostValidator postValidator = PostValidator.getInstance(); 
		String input = "";
		int degree=postValidator.checkDegree(input);
		assertEquals(0,degree);
	}
	
	@Test
	public void test6() {
		PostValidator postValidator = PostValidator.getInstance(); 
		String input = "9742";
		int degree=postValidator.checkDegree(input);
		assertEquals(0,degree);
	}
}
