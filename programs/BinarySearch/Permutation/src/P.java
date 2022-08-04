import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P {
    public List<List<Integer>> permute(int[] nums) {
        int d = 0, n = nums.length;
        int[] used = new int[n];
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        permutation(nums, d, n, used, cur, ans);
        return ans;

    }
    public static void permutation(int[] nums, int d, int n, int[] used, List<Integer> cur, List<List<Integer>> ans){
        if(d == n){
            ans.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = 0; i<nums.length; i++){
            if(used[i] == 1){
                continue;
            }
            used[i] = 1;
            cur.add(nums[i]);
            permutation(nums, d+1, n, used, cur, ans);
            cur.remove(cur.size()-1);
            used[i] = 0;
        }
    }
}
