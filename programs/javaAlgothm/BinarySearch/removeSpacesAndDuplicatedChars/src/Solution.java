public class Solution {
    // removing spaces and duplicated character from string with stream api
    // ex. "a dd gg h   zz" --->adghz


    public static String removeSpacesAndDuplicatedChars(String sentence) {
        // we write the code here
        String str = sentence.replace(" ", "");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                sb.append(str.charAt(i));
                i++;
            } else {
                sb.append(str.charAt(i));
            }
        }

        String result = sb.toString();
        return result;

    }

    public static void main(String[] args) {

        String sentence = "a dd gg h   zz";

        System.out.println("removing spaces and duplicated, the new string = " + removeSpacesAndDuplicatedChars(sentence));
    }

}
