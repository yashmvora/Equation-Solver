package tests.cmdTests;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Scanner;
import org.junit.Test;

import command.cmdSolveQuadratic;

public class cmdSolveQuadraticTest {
	
	@Test
	public void test1() {
		setOutput();
		Scanner in = new Scanner("x^2+4x+4=0");
		new cmdSolveQuadratic().execute(in);
		assertEquals("",getOutput());
		
	}
	
	//Output checking support
	PrintStream oldPrintStream;
	ByteArrayOutputStream bos;

	private void setOutput() throws Exception {
		oldPrintStream = System.out;
		bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));
	}

	private String getOutput() { // throws Exception
		System.setOut(oldPrintStream);
		return bos.toString();
	}
}
