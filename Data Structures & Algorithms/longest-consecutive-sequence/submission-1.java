class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        Arrays.sort(nums);
        int max = 1;
        int cur = 1;

        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] +1 == nums[i+1]){
                cur++;
            } else if(nums[i] == nums[i+1]){
                continue;
            } else if(nums[i] + 1 < nums[i+1]){
                cur = 1;
            }

            if(cur > max){
                max = cur;
            }
        }

        return max;
    }
}
