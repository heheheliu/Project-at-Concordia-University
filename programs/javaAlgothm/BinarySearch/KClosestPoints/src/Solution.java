import java.util.*;

public class Solution {
    public int[][] kClosest(int[][] points, int k) {

        // TreeMap 自动排序
        Map<Integer, ArrayList<int[]>> map = new TreeMap<>();
        for (int[] point: points){
            int len = point[0]*point[0]+point[1]*point[1];
            //getOrDefault() 方法获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值。
            ArrayList<int[]> list = map.getOrDefault(len, new ArrayList<>());
            list.add(point);
            map.put(len,list);

        }
        int[][] res = new int[k][2];
        for(int len : map.keySet()){
            if(k==0){
                break;
            }
            List<int[]> list = map.get(len);
            for(int[] p : list){
                res[--k] = p;
            }
        }
        return res;


    }
    public int[][] kClosest2(int[][] points, int k) {
        //排序，需要比较两个对象谁排在前谁排在后
        //在List或数组中的对象如果没有实现Comparable接口时，
        // 那么就需要调用者为需要排序的数组或List设置一个Comparator，
        //Comparator的compare方法用来告诉代码应该怎么去比较两个实例，
        // 然后根据比较结果进行排序
        Arrays.sort(points,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0]*o1[0]+o1[1]*o1[1])-(o2[0]*o2[0]+o2[1]*o2[1]);
            }
        });
        //Arrays.copyOfRange 表示复制data数组中的第0个到k-1个元素到新数组中
        return Arrays.copyOfRange(points, 0, k);
    }


}
