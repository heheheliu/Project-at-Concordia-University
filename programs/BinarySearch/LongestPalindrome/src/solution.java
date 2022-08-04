public class solution {
    public int longestPalindrome(String s) {
        if(s.isEmpty()){
            return 0;
        }
        int[] array = new int[52];
        for(int i = 0; i<s.length();i++){
            if(Character.isLowerCase(s.charAt(i))){
                array[s.charAt(i) - 'a' + 26] ++;
            }
            else if(Character.isUpperCase(s.charAt(i))){
                array[s.charAt(i) - 'A'] ++;
            }

        }
        int longest = 0;
        Boolean one = false;
        for(int n : array){
            if(n%2 == 0){
                longest = longest + n;
            }
            else if( n%2 !=0  && one == false){
                longest = longest + n;
                one = true;
            }else if (n%2 !=0  && one){
                longest = longest + n - 1;
            }
        }
        return longest;

    }

    public int longestPalindrome_better(String s) {
        int[] count = new int[128];
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            count[c]++;
        }

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {//如果是奇数并且ans还是偶数时 加1
                ans++;
            }
        }
        return ans;
    }

}
