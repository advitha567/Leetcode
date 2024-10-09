import java.util.TreeMap;

class Solution {
    public long[] maximumCoins(int[] heroes, int[] monsters, int[] coins) {
        long[] res = new long[heroes.length];
        TreeMap<Integer, Long> tm = new TreeMap<>();
        for (int i = 0; i < monsters.length; i++) {
            tm.put(monsters[i], tm.getOrDefault(monsters[i], 0L) + coins[i]);
        }
        long cumulativeCoins = 0;
        for (int key : tm.keySet()) {
            cumulativeCoins += tm.get(key);  
            tm.put(key, cumulativeCoins);    
        }
        for (int i = 0; i < heroes.length; i++) {
            Integer closestMonster = tm.floorKey(heroes[i]);
            res[i] = (closestMonster == null) ? 0 : tm.get(closestMonster);
        }

        return res;
    }
}
