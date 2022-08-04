public class Solution {
    //直接递归 O(2^n)
    public int climbStairs(int n) {
        if (n ==1){
            return 1;
        }

        if(n== 2){
            return 2;
        }

        return climbStairs(n-1) + climbStairs(n-2);

    }
    //优化递归 加入记忆列表 O(N)
    public int climbStairs_better(int n){
        int[] memo = new int[n+1];
        return climbStairsMemo(n,memo);
    }
    public int climbStairsMemo(int n, int[] memo){
        if(memo[n] > 0){
            return memo[n];
        }
        else if (n == 1){
            memo[n] = 1;
            return 1;
        }else if(n == 2){
            memo[n] = 2;
            return 2;
        }
        else{
            memo[n] = climbStairsMemo(n-1,memo) + climbStairsMemo(n-2,memo);
        }
        return memo[n];
    }

    //动态规划
    public int climbStairs_dynamic(int n){
        int[] array = new int[n+1];
        if(n <= 1){
            return n;
        }
        array[1] = 1;
        array[2] = 2;
        if(n>2){
            for (int i = 3; i <= n; i++){
                array[i] = array[i-1] + array[i-2];
            }
        }
        return array[n];

    }
    //动态 斐波那切数列
    public int climbStairs_dynamicCalculate(int n){

        if(n <= 2){
            return n;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++){
                int third = first + second;
                first = second;
                second = third;
            }
        return second;
    }

}
