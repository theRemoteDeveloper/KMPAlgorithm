
public class Main {

	public static void main(String[] args) {
		System.out.println("KMP Algorithm");
		
		KMP kmp = new KMP();
		String text = "alamakontakotniemaali";
		String pattern = "ma";
			
		kmp.KMPSearch(text, pattern);
	}
}
