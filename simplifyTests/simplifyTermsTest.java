package simplifyTests;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.junit.jupiter.api.Test;

import simplify.Simplify;
public class simplifyTermsTest {
	
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
		ArrayList<String>[] terms = new ArrayList[2];
		terms[0] = new ArrayList<String>();
		terms[1] = new ArrayList<String>();
		terms[1].add("+2x*3");
		terms[1].add("-3x*5");
		terms[0].add("5");
		ArrayList<String>[] result = sim.simplifyTerms(terms);
		
		assertEquals(ListToString(result), ListToString(terms));
	}
}