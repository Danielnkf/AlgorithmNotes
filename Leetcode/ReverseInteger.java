/*
 * Reverse digits of an integer.

 * Example1: x = 123, return 321
 * Example2: x = -123, return -321

 * Have you thought about this?
 * Here are some good questions to ask before coding. Bonus points for you if you have 
 * already thought through this!

 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit 
 * integer, then the reverse of 1000000003 overflows. How should you handle such cases?

 * Throw an exception? Good, but what if throwing an exception is not an option? You would 
 * then have to re-design the function (ie, add an extra parameter). 
 */
public class ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        while(x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result;
    }
}
//naive stupid method
public class Solution {
    public int reverse(int x) {
        int flag = 0;
        if(x==0)
            return 0;
        if(x<0){
            x = -x;
            flag = 1;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        int cur = x;
        while(cur!=0){
            queue.offer(cur%10);
            cur = cur / 10;
        }
        int res = 0;
        while(!queue.isEmpty()){
            res = res * 10 + queue.poll();
        }
        if(flag==1)
            res = - res;
        return res;
    }   
}
