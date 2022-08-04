import java.util.Arrays;
//任何数和 00 做异或运算，结果仍然是原来的数，即 a ⊕ 0=a。
//任何数和其自身做异或运算，结果是 0，即 a ⊕ a=0。
//异或运算满足交换律和结合律，即 a ⊕ b ⊕ a=b ⊕ a ⊕ a=b ⊕ (a ⊕ a)=b


public class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i<nums.length-1;i+=2){
            if(nums[i] == nums[i+1]){
                continue;
            }
            else{
                return nums[i];
            }

        }
        return nums[nums.length-1];
    }
    public int singleNumber_2(int[] nums) {
        int single = 0;
        for(int n : nums){
            single ^= n;
        }
        return single;
    }
}
