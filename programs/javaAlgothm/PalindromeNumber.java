public class PalindromeNumber {
    public static boolean isPalindrome(int x) {

        int rem, rev = 0;
        int n = x;
        while (n > 0) {
            rem = n % 10;
            rev = rev * 10 + rem;
            n = n / 10;

        }

        return x == rev;

    }

    public static boolean isPalindrome2(int x) {
        if (x < 0)
            return false;
        String num = Integer.toString(x);
        int[] numbers = new int[num.length()];

        for (int i = 0; i < num.length(); i++) {

            numbers[i] = num.charAt(i) - '0';
            // System.out.println(numbers[i]);

        }
        int[] reverse_numbers = new int[numbers.length];
        for (int j = numbers.length - 1, k = 0; j >= 0 && k < numbers.length; j--, k++) {

            reverse_numbers[k] = numbers[j];
            // System.out.println(reverse_numbers[k]);

        }
        for (int m = 0; m < reverse_numbers.length; m++) {
            if (reverse_numbers[m] != numbers[m])
                return false;
        }
        return true;

    }

    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome(x));

    }

}
