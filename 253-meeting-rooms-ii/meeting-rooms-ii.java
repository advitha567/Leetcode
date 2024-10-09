class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(subarray -> subarray[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int collidingCount = 0;
        for(int i =0; i< intervals.length; i++){
          while(!pq.isEmpty() &&  pq.peek() <= intervals[i][0]){
            pq.poll();
          }
          pq.add(intervals[i][1]);
          collidingCount = Math.max(collidingCount, pq.size());
        }
        return collidingCount;
    }
}