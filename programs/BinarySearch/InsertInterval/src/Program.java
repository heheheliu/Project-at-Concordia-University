import java.util.ArrayList;

public class Program {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[newInterval.length-1];
        Boolean isPlaced = false;
        ArrayList<int[]> newList = new ArrayList<>();
        for (int[] interval:intervals) {
            // 如果这个区间的第一个比新区间的最后一个还要大，先放新区间
            if(isPlaced){
                newList.add(interval);
            }else{
                if(interval[0] > right){
                    newList.add(new int[]{left,right});
                    newList.add(interval);
                    isPlaced = true;
                }
                // 如果这个区间的最后一个比新区间的第一个要小， 先放这个区间
                else if(interval[interval.length-1] < left){
                    newList.add(interval);
                }else{
                    // 如果以上都不满足， 说明有重叠的部分， 判断左边最小值， 右边最大值， 更改left 和 right 范围
                    // 先不加上， 等下个区间看看是否还有重叠
                    left = Math.min(left,interval[0]);
                    right = Math.max(right,interval[interval.length-1]);
                }
            }



        }
        if(isPlaced != true){
            newList.add(new int[]{left, right});
        }
        int[][] result = new int[newList.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = newList.get(i);

        }
        return result;

    }

    public static void main(String[] args) {
        int[][] inter = {{1,3},{6,9}};
        int[] newInter = {2,5};
        int[][] result = insert(inter, newInter);
        for(int[] it:result){
            System.out.println(it[0]+","+it[1]);
        }
    }
}
