import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < intervals.length;i++){
            int l = intervals[i][0];
            int r = intervals[i][1];
            if(res.size() == 0 || res.get(res.size()-1)[1] < l){//如果为空或最后一个的右边小于区间的左边 直接添加
                res.add(new int[]{l,r});
            }else{
                res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1],r);
            }
        }
        return res.toArray(new int[res.size()][]);

    }

    public static void main(String[] args) {
        int[][] newList = merge(new int[][]{{0, 5}, {7, 8}, {0, 6}});

        for(int[] arr:newList)
            System.out.println(arr[0] +" "+ arr[1]);
    }

}
