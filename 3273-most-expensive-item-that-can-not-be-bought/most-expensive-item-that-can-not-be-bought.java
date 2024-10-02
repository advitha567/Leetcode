class Solution {
    public int mostExpensiveItem(int primeOne, int primeTwo) {
        int size = primeOne * primeTwo;
        int[] dp = new int[size + 1]; 
        dp[primeOne] = 1; 
        dp[primeTwo] = 1; 


        for (int i = 0; i <= size; i++) {
            if (i - primeTwo >= 0 && dp[i - primeTwo] == 1) {
                dp[i] = 1; 
            }
            if (i - primeOne >= 0 && dp[i - primeOne] == 1) {
                dp[i] = 1; 
            }
        }

        for (int i = size; i >= 0; i--) {
            if (dp[i] == 0) {
                return i; 
            }
        }

        return 1; 
    }
}
