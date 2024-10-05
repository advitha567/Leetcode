class Solution {
    public int maxOperations(int[] nums, int k) {
      Arrays.sort(nums);
      int count =0;
      int n = nums.length;
      int l =0, r = n-1;
      while(l < r){
        int x = nums[l] + nums[r];
        if(x == k){
          l = l+1;
          r = r-1;
          count = count + 1;
        }
        else if(x > k){
          r = r-1;
        }
        else{
          l = l+1;
        }
      }
      return count;
    }
}