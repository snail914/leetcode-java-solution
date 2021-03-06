/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray [4,−1,2,1] has the largest sum = 6.
*/

public class Solution {
    public int maxSubArray(int[] A) {
        int maxSum=0, thisSum=0; 
        for (int i=0; i<A.length; i++){
            thisSum+=A[i];
            if (thisSum>maxSum) maxSum=thisSum;
            else if (thisSum<0) thisSum=0;
        }
        if (maxSum==0) maxSum=A[0];
        for (int i=1; i<A.length; i++){
            maxSum=Math.max(A[i], maxSum);
        }
        return maxSum;
    }
    
    
    //one time iteration
    public int maxSubArray(int[] A) {
        int newSum=A[0], max=A[0];
        for (int i=1; i<A.length; i++){
            newSum=Math.max(A[i], newSum+A[i]);
            max=Math.max(newSum, max);
        }
        return max;
    }
}