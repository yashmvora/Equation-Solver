package simplifyTests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import simplify.Simplify;
public class getVarTest {
	@Test
	void test1() {
		Simplify sim = Simplify.getInstance();
		String result = sim.getVar("2x");
		assertEquals("x", result);
	}
	@Test
	void test2() {
		Simplify sim = Simplify.getInstance();
		String result = sim.getVar("2x^3");
		assertEquals("x^3", result);
	}
	@Test
	void test3() {
		Simplify sim = Simplify.getInstance();
		String result = sim.getVar("x");
		assertEquals("x", result);
	}
	@Test
	void test5() {
		Simplify sim = Simplify.getInstance();
		String result = sim.getVar("2x^2");
		assertEquals("x^2", result);
	}
	@Test
	void test6() {
		Simplify sim = Simplify.getInstance();
		String result = sim.getVar("+2x^2");
		assertEquals("x^2", result);
	}
	@Test
	void test7() {
		Simplify sim = Simplify.getInstance();
		String result = sim.getVar("-2.0x^2");
		assertEquals("x^2", result);
	}
	@Test
	void test8() {
		Simplify sim = Simplify.getInstance();
		String result = sim.getVar("2^3x^2");
		assertEquals("x^2", result);
	}
}
