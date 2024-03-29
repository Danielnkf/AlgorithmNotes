/*
 * Given n non-negative integers representing an elevation map where the width 
 * of each bar is 1, compute how much water it is able to trap after raining.

 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class Solution {
    public int trap(int[] A) {
        if(A.length<3)
            return 0;
        int water = 0;
        int max = A[0];
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        left[0] = 0;
        for(int i=1;i<left.length;i++){
            left[i] = max;
            max = Math.max(max,A[i]);
        }
        right[A.length-1] = 0;
        max = A[A.length-1];
        for(int i = A.length - 2;i>=0;i--){
            right[i] = max;
            max = Math.max(max,A[i]);
            if(Math.min(right[i],left[i])>A[i])
                water+=Math.min(right[i],left[i]) - A[i];
        }
        return water;
    }
}
 
 
 
 
public class TrappingRainWater {
    public int trap_1(int[] A) {
        int[] lMax = new int[A.length], rMax = new int[A.length];
        for(int i = 0; i < A.length; i++) {
            lMax[i] = Math.max(lMax[i == 0 ? i : i - 1], A[i]); 
            rMax[A.length - 1 - i] = Math.max(rMax[A.length - i - (i == 0 ? 1 : 0)], A[A.length - 1 - i]);
        }
        int res = 0;
        for(int i = 1; i < A.length - 1; i++) {
            res += Math.min(lMax[i], rMax[i]) - A[i];
        }
        return res;
    } 


    public int trap_2(int[] A) {
        int res = 0, i = 0, j = A.length - 1;
        while(i < j) {
            int k;
            if(A[i] < A[j]) {
                k = i + 1;
                while(A[i] > A[k]) {
                    res += A[i] - A[k];
                    k++;
                }
                i = k;
            } else {
                k = j - 1;
                while(A[j] > A[k]) {
                    res += A[j] - A[k];
                    k--;
                }
                j = k;
            }
        }
        return res;
    }
}
