import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        back_look(candidates, target,0, cur, ans);
        return ans;
    }
    public void back_look(int[] candidates, int target, int index,  List<Integer> cur,List<List<Integer>> ans ){
        if(target < 0) return;
        if(target == 0){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i = index; i<candidates.length;i++){
            if(candidates[i] > target) break;
            if(i > index && candidates[i] == candidates[i-1] ){
                continue;
            }
            cur.add(candidates[i]);
            back_look(candidates, target - candidates[i], i+1,  cur, ans);
            cur.remove(cur.size()-1);

        }

    }
}
