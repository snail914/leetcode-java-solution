/*
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them 
is that adjacent houses have security system connected
and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.
*/
public int rob(int[] num) {
    if(num.length==0) return 0;
    int robThisMax=num[0], skipThisMax=0;
    for(int i=1; i<num.length; i++){
        int tmp=robThisMax;
        robThisMax=skipThisMax+num[i];
        skipThisMax=Math.max(tmp, skipThisMax);
    }
    return Math.max(robThisMax, skipThisMax);
}