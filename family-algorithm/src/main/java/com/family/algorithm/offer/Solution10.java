package com.family.algorithm.offer;

public class Solution10 {
    public static void main(String[] args) {

        new Solution10().numWays(44);

    }
    public int numWays(int n) {
        if(n==0||n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        long ap = 2;
        long app =1;
        long an=0;
        for(int i=3;i<=n;i++){
            an=ap+app;
            System.out.println(an);
            app=ap;
            ap=an;
        }
        return (int)an;
    }
}
