import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
                Comparator.comparingInt(p -> nums1[p.getKey()] + nums2[p.getValue()])
        );

        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            pq.offer(new Pair<>(i, 0));
        }

        List<List<Integer>> result = new ArrayList<>();
        while (!pq.isEmpty() && k > 0) {
            Pair<Integer, Integer> pair = pq.poll();
            int i = pair.getKey(), j = pair.getValue();
            result.add(Arrays.asList(nums1[i], nums2[j]));
            if (j + 1 < nums2.length) {
                pq.offer(new Pair<>(i, j + 1));
            }
            k--;
        }

        return result;
    }
}