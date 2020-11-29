package tests.simplifyTests;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.junit.jupiter.api.Test;

import simplify.Simplify;
public class splitIntoTermsTest {
	
	public String ListToString(ArrayList<String>[] terms) {
		String result ="";
		for(int i=0;i<terms[1].size();i++) {
			char x = terms[1].get(i).charAt(0);
			if(x=='-'||x=='+') {
				result+=terms[1].get(i);
			}
			else
				result+="+"+terms[1].get(i);
		}
		for(int i=0;i<terms[0].size();i++) {
			char x = terms[0].get(i).charAt(0);
			if(x=='-'||x=='+') {
				result+=terms[0].get(i);
			}
			else
				result+="+"+terms[0].get(i);
		}
		return result;
	}
	@Test
	void test1() {
		Simplify sim = Simplify.getInstance();
		ArrayList<String>[] result = sim.splitIntoTerms("2x+3x+5");
		ArrayList<String>[] terms = new ArrayList[2];
		terms[0] = new ArrayList<String>();
		terms[1] = new ArrayList<String>();
		terms[1].add("+2x");
		terms[1].add("+3x");
		terms[0].add("5");
		assertEquals(ListToString(terms),ListToString(result));	
	}
	@Test
	void test2() {
		Simplify sim = Simplify.getInstance();
		ArrayList<String>[] result = sim.splitIntoTerms("+x^2-3");
		ArrayList<String>[] terms = new ArrayList[2];
		terms[0] = new ArrayList<String>();
		terms[1] = new ArrayList<String>();
		terms[1].add("+x^2");
		terms[0].add("-3");
		assertEquals(ListToString(terms),ListToString(result));	
	}
	@Test
	void test3() {
		Simplify sim = Simplify.getInstance();
		ArrayList<String>[] result = sim.splitIntoTerms("-x^2+3");
		ArrayList<String>[] terms = new ArrayList[2];
		terms[0] = new ArrayList<String>();
		terms[1] = new ArrayList<String>();
		terms[1].add("-x^2");
		terms[0].add("+3");
		assertEquals(ListToString(terms),ListToString(result));	
	}
	@Test
	void test4() {
		Simplify sim = Simplify.getInstance();
		ArrayList<String>[] result = sim.splitIntoTerms("-x^2+7x*-3+7");
		ArrayList<String>[] terms = new ArrayList[2];
		terms[0] = new ArrayList<String>();
		terms[1] = new ArrayList<String>();
		terms[1].add("-x^2");
		terms[1].add("+7x*-3");
		terms[0].add("+7");
		assertEquals(ListToString(terms),ListToString(result));	
	}
	
}