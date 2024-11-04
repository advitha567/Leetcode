import java.util.*;

class Solution {
    public int[] timeTaken(int[] arrival, int[] state) {
        int n = arrival.length;
        int[] result = new int[n];
        Queue<Integer> enterQueue = new LinkedList<>();
        Queue<Integer> exitQueue = new LinkedList<>();

        int time = 0;
        int lastAction = -1;
        int index = 0;

        while (index < n || !enterQueue.isEmpty() || !exitQueue.isEmpty()) {
            while (index < n && arrival[index] <= time) {
                if (state[index] == 0) {
                    enterQueue.add(index);
                } else {
                    exitQueue.add(index);
                }
                index++;
            }

            if (!exitQueue.isEmpty() && (lastAction == 1 || lastAction == -1 || enterQueue.isEmpty())) {
                result[exitQueue.poll()] = time;
                lastAction = 1;
            } else if (!enterQueue.isEmpty()) {
                result[enterQueue.poll()] = time;
                lastAction = 0;
            } else {
                lastAction = -1; 
            }

            time++;
        }

        return result;
    }

}