class Solution {
    public int coinChange(int[] coins, int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n+1);
        dp[0] = 0;
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }
        return dp[n] == n+1 ? -1 : dp[n];
    }
}