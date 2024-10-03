class Solution {
    public int minSubarray(int[] nums, int p) {
      HashMap<Integer,Integer> hm = new HashMap<>();
      int totalRem =0 ;
      int curRem =  0;
      int targetRem;
      int answer = Integer.MAX_VALUE;
      for(int num: nums){
        totalRem = (totalRem + num) % p;
      }
      if(totalRem == 0){
        return 0;
      }
      hm.put(0,-1);
      for(int i =0; i< nums.length; i++){
        curRem = (curRem + nums[i]) % p;
        targetRem = (curRem - totalRem + p) % p;
        if(hm.containsKey(targetRem)){
          answer = Math.min(answer, i-hm.get(targetRem));
        }
        hm.put(curRem, i); 
      }
      if(answer >= nums.length ){
        return -1;
      }
      return answer;
    }
}