class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }

        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;

        for(int i = 1; i <= amount; i ++){
            for(int coin : coins){
                if(i-coin >=0){
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }

        if(dp[amount] == amount + 1){
            return -1;
        }
        return dp[amount];
    }
}
//coins, 목표금액 amount
//최소개수 return
//목표 달성 x  -> -1
//dp[i] = 금액 i 를 맞추기 위해 필요한 동전 최수 개수
//dp[i], dp[i-coin] + 1