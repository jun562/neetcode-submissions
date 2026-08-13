class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        if(nums.length==set.size()){
            return false;
        }
        return true;
    }
}