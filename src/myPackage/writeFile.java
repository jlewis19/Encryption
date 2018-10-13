package myPackage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class writeFile {
	public static void write(int length, String password) throws IOException {
		Date date = new Date();
		BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/michaellewis/Library/Mobile Documents/com~apple~TextEdit/Documents/ciphers"));
		writer.append(date + "\n" + password + "\n");
		writer.newLine();
		writer.close();
	}
}