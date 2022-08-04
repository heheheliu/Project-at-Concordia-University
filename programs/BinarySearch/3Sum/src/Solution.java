import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        if(nums == null || len < 3){
            return ans;
        }
        for(int i = 0; i < len; i++){
            if(nums[i] > 0){
                break;// 如果 nums[i]大于 0，则三数之和必然无法等于 0，结束循环
            }
            if(i > 0 && nums[i] == nums[i-1]){
                continue;//则说明该数字重复，会导致结果重复，所以应该跳过
            }
            int l = i + 1;
            int r = len - 1;
            while(l<r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0){//计算三个数的和 sum 判断是否满足为 0，满足则添加进结果集
                    ans.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while( l<r && nums[l] == nums[l+1]){
                        l++; //会导致重复 应该跳过
                    }
                    while(l<r && nums[r] == nums[r-1]){
                        r--;//会导致重复 应该跳过
                    }
                    l++;
                    r--;
                }
                else if(sum < 0){
                    l++;
                }
                else if(sum > 0){
                    r--;
                }
            }

        }
        return ans;
    }
}
