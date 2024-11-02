class Solution {
    int result(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            int val = entry.getValue();
            count = count + (val * (val + 1)) / 2; 
        }

        return count;
    }

    public int[] sameEndSubstringCount(String s, int[][] queries) {
        int n = s.length();
        int[][] prefixCount = new int[n + 1][26]; 
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                prefixCount[i + 1][j] = prefixCount[i][j];
            }
            prefixCount[i + 1][s.charAt(i) - 'a']++;
        }
        
        int[] answer = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int count = 0;

            for (int j = 0; j < 26; j++) {
                int charCount = prefixCount[end + 1][j] - prefixCount[start][j];
                if (charCount > 0) {
                    count += (charCount * (charCount + 1)) / 2;
                }
            }
            answer[i] = count;
        }
        
        return answer;
    }
}