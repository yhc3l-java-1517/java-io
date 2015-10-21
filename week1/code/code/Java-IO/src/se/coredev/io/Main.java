package se.coredev.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public final class Main {

	public static void main(String[] args) {

		System.out.println("Encoding:" + System.getProperty("file.encoding"));
		
		System.out.println("Writing text");
		
		// Writing text
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/todays-message.txt"))) {
			writer.write("Hello world!");
			writer.newLine();			
			writer.write("This is a new line!");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Done writing. Reading text");
		
		// Reading text
		try (BufferedReader reader = new BufferedReader(new FileReader("src/todays-message.txt"))) {

			String line = null;

			while ((line = reader.readLine()) != null) {
				System.out.println(">" + line);
			}

		}
		catch (IOException e) {
			e.printStackTrace();
		 }
		System.out.println("Done reading");
	}
}
