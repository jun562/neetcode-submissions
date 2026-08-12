class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i < n; i++){
            dp[i] = cost[i] + Math.min(dp[i-1],dp[i-2]);
        }

        return Math.min(dp[n-1],dp[n-2]);
    }
}

//i번째 계단에 cost 지불시에 i+1 or i+2 계단으로 올라갈 수 있음
//0 또는 1번째 계단에서 출발 가능
//가장 작은 cost return

//dp[n] = n번째 계단일때 가장 적은 누적 cost
//dp[0] = cost[0]
//dp[1] = cost[1]
//dp[2] = Math.min(dp[0], dp[1]) + cost[2];