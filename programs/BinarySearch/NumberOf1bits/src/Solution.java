public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Integer.bitCount(n);

    }
    //a&b=2 ,按位与,算术运算..1010&0010 = 0010,二进制中的 同为1才为1
    //位移运算符， <<左移运算，>>右移运算
    //1<<30为例,首先把1转为二进制数字 0000 0000 0000 0000 0000 0000 0000 0001
    //然后将上面的二进制数字向左移动30位后面补0得到 0010 0000 0000 0000 0000 0000 0000 0000
    public int hammingWeight_2(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }


}
