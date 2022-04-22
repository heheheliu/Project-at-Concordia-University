import java.util.Scanner;

public class RomanToInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input a number");
        String input = sc.nextLine();

        System.out.println(romanToInt(input));

    }

    public static int getRomanInt(char c) {
        switch (c) {
            case ('I'):
                return 1;
            case ('V'):
                return 5;
            case ('X'):
                return 10;
            case ('L'):
                return 50;
            case ('C'):
                return 100;
            case ('D'):
                return 500;
            case ('M'):
                return 1000;
            default:
                return 0;

        }
    }

    public static int romanToInt(String s) {
        int result = 0;
        int prev = getRomanInt(s.charAt(s.length() - 1));
        result = result + prev;
        for (int i = s.length() - 2; i >= 0; i--) {
            int value = getRomanInt(s.charAt(i));
            if (value < prev) {
                result -= value;

            } else {
                result += value;

            }
            prev = value;

        }

        return result;
    }

}
