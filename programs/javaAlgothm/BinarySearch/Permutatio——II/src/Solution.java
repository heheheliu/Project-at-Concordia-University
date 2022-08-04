import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int d = 0;
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        int[] used = new int[n];
        back_look(nums, d, n, used, cur, ans);
        return ans;

    }
    public void back_look(int[] nums, int d, int n, int[] used, List<Integer> cur, List<List<Integer>> ans){
        if(d == n){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1){
                continue;
            }
            if(i>0 && nums[i] == nums[i-1] && used[i-1] == 0){//防止重复
                continue;
            }
            used[i] = 1;
            cur.add(nums[i]);
            back_look(nums, d+1, n, used, cur, ans);
            used[i] = 0;
            cur.remove(cur.size()-1);

        }
    }
}
