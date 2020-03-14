public class MaximalSquare {

    // Brute Force
    public static int maximalSquare1(char[][] matrix) {
        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;
        int maxsqLen = 0;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(matrix[i][j] == '1') {
                    int sqlen = 1;
                    boolean flag = true;
                    while(sqlen + i < rows && sqlen + j < cols && flag) {
                        for(int k = j; k <= sqlen + j; k++) {
                            if(matrix[i+sqlen][k] == '0') {
                                flag = false;
                                break;
                            }
                        }

                        for(int k = i; k <= sqlen + i; k++) {
                            if(matrix[k][j+sqlen] == '0') {
                                flag = false;
                                break;
                            }
                        }

                        if(flag) {
                            sqlen++;
                        }
                    }
                    maxsqLen = Math.max(maxsqLen, sqlen);
                }
            }
        }

        return  maxsqLen * maxsqLen;
    }

    // Dynamic Programming
    public static int maximalSquare2(char[][] matrix) {
        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows+1][cols+1];
        int maxsqlen = 0;

        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= cols; j++) {
                if(matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }


    public static void main(String[] args) {
        char[][] input = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        System.out.println("Brute force: " +maximalSquare1(input));
        System.out.println("DP: " +maximalSquare2(input));
    }

}
