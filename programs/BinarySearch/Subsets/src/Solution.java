import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            back(nums, 0, i, 0, cur, ans);
        }
        return ans;
    }
    public static void back(int[] nums, int d, int n, int index,List<Integer> cur ,List<List<Integer>> ans){
        if(d == n){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i = index; i < nums.length; i++){
            cur.add(nums[i]);
            back(nums, d + 1, n, i + 1, cur, ans);
            cur.remove(cur.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};

        List<List<Integer>> ans = subsets(nums);
        System.out.println(ans);

    }
}
