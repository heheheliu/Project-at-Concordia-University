import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        for(int i=len-1;i>=0;i--){
            if(digits[i] !=9){
                ++digits[i];
                for(int j = i+1; j<len;j++){
                    digits[j]=0;
                }
                return digits;
            }
        }
        int[] newDigits = new int[len+1];
        newDigits[0] = 1;
        for(int i =0; i<len+1;i++){
            System.out.print(newDigits[i]+" ");
        }

        return newDigits;

    }

    public static void main(String[] args) {
        plusOne(new int[]{9,9,9});
    }
}
