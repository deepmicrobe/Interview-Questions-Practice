import java.util.Arrays;

public class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] sideSkyline = new int[grid.length];
        int[] verticalSkyline = new int[grid.length];

        // Find max at each row and column
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // If row value is greater than max row value, replace it
                if (grid[i][j] > sideSkyline[i]){
                    sideSkyline[i] = grid[i][j];
                }
                // If column value is greater than vertical column value, replace it
                if (grid[i][j] > verticalSkyline[j]) {
                    verticalSkyline[j] = grid[i][j];
                }
            }
        }

//        System.out.println(Arrays.toString(sideSkyline));
//        System.out.println(Arrays.toString(verticalSkyline));
        int sum = 0;
        int[][] maxSkyline = new int[grid.length][grid.length];
        for (int i = 0; i < maxSkyline.length; i++) {
            for (int j = 0; j < maxSkyline[i].length; j++) {
                // Value is the intersection of vert and side minus grid value
                if (sideSkyline[i] <= verticalSkyline[j]) {
                    sum += sideSkyline[i] - grid[i][j];
                }
                else {
                    sum += verticalSkyline[j] - grid[i][j];
                }
            }
        }

        return sum;
    }
}
