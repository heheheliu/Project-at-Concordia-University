import java.util.Arrays;

public class Solution {
      public static int computeClosestToZero(int[] ts){
          if(ts.length == 0){
              return 0;
          }
          int closest = Integer.MAX_VALUE;
          for(int i = 0; i < ts.length; i++){
              if (Math.abs(ts[i]) < Math.abs(closest)){
                  closest = ts[i];

              }
              else if(Math.abs(ts[i]) == Math.abs(closest)){
                  if(ts[i]>0){
                      closest = ts[i];
                  }
              }
          }
          return closest;
      }

    public static void main(String[] args) {
        int[] ts = new int[]{-5,-2,2};
        System.out.println(computeClosestToZero(ts));
    }
}
