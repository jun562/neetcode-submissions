class Solution {
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
       
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i < n+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
//1 과 2를 이용해 n 을 만드는 모든 경우의 수
//dp[N] = 계단 N개 오르는 경우의 수
//dp[1] = 1
//dp[2] = dp[1] + dp[1] = 2
//dp[3] = dp[2] + dp[1] = 3
//dp[4] = dp[3] + dp[2] = 5
//dp[5] = dp[4] + dp[3] = 8
//1+1+1+1, 1+1+2 , 1+2+1 , 2+1+1, 2+2
//1+1+1+1+1, 1+1+1+2, 1+1+2+1, 1+2+1+1, 2+1+1+1, 1+2+2, 2+1+2, 2+2+1 = 8
//즉 dp[N] = dp[N-1] + dp[N-2] // n-1칸에서 1칸 올라가는 경우 + n-2칸에서 2칸 올라가는 경우