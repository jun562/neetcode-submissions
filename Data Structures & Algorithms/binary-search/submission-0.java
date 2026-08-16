class Solution {
    public int search(int[] nums, int target) {
        int N = nums.length;
        int left = 0;
        int right = N-1;
        while(left<=right){
            int mid = (left + right) / 2 ; 
            
            if(nums[mid] == target){
                return mid;
            } else if (nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
//target의 인덱스 반환, 존재하지 않으면 -1 반환
//시간복잡도 O(logN) 이어야 함.