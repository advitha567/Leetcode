class Solution {
    public int largestUniqueNumber(int[] nums) {
        HashMap<Integer,Integer> hm= new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        int res = -1;
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (entry.getValue() == 1) {
                res = Math.max(res, entry.getKey());
            }
        }
        return res;
    }
}