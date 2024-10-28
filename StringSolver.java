import java.util.*;

class StringSolver {

    // 1.function to check whether the string is palindrome or not
    public static boolean isPalindrome(String str) {
        char[] arr = str.toCharArray();
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            if (arr[start] != arr[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // 2.function to Count number of vowels, consonants, spaces in a string.
    public static HashMap<String, Integer> countVowelsConsonantSpaces(String str) {
        String temp = str.toLowerCase();
        char[] arr = temp.toCharArray();
        HashMap<String, Integer> result = new HashMap<>();

        for (char ch : arr) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                result.put("vowels", result.getOrDefault("vowels", 0) + 1);
            } else if (ch == ' ') {
                result.put("spaces", result.getOrDefault("spaces", 0) + 1);
            } else {
                result.put("consonant", result.getOrDefault("consonant", 0) + 1);
            }
        }
        return result;
    }

    // 3. function to remove all the vowels from the string
    public static String removeVowels(String str) {
        StringBuffer answer = new StringBuffer();
        for (char ch : str.toCharArray()) {
            char tempChar = Character.toLowerCase(ch);
            if (tempChar == 'a' || tempChar == 'e' || tempChar == 'i' || tempChar == 'o' || tempChar == 'u') {
                continue;
            } else {
                answer.append(ch);
            }
        }
        return answer.toString();
    }

    // 4.function to reverse a string
    public static String reverseString(String str) {
        char[] strArray = str.toCharArray();
        int start = 0;
        int end = strArray.length - 1;
        while (start < end) {
            char temp = strArray[start];
            strArray[start] = strArray[end];
            strArray[end] = temp;
            start++;
            end--;
        }
        return new String(strArray);
    }

    // 5.function to find the frequency of each character in the string
    public static HashMap<Character, Integer> frequencyCount(String str) {
        HashMap<Character, Integer> result = new HashMap<>();
        for (char ch : str.toCharArray()) {
            if (ch != ' ') {
                result.put(ch, result.getOrDefault(ch, 0) + 1);
            }

        }
        return result;
    }

    // 6.function to find the non-repeating characters in the string
    public static ArrayList<Character> nonRepeatingChars(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<Character> result = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            if (ch != ' ') {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

        }
        for (char key : map.keySet()) {
            if (map.get(key) <= 1) {
                result.add(key);
            }
        }
        return result;
    }

    // 7. function to find maximum occurring character in the input string.
    public static char maxOccuringChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        char result = ' ';
        for (char ch : str.toCharArray()) {
            if (ch != ' ') {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

        }
        int maxi = Integer.MIN_VALUE;

        for (char key : map.keySet()) {
            if (map.get(key) > maxi) {
                maxi = map.get(key);
                result = key;
            }
        }
        return result;
    }

    // 8.function to remove all the duplicate characters in the input string
    public static String removeDuplicates(String str) {
        HashSet<Character> charSet = new HashSet<>();
        StringBuilder result = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (!charSet.contains(ch)) {
                charSet.add(ch);
                result.append(ch);
            }
        }
        return new String(result);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = sc.nextLine();
        sc.close();

        // Check if a given string is palindrome or not.
        System.out.print("\nThe given string is: ");
        if (isPalindrome(str)) {
            System.out.print("Palindrome");
        } else {
            System.out.print("Not Palindrome");
        }

        // finding no. of vowels consonant and spaces
        System.out.print("\nTotal no. of vowels consonants and spaces are : ");
        HashMap<String, Integer> result = countVowelsConsonantSpaces(str);
        for (String key : result.keySet()) {
            System.out.print(key + ":" + result.get(key) + " ");
        }

        // Removing all the vowels from the string
        System.out.print("\nString after removing all vowels is: ");
        System.out.print(removeVowels(str));

        // reversing the string
        System.out.print("\nString after reversing it is: ");
        System.out.print(reverseString(str));

        // finding frequency of each element in the string
        System.out.print("\nFrequency of each characters in the string are: ");
        HashMap<Character, Integer> result1 = frequencyCount(str);
        for (char key : result1.keySet()) {
            System.out.print(key + ":" + result1.get(key) + " ");
        }

        // finding non-repeating characters
        System.out.print("\nNon repeating characters in the string are: ");
        ArrayList<Character> result2 = nonRepeatingChars(str);
        for (char ch : result2) {
            System.out.print(ch + " ");
        }

        // finding the maximum occurring character in the input string.
        System.out.print("\nthe maximum occurring character in the input string is: " + maxOccuringChar(str));

        // Removing all duplicates from the input string.
        System.out.print("\nString after removing duplicates is: " + removeDuplicates(str));
    }
}