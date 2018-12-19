
public class KMP {

	public void KMPSearch(String text, String pattern) {
		int textLength = text.length();
		int patternLength = pattern.length();
		
		int[] arrayT = new int[patternLength];
		int indexPattern = 0;
		
		buildArrayT(pattern, patternLength, arrayT);
		
		int indexText = 0;
		
		while (indexText < textLength) {
			if (pattern.charAt(indexPattern) == text.charAt(indexText)) {
				indexPattern++;
				indexText++;
			}
			if (indexPattern == patternLength){
				System.out.println("Pattern has been found at index: "+ (indexText - indexPattern - 1) );
				indexPattern = arrayT[indexPattern - 1];
			}
			else if (indexText < textLength && pattern.charAt(indexPattern) != text.charAt(indexText) ) {
				if (indexPattern != 0) {
					indexPattern = arrayT[indexPattern - 1];
				}else {
					indexText = indexText + 1;
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
	}
}


