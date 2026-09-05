class Solution {
    public int rob(int[] nums) {
        int N = nums.length;
        int[] dp1 = new int[N];
        int[] dp2 = new int[N];

        if(N == 1){
            return nums[0];
        }

        dp1[0] = nums[0];
        dp1[1] = nums[0];

        dp2[0] = 0;
        dp2[1] = nums[1];

        for(int i = 2; i < N - 1; i++){
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + nums[i]);
        }

        for(int i = 2; i < N; i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + nums[i]);
        }

        return Math.max(dp1[N-2], dp2[N-1]);
    }
}

//i번째 까지 집의 훔칠 수 있는 최댓값
//첫번째 집을 들림, 마지막 집 안들림
//첫번째 집을 안들림, 마지막 집 들림
