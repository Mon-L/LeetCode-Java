package medium;

public class PermutationInString {

    private static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (match(arr1, arr2)) {
                return true;
            }
            arr2[s2.charAt(i + s1.length()) - 'a']++;
            arr2[s2.charAt(i) - 'a']--;
        }
        return match(arr1, arr2);
    }

    private static boolean match(int[] arr1, int[] arr2) {
        for (int k = 0; k < 26; k++) {
            if (arr1[k] != arr2[k]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));  //true
        System.out.println(checkInclusion("ab", "eidboaoo")); //false
        System.out.println(checkInclusion("ab", "eidbbaooo")); //true
        System.out.println(checkInclusion("adc", "dcda")); //true
    }

}
