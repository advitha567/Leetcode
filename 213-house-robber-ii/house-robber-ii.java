
class Solution {
        public int rob(int[] nums) {
      //Easily understandable base cases
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int withFirstHouse = houseRobber1(nums, 0, nums.length -2);
        int withLastHouse = houseRobber1(nums, 1, nums.length -1);
        return Math.max(withFirstHouse, withLastHouse);
    }

   int houseRobber1(int[] nums, int start, int end) {
        int first = nums[start];
        int second = Math.max(first, nums[start +1]);
        int maxLoot = second;
        for(int i = start +2; i <=end; i++) {
            maxLoot = Math.max(first + nums[i], second);
            first = second;
            second = maxLoot;
        }
        return maxLoot;
    }
    
}