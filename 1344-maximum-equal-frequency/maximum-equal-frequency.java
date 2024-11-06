import java.util.HashMap;

class Solution {
    public int maxEqualFreq(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();  
        HashMap<Integer, Integer> countMap = new HashMap<>(); 
        int maxPrefixLength = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int oldFreq = freqMap.getOrDefault(num, 0);

            if (oldFreq > 0) {
                countMap.put(oldFreq, countMap.get(oldFreq) - 1);
                if (countMap.get(oldFreq) == 0) {
                    countMap.remove(oldFreq);
                }
            }

            int newFreq = oldFreq + 1;
            freqMap.put(num, newFreq);

            countMap.put(newFreq, countMap.getOrDefault(newFreq, 0) + 1);

            if (countMap.size() == 1) {
                int onlyFreq = countMap.keySet().iterator().next();
                if (onlyFreq == 1 || countMap.get(onlyFreq) == 1) {
                    maxPrefixLength = i + 1;
                }
            } else if (countMap.size() == 2) {
                int freq1 = (int) countMap.keySet().toArray()[0];
                int freq2 = (int) countMap.keySet().toArray()[1];


                int maxFreq = Math.max(freq1, freq2);
                int minFreq = Math.min(freq1, freq2);

                if ((minFreq == 1 && countMap.get(minFreq) == 1) || 
                    (maxFreq - minFreq == 1 && countMap.get(maxFreq) == 1)) {
                    maxPrefixLength = i + 1;
                }
            }
        }

        return maxPrefixLength;
    }
}
