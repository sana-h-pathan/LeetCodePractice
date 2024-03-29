class Solution {
    public int trap(int[] height) {
        // Initialize two pointers for left and right ends of the array
        int left = 0;
        int right = height.length - 1;
        
        // Initialize variables to track the height of the left and right walls
        int leftWall = 0;
        int rightWall = 0;
        
        // Initialize a variable to store the total trapped water area
        int area = 0;
        
        // Loop until the left and right pointers meet or cross each other
        while (left <= right) {
            // If the left wall is shorter or equal to the right wall
            if (leftWall <= rightWall) {
                // If the current height is less than the left wall height, trap water
                if (leftWall > height[left])
                    area += (leftWall - height[left]) * 1;
                else
                    leftWall = height[left]; // Update the left wall height
                
                left++; // Move the left pointer to the next position
            } else { // If the right wall is shorter than the left wall
                // If the current height is less than the right wall height, trap water
                if (rightWall > height[right])
                    area += (rightWall - height[right]) * 1;
                else
                    rightWall = height[right]; // Update the right wall height
                
                right--; // Move the right pointer to the previous position
            }
        }
        
        return area; // Return the total trapped water area
    }
}
