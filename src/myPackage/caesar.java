package myPackage;

import java.util.Scanner;

public class caesar {
	public static String cCipher(String text, boolean encrypt) {
		text = text.toLowerCase();
		Scanner in = new Scanner(System.in);
		String newText = text;
		int offset = 0;
		
		if (encrypt == true) {
			System.out.println("Insert the number (from 1 through 26) you want to offset the text with.");
			offset = in.nextInt();
			while (offset < 1 || offset > 26) {
				System.out.println("The offset should be a number from 1 through 26.");
				offset = in.nextInt();
			}
			newText = cEncryption(text, offset);
		} else {
			System.out.println("Insert the number (from 1 through 26) that was used on the text.");
			offset = in.nextInt();
			while (offset < 1 || offset > 26) {
				System.out.println("The offset should be a number from 1 through 26.");
				offset = in.nextInt();
			}
			newText = cDecryption(text, offset);
		}

		return newText;
	}
	
	public static String cEncryption(String text, int offset) {
		int length = text.length();
		
		char[] password = new char[length];
		
		for (int i = 0; i < length; i++) {
			while (text.charAt(i) == ' ') {
				password[i] = ' ';
				i++;
			}
			int position = text.charAt(i) - 'a';
			int positionOffSet = position + offset;
				if (positionOffSet >= 26) {
					positionOffSet -= 26;
					if (positionOffSet == 0) {
						positionOffSet += 1;
					}
				}
			char passwordLetter = (char)('a' + positionOffSet);
			password[i] = passwordLetter;
		}
		String newText = new String(password);
		return newText;
	}
	
	public static String cDecryption(String text, int offset) {
		char[] password = new char[text.length()];
		int positionOffSet;
		for (int i = 0; i < text.length(); i++) {
			while (text.charAt(i) == ' ') {
				password[i] = ' ';
				i++;
			}
			int position = text.charAt(i) - 'a';
			if (position - offset == 0) {
				positionOffSet = 0; 
			}
			else if(position-offset < 0) {
				int positionRemainder = position - offset;
				positionOffSet = 26 + positionRemainder;
			}
			else {
				positionOffSet = position - offset;
			}
			password[i] = (char)('a' + positionOffSet);
		}
		String oldText = new String(password);
		return oldText;
	}
}