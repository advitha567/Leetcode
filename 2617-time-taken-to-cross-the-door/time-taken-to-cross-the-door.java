import java.util.*;

class Solution {
    public int[] timeTaken(int[] arrival, int[] state) {
        int n = arrival.length;
        int[] result = new int[n];
        Queue<Integer> enterQueue = new LinkedList<>();
        Queue<Integer> exitQueue = new LinkedList<>();

        int time = 0;
        int lastAction = -1; // -1: unused, 0: enter, 1: exit
        int index = 0;

        while (index < n || !enterQueue.isEmpty() || !exitQueue.isEmpty()) {
            // Add all persons arriving at the current time to their respective queues
            while (index < n && arrival[index] <= time) {
                if (state[index] == 0) {
                    enterQueue.add(index);
                } else {
                    exitQueue.add(index);
                }
                index++;
            }

            // Determine action based on priority and door state
            if (!exitQueue.isEmpty() && (lastAction == 1 || lastAction == -1 || enterQueue.isEmpty())) {
                result[exitQueue.poll()] = time;
                lastAction = 1;
            } else if (!enterQueue.isEmpty()) {
                result[enterQueue.poll()] = time;
                lastAction = 0;
            } else {
                lastAction = -1; // If no one uses the door, reset lastAction
            }

            time++;
        }

        return result;
    }

    }