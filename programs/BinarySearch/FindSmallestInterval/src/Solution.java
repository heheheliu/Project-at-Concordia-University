import java.util.Arrays;

public class Solution {
    public static int findSmallestInterval(int[] numbers) {
        // we write the code here
        int diffNew = Integer.MAX_VALUE;
        int len = numbers.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    int dif = Math.abs(numbers[i] - numbers[j]);
                    if (dif < diffNew) {
                        diffNew = dif;
                    }
                }
            }
        }
        return diffNew;

    }

    public static int findSmallestInterval_2(int[] numbers) {
        // we write the code here
        int diffNew = Integer.MAX_VALUE;
        Arrays.sort(numbers);
        int len = numbers.length;
        for (int i = 0; i < len - 1; i++) {
            if (numbers[i + 1] - numbers[i] < diffNew) {
                diffNew = numbers[i + 1] - numbers[i];
            }

        }
        return diffNew;

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int numbers[] = {1, 6, 4, 8, 2};

        System.out.println("Smallest positive interval = " + findSmallestInterval_2(numbers));
    }
}
