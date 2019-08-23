import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    int[] costs;
    Integer[] memo;
    Set<Integer> dayset;
    public static void main(String[] args) {
        List<Integer> ans = new ArrayList<>();
//        String s="bb";
//        String ret = new Main().longestPalindrome(s);
//        System.out.println(ret);
//        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
//        int ret = new Main().minPathSum(grid);
//        System.out.println(ret);
//        int[] piles = {5,3,4,5};
//        boolean ret = new Main().stoneGame(piles);
//        System.out.println(ret);
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2,7,15};
        int ret = new Main().mincostTickets(days,costs);
        System.out.println(ret);
    }
    public int mincostTickets(int[] days, int[] costs) {
        this.costs = costs;
                memo = new Integer[366];
                dayset = new HashSet();
                for (int d: days) dayset.add(d);

                return dp(1);
            }

            public int dp(int i) {
                if (i > 365)
                    return 0;
                if (memo[i] != null)
                    return memo[i];

                int ans;
                if (dayset.contains(i)) {
                    ans = Math.min(dp(i+1) + costs[0],
                            dp(i+7) + costs[1]);
                    ans = Math.min(ans, dp(i+30) + costs[2]);
                } else {
                    ans = dp(i+1);
                }

                memo[i] = ans;
                return ans;
            }

    public boolean stoneGame(int[] piles) {
        int length = piles.length;
        int[][] dp = new int [length][length];
        for(int i = 0; i < length; i++){
            dp[i][i] = piles[i];
        }
        for(int d = 1 ; d <= length; d++){
            for(int i = 0; i + d < length; i++){
                int j = i + d;
                dp[i][j] = Math.max(piles[i] - dp[i+1][j], piles[j] - dp[i][j-1]);
            }
        }
        return dp[0][length-1] > 0? true:false;
    }

    public int minPathSum(int[][] grid) {//左上到右下最小路径和
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0 ;i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                }else if(i == 0 && j > 0){
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                }else if(i > 0 && j == 0){
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }else{
                    int a = dp[i-1][j];
                    int b = dp[i][j-1];
                    dp[i][j] =( a > b ? b : a) + grid[i][j];
                }
            }
        }
        return dp[m-1][n-1];
    }


    public String longestPalindrome(String s) {//最长回文子串
        if(s.isEmpty()) return "";
        int start = 0, longest = 1;
        int[][] dp = new int[1002][1002];
        for(int i = 0; i < s.length(); i++){
            dp[i][i] = 1;
            if(i < s.length()-1){
                if(s.charAt(i) == s.charAt(i+1)){
                    dp[i][i+1] = 1;
                    start = i;
                    longest = 2;
                }
            }
        }
        for(int i = 0; i < s.length();i++){
            for(int j = 0;j<s.length();j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(start);
        System.out.println(longest);
        for(int l = 3; l <= s.length(); l++){
            for(int i = 0; i+l-1 < s.length(); i++){
                int j = i+l-1;
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == 1){
                    dp[i][j] = 1;
                    start = i;
                    longest = l;
                }
            }
        }
        for(int i = 0; i < s.length();i++){
            for(int j = 0;j<s.length();j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(start);
        System.out.println(longest);
        return s.substring(start,start+longest);
    }

}
