package string;

/**
 * @File : AnagramsChecker.java
 * @Description : it checks if two words are anagrams of each other or not
 * @author Pavan Chokshi
 * 
 */
public class AnagramsChecker {

	public static final int TOTALCOUNT = 256;

	/**
	 * Function for checking if two words are anagrams of each other or not
	 * 
	 * @param str1 string
	 * @param str2 string
	 * @return bool value
	 */
	public boolean checkAnagrams(String str1, String str2) {

		// initialize count array
		int[] count = new int[TOTALCOUNT];

		// if both strings length are different, they cant be anagrams so return false
		if (str1.length() != str2.length())
			return false;
		/*
		 * for each character in first string increment count for that character
		 * and for each character in second string decrement count for that character
		*/
		for (int i = 0; i < str1.length(); i++) {
			count[str1.charAt(i)]++;
			count[str2.charAt(i)]--;
		}

		// check each character count is not equal to 0
		for (int i = 0; i < count.length; i++) {
			if (count[i] > 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {

		// given two strings
		String str1 = "apples";
		String str2 = "sapple";

		// create object of CheckAnagrams
		AnagramsChecker anagramsChecker = new AnagramsChecker();
		// check anagrams
		if (anagramsChecker.checkAnagrams(str1, str2)) {
			System.out.println(str1 + " and " + str2 + " are anagrams.");
		} else {
			System.out.println(str1 + " and " + str2 + " are not anagrams.");
		}
	}

}