package com.pawel.kmp;

public class KMP {

	public void KMPSearch(String text, String pattern) {
		int textLength = text.length();
		int patternLength = pattern.length();
		
		int[] arrayT = new int[patternLength];
		int indexPattern = 0;
		
		buildArrayT(pattern, patternLength, arrayT);
		
		System.out.println("Main KMP algorithm\n");
		
		int indexText = 0;
		
		while (indexText < textLength) {
			if (pattern.charAt(indexPattern) == text.charAt(indexText)) {
				System.out.println("OK. Text index: "+indexText+", index pattern: "+indexPattern);
				indexPattern++;
				indexText++;
			}
			if (indexPattern == patternLength){
				System.out.println("Pattern has been found at index: "+ (indexText - indexPattern - 1) );
				indexPattern = arrayT[indexPattern - 1];
			}
			else if (indexText < textLength && pattern.charAt(indexPattern) != text.charAt(indexText) ) {
				System.out.print("NOT OK. Text index: "+indexText+", index pattern: "+indexPattern);
				if (indexPattern != 0) {
					indexPattern = arrayT[indexPattern - 1];
					System.out.println(", NEW index pattern: "+indexPattern);
				}else {
					indexText = indexText + 1;
					System.out.println(", NEW index text: "+indexText);
				}
			}	
		}	
	}
	
	
	public void buildArrayT(String pattern, int nP, int[] arrayT) {
		int lenPref = 0;
		int i = 1;
		arrayT[0] = 0;
		
		while(i < nP) {
			if(pattern.charAt(i) == pattern.charAt(lenPref)) {
				lenPref++;
				arrayT[i]=lenPref;
				i++;
			} else {
				if(lenPref != 0) {
					lenPref = arrayT[lenPref - 1];
				} else {
					arrayT[i] = lenPref;
					i++;
				}
			}
		}
		
		System.out.println("Pattern and auxiliary array.");
		
		System.out.print("i: [");
		for(int l=0; l<pattern.length(); l++) {
			System.out.print(" "+l);
		}
		System.out.println(" ]");
		
		System.out.print("P: [");
		for(int k=0; k<pattern.length(); k++) {
			System.out.print(" "+pattern.charAt(k));
		}
		System.out.println(" ]");
		
		System.out.print("T: [");
		for(int j=0; j<arrayT.length; j++) {
			System.out.print(" "+arrayT[j]);
		}
		System.out.println(" ]\n");
		
	}
}


