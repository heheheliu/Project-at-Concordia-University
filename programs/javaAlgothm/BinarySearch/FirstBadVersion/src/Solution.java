public class Solution {

    public int firstBadVersion(int n) {
        int left = 1, right = n;

        while(left < right){//循环直至区间左右端点相同
            int mid = left+(right-left)/2;// 防止计算时溢出
            if(!isBadVersion(mid)){
                left = mid + 1;// 答案在区间 [mid+1, right] 中
            }else {
                right = mid;// 答案在区间 [left, mid] 中
            }
        }
        return left;
    }
    public Boolean isBadVersion(int n){
        return true;
    }


}
