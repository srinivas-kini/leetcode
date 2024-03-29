// https://leetcode.com/problems/edit-distance/
class MinDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        Integer[][] dp = new Integer[m+1][n+1];
        
        for(int i = 0; i <= m; i ++){
            for(int j = 0; j <=n ; j ++){
                if(i == 0 || j==0)
                    dp[i][j] = Math.max(i,j);
                else if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) + 1;
                } 
            }
        }
        
        return dp[m][n];
    }
}
