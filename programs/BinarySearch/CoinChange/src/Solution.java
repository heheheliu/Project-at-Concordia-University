import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    int res = Integer.MAX_VALUE;

    public static int coinChange(int[] coins, int amount) {

        Arrays.sort(coins);
        int[] dp = new int[amount+1];
        int max = amount + 1;
        Arrays.fill(dp,max);
        dp[0] = 0;
        for(int i = 1; i <= amount;i++){
            for(int coin : coins){
                if(i - coin >= 0){
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        return dp[amount] > amount? -1 : dp[amount];
    }
    //time limit exceeded
    public int coinChange_2(int[] coins, int amount) {
        Arrays.sort(coins);
        int count = 0;
        if(coins.length == 0) return -1;
        back_track(coins, amount, count, 0);
        if(res == Integer.MAX_VALUE){
            return -1;
        }
        return res;
    }
    public void back_track(int[] coins, int target, int count, int index){
        if(target < 0) return;
        if(target == 0){
            res = Math.min(count, res);
            return;
        }
        for(int i = index; i < coins.length; i++){
            if(coins[i] > target) break;
            back_track(coins, target - coins[i], count + 1, i);
        }
    }





}
