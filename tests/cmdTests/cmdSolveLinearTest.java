package tests.cmdTests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class cmdSolveLinearTest {

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
	public void test1() {
		File file = createFile("test1.txt");
		write(file, "");
	}
	
}
