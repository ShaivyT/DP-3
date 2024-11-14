// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int deleteAndEarn(int[] nums) {

        // convert nums to the array which has the frequency of elements calculated

        int max = Integer.MIN_VALUE;

        for(int num: nums) {
            max = Math.max(max, num);
        }
        
        // found the size of the array
        // array starts from 0 hence + 1
        int[] arr = new int[max + 1];

        for(int num: nums) {
            arr[num] += num;
        }

        int prev = arr[0];
        int curr = Math.max(arr[0], arr[1]);

        for(int i = 2; i < arr.length; i++) {
            int temp = curr;
            curr = Math.max(curr, prev + arr[i]);
            prev = temp;
        }

        return curr;
    }
}

// Time Complexity: O(n*n)
// Space Complexity: O(n*n)

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;
        if(n == 1) return matrix[0][0];
        int min = Integer.MAX_VALUE;

        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < n; j++) {
                
                if(j == 0) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                } else if(j == n - 1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = matrix[i][j] + Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i - 1][j + 1]);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }

        return min;
    }
}
