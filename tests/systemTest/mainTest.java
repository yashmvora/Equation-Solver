package tests.systemTest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

import input.Main;

public class mainTest {

	public File createFile(String filename) {
		File file = new File(filename);
		try {
			file.createNewFile();
		} catch(IOException e) {
			return null;
		}
		return file;
	}
	
	public void write(File file, String text) {
		try {
			FileWriter writer = new FileWriter(file);
			
			writer.write(text);
			writer.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test1() throws Exception{
		setOutput();
		File file = createFile("test1.txt");
		write(file, "1\n2x+y=0\n3x-5+0y=0\ndone\n-1");
		Scanner ob = new Scanner(file);
		String[] array= {"test"};
		new Main().main(array);
		file.delete();
		assertEquals("x=-1.67, y=3.33",getOutput().substring(getOutput().length()-15));
		
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
