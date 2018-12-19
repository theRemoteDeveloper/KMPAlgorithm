package com.pawel.kmp;
public class Main {

	public static void main(String[] args) {
		System.out.println("**** KMP Algorithm ****\n");
		
		KMP kmp = new KMP();
		String text = "ABABDABACDABABCABAB";
		String pattern = "ABABCABAB";
		
		System.out.print("i: [");
		for(int l=0; l<text.length(); l++) {
			System.out.print(" "+l);
		}
		System.out.println(" ]");
		
		System.out.print("P: [");
		for(int k=0; k<text.length(); k++) {
			System.out.print(" "+text.charAt(k));
			if(k>9) {
				System.out.print(" ");
			}
		}
		System.out.println(" ]\n");
		
		kmp.KMPSearch(text, pattern);
	}
}
