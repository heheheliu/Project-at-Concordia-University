public class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i = 0; i < n+1; i++){
            ans[i] = Integer.bitCount(i);
        }
        return ans;

    }
    public int[] countBits_2(int n) {
        if(n == 0){
            return new int[]{0};
        }
        if(n == 1){
            return new int[]{0,1};
        }
        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        int multi = 1;
        for (int i = 2; i <= n; i++) {
            if (multi * 2 == i) {
                res[i] = 1;
                multi *= 2;
            } else {
                res[i] = 1 + res[i - multi];
            }
        }
        return res;
    }
}
