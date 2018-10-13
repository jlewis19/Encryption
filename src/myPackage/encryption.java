package myPackage;

import java.util.Scanner;
import myPackage.vigenere;
import java.io.IOException;

public class encryption {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		vigenere v = new vigenere();
		caesar c = new caesar();
		writeFile w = new writeFile();
		
		System.out.println("Do you want to encrypt (e) or decrypt (d) text?");
		String method = in.nextLine();
		
		while (!method.equals("e") && !method.equals("d")) {
			System.out.println("Please enter either \"e\" to encrypt or \"d\" to decrypt.");
			method = in.nextLine();
		}
		
		boolean encrypt = false;
		if (method.equals("e")) {
			System.out.println("You have selected encryption.");
			encrypt = true;
		} else if (method.equals("d")) {
			System.out.println("You have selected decrpytion.");
			encrypt = false;
		}
		
		System.out.println("Do you want to use a Caesar cipher (c) or a Vigenere cipher (v)?");
		String cipher = in.nextLine();
		
		while (!cipher.equals("c") && !cipher.equals("v")) {
			System.out.println("Please enter either \"c\" for a Caesar cipher, or \"v\" for a Vigenere cipher, or \"o\" for your own cipher.");
			cipher = in.nextLine();
		}
		
		if (cipher.equals("c")) {
			System.out.println("You have selected the Caesar cipher.");
		} else if (cipher.equals("d")) {
			System.out.println("You have selected the Vigenere cipher.");
		}
		
		String text = "text";
		String encryption = text;
		String decryption = text;
		
		if (encrypt == true) {
			System.out.println("Insert the text you want to encrypt.");
			text = in.nextLine();
			if (cipher.equals("c")) {
				encryption = c.cCipher(text, encrypt);
			} else if (cipher.equals("v")) {
				encryption = v.vCipher(text, encrypt);
			}
			System.out.println("The encrypted text is \"" + encryption + ".\"");
		} else if (encrypt == false) {
			System.out.println("Insert the text you want to decrypt.");
			text = in.nextLine();
			if (cipher.equals("c")) {
				decryption = c.cCipher(text, encrypt);
			} else if (cipher.equals("v")) {
				decryption = v.vCipher(text, encrypt);
			}
			System.out.println("The decrypted text is \"" + decryption + ".\"");
		}
		
		System.out.println("Would you like copy this information to a file? (y/n)");
		String write = in.nextLine();
		while (!write.equals("y") && !write.equals("n")) {
			System.out.println("Please insert \"y\" for yes and \"n\" for no.");
			write = in.nextLine();
		}
		
		String file = text;
		if (write.equals("y")) {
			if (method.equals("e")) {
				file = "Original text: " + text + "\nEncrypted text: " + encryption;
				w.write(file.length(), file);
			} else {
				file = "Encrypted text: " + text + "\nDecrypted text: " + decryption;
				w.write(file.length(), file);
			}
		}
		
		in.close();
	}
}