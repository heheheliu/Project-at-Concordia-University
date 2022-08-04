import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class C {
    public  void combination(int[] nums, int d, int n, int s, List<Integer> cur, List<List<Integer>> ans){
        if(d == n){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i = s; i < nums.length; i++){
            cur.add(nums[i]);
            combination(nums,d+1, n,i+1, cur, ans);
            cur.remove(cur.size()-1);
        }

    }
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for(int i = 0; i<n; i++){
            nums[i] = i + 1;
        }
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        combination(nums,0, k,0, cur, ans);
        return ans;

    }


}
