package myPackage;

import java.util.Scanner;

public class vigenere {
	public static String vCipher(String text, boolean encrypt) {
		text = text.toLowerCase();
		Scanner in = new Scanner(System.in);
		String key = text;
		String newText = text;
		
		if (encrypt == true) {
			System.out.println("Insert the keyphrase you want to encrypt the text with.");
			key = in.nextLine();
			key = key.toLowerCase();
			newText = vEncryption(text, key);
		} else if (encrypt == false) {
			System.out.println("Insert the keyphrase that was used to encrypt the text.");
			key = in.nextLine();
			key = key.toLowerCase();
			newText = vDecryption(text, key);
		}

		return newText;
	}
	
	public static String vEncryption(String text, String key) {
		String newText = text;
		int position = 0;
		int i = 0;
		int j = 0;
		char[] newTextChar = newText.toCharArray();
		while (i < text.length()) {
			while (text.charAt(i) == ' ') {
				i++;
				j++;
			}
			if (j < key.length()) {
				position = (text.charAt(i) + key.charAt(j)) % 26;
			} else {
				j = 0;
				position = (text.charAt(i) + key.charAt(j)) % 26;
			}
			newTextChar[i] = position < 27 ? (char)(position + 'a' - 12) : (char)(position + 'A' - 12);
			if (newTextChar[i] < 'a') {
				newTextChar[i] = (char)(position + 'a' + 14);
			}
			i++;
			j++;
		}
		newText = new String(newTextChar);
		return newText;
	}
	
	public static String vDecryption(String text, String key) {
		String originalText = text;
		int position = 0;
		int i = 0;
		int j = 0;
		char[] originalTextChar = originalText.toCharArray();
		while (i < text.length()) {
			while (text.charAt(i) == ' ') {
				i++;
				j++;
			}
			if (j < key.length()) {
				position = (text.charAt(i) - key.charAt(j) + 26) % 26;
			} else {
				j = 0;
				position = (text.charAt(i) - key.charAt(j) + 26) % 26;
			}
			originalTextChar[i] = position < 27 ? (char)(position + 'a') : (char)(position + 'A');
			if (originalTextChar[i] < 'a') {
				originalTextChar[i] = (char)(position + 'a');
			}
			i++;
			j++;
		}
		originalText = new String(originalTextChar);
		return originalText;
	}
}