import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int left = 0;
        int len = nums.length;
        while(left < len){
            int sum = 0;
            for(int i = left; i < len;i++){
                sum += nums[i];
                if(sum == k){
                    count++;
                }
            }
            left++;
        }
        return count;
    }
    public static int subarraySum_hash(int[] nums, int k) {
        int count = 0; // 统计
        int sum = 0;//前缀和
        HashMap<Integer, Integer> hashMap = new HashMap<>();//和为键， 出现次数为值
        //hashMap.put(0,1);

        for(int num : nums){
            sum += num;
            if(sum == k){//替代先加hashMap.put(0,1);的操作
                count++;
            }
            if(hashMap.containsKey(sum - k)){
                count +=hashMap.get(sum - k);
            }
            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }


    public static void main(String[] args) {
        int[] nums = {1,3,1,4,-4,4};
        System.out.println(subarraySum_hash(nums,4));
    }
}
