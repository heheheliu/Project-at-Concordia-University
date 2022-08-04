import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, cur, ans);
        return ans;

    }


    //index 不回头
    public void dfs(int[] candidates, int target, int index, List<Integer> cur, List<List<Integer>> ans){
        if(target < 0) return;
        if(target == 0){
            ans.add(new ArrayList<Integer>(cur));//新建list因为cur会变
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(candidates[i] > target) break;
            cur.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, cur, ans);//可以重复
            cur.remove(cur.size()-1);
        }
    }


}
