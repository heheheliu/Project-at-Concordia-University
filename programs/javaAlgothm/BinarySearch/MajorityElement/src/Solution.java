import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for(int n : nums){
            if(!counts.containsKey(n)){
                counts.put(n, 1);
            }
            else{
                counts.put(n,counts.get(n) + 1);
            }
        }
        Map.Entry<Integer,Integer> res = null;
        for(Map.Entry<Integer,Integer> entry : counts.entrySet()){
            if(res == null || entry.getValue() > res.getValue()){
                res = entry;
            }
        }
        return res.getKey();

    }

    public int majorityElement_better(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for(int i = 1; i<nums.length;i++){
            if(nums[i] == candidate){
                ++count;
            }
            else{
                --count;
                if(count == 0){
                    candidate = nums[i];
                    count = 1;
                }
            }
        }
        return candidate;

    }

}
