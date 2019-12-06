public class Solution {
    public int maxArea(int[] height) {
        // Pointer for left side
        int left = 0;
        // Pointer for right side
        int right = height.length - 1;

        // Keep track of max area
        int max = 0;
        // Keep track of current area
        int area = 0;

        while (right != left) {
            // Find which value has more height
            if (height[left] <= height[right]) {
                // Set area equal to left height and distance between left and right
                area = height[left] * (right - left);
                if (max < area) {
                    max = area;
                }
                // Increment left
                left++;
            } else if (height[left] > height[right]) {
                // Set area equal to right height and distance between left and right
                area = height[right] * (right - left);
                if (max < area) {
                    max = area;
                }
                // Decrement right
                right--;
            }
        }

        return max;
    }
}
