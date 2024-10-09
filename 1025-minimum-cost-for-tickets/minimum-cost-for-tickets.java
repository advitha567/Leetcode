class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Queue<Pair<Integer, Integer>> week = new LinkedList<>();
        Queue<Pair<Integer, Integer>> month = new LinkedList<>();
        int ans = 0;
        for(int day: days){
          while(!week.isEmpty() && week.peek().getKey() + 7 <= day){
            week.poll();
          }
          while(!month.isEmpty() && month.peek().getKey() + 30 <= day){
            month.poll();
          }
          week.add(new Pair(day, ans+costs[1]));
          month.add(new Pair(day, ans+costs[2]));
          ans = Math.min(ans+costs[0], Math.min(week.peek().getValue(), month.peek().getValue()));

        }
        return ans;
    }
}