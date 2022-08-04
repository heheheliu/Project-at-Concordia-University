

class Solution {
    public static boolean check(String str){
        return "aeiouAEIOU".contains(str);
    }

    public static String reverseVowels(String s) {
        String[] str = s.split("");
        int len = str.length;
        int left = 0, right = len-1;
        while(left < right){
           while(left < len && !check(str[left])){
               ++left;

           }
           while(right > 0 && !check(str[right])){
               --right;
           }
           if(left < right){
               swag(str, left, right);
               ++left;
               --right;
           }
       }
        String res="";
        for (String x: str) {
            res += x;

        }
        return res;
    }
    public static void swag(String[] arr, int i, int j){
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public static void main(String[] args) {
        reverseVowels("acv");
    }
}