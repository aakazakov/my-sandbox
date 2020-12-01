package dev.fun.arrays.examples;

public class ReverseString {

	public static String reverse(String str) {		
		StringBuilder reversed = new StringBuilder();		
		for (int i = str.length() - 1; i >= 0; i--) {
			char ch = str.charAt(i);
			reversed.append(ch);
		}		
		return reversed.toString();
	}
	
	private ReverseString() {
		
	}
}
