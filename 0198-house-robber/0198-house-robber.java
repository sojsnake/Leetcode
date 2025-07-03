class Solution {
    public int rob(int[] nums) {
        int curr = 0, prev = 0;
        for(int num : nums){
            int temp = curr;
            curr = Math.max(curr, prev+num);
            prev = temp;
        }
        return curr;
    }

}