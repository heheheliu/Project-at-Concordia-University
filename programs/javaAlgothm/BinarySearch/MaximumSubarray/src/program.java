public class program {
    // https://leetcode-cn.com/problems/maximum-subarray/solution/dong-tai-gui-hua-fen-zhi-fa-python-dai-ma-java-dai/
    public static int maxSubArray(int[] nums) {

        int pre = 0;
        int max = nums[0];

        for (int x: nums) {
            pre = Math.max(pre + x, x);
            max = Math.max(pre,max);

        }
        return max;
    }

    public static int maxSubArray2(int[] nums){
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];

        for (int i = 1; i<len; i++){
            if(dp[i-1]>0){
                dp[i] = dp[i-1] + nums[i];
            }
            else {
                dp[i] = nums[i];
            }
        }

        int max = nums[0];
        for (int x:dp) {
            if(x>max){
                max = x;
            }

        }


        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
        System.out.println(maxSubArray2(arr));
    }
}
