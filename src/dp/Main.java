package dp;

import java.util.Arrays;

public class Main {
    public static int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        int height[] = new int[n];
        int left[] = new int[n];
        int right[] = new int[n];
        Arrays.fill(right,n-1);
        int areaMax = 0;
        for(int i = 0; i<m;i++){
            char row[] = matrix[i];
            //计算高度数组
            for(int j = 0;j<n;j++){
                if(row[j] == '1'){
                    height[j] = height[j] + 1;
                }
                else{
                    height[j] = 0;
                }
            }
            //计算左边界数组
            int curleft = 0;
            for(int j = 0; j<n; j++){
                if(row[j] == '0'){
                    left[j] = 0;
                    curleft = j+1;
                }
                else {
                    left[j] = Math.max(left[j],curleft);
                }
            }
            //计算右边界数组
            int curright = n-1;
            for(int j = n-1;j>=0;j--){
                if(row[j] == '0'){
                    right[j] = n-1;
                    curright = j-1;
                }else {
                    right[j] = Math.min(right[j],curright);
                }
            }
            for(int j = 0;j<n;j++){
                areaMax = Math.max(height[j]*(right[j] - left[j] + 1),areaMax);
            }

        }
        return  areaMax;

    }
    public static  int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        int height[] = new int[n];
        int left[] = new int[n];
        int right[] = new int[n];
        Arrays.fill(right,n-1);
        int areaMax = 0;
        for(int i = 0; i<m;i++){
            char row[] = matrix[i];
            //计算高度数组
            for(int j = 0;j<n;j++){
                if(row[j] == '1'){
                    height[j] = height[j] + 1;
                }
                else{
                    height[j] = 0;
                }
            }
            //计算左边界数组
            int curleft = 0;
            for(int j = 0; j<n; j++){
                if(row[j] == '0'){
                    left[j] = 0;
                    curleft = j+1;
                }
                else {
                    left[j] = Math.max(left[j],curleft);
                }
            }
            //计算右边界数组
            int curright = n-1;
            for(int j = n-1;j>=0;j--){
                if(row[j] == '0'){
                    right[j] = n-1;
                    curright = j-1;
                }else {
                    right[j] = Math.min(right[j],curright);
                }
            }
            for(int j = 0;j<n;j++){
                int l = Math.min(height[j],(right[j] - left[j] + 1));
                areaMax = Math.max(l*l,areaMax);
            }

        }
        return  areaMax;
    }

    public static  int maximalSquare2(char[][] matrix) {
        int m = matrix.length;
        if(m == 0) return  0;
        int n = matrix[0].length;
        int dp[] = new int[n];
        int maxl = 0;
        for(int i = 0; i<m;i++){
            int pre = 0;
            int left = 0;
            char row[] = matrix[i];
            for(int j = 0;j<n;j++){
                if(row[j] == '1'){
                    int temp;
                    temp = Math.min(pre,left);
                    temp = Math.min(temp,dp[j]);
                    pre = dp[j];
                    dp[j] = temp + 1;
                    left = dp[j];
                }else {
                    pre = dp[j];
                    dp[j] = 0;
                    left = 0;
                }

                maxl = Math.max(maxl,dp[j]);
            }
        }
        return maxl*maxl;
    }

    public static void main(String[] args) {
        char  matrix[][] = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','1','1','1'}};
        System.out.println(maximalSquare2(matrix));
    }
}
