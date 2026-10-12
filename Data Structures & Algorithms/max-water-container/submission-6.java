//Input: Given an integer array heights, an array consisting of multiple heights
// {1,7,2,5,4,7,3,6}
// heights[i] represents the ith bar, basically the indexes represents bars and their values represent their heights
// Choose two bars aka indexes to form a container
// return the maximum amount of water a container can store
// So the amount of water the container can store can be found out by the area between two containers
// and that would be the height * width
// the height that must be taken into consideration will be the lower height between two selected bars, cuz if we select the higher height then the water will overflow
// the width is basically the distance between two bars, that would be the difference between the indexes of two selected bars
// So here, the brute force approach would be
// choose one bar through an outer loop, 
// then look for the second bar by visiting each bar coming after i through an inner loop
// this way we are considering all combinations of bars
// the outer loop will always choose the first bar, then inner loop will be looking for the second bar and also for computing the area for each pair found, and we keep updating our area
class Solution {
    public int maxArea(int[] heights) {
        // int maxArea = 0;
        // for(int i=0; i<heights.length; i++){
        //     for(int j=i+1; j<heights.length; j++){
        //         int width = j-i;
        //         int height = Math.min(heights[i], heights[j]);
        //         maxArea = Math.max(maxArea, width*height);
        //     }
        // }
        // return maxArea;
        // Too slow, We need to optimise the solution for O(n)
        // Instead of traversing the array and creating pairs for each bar
        // we can point the left pointer towards the 0th bar and the right pointer towards the length-1 bar
        // Then try converging the pointers and get the max area for each pair
        // This way we will only focus on considering heights as we are already starting with the maximum width
        int left = 0;
        int right = heights.length - 1;
        int result = 0;
        // Whats the condition for us to increment and decrement pointers?
        // if the left index height is less than right index height, then we would want to make our area bigger and we would want to move towards a bigger height (potentially)
        // else move the right pointer inside in the case of right index height being less than left index height
        while(left<right){
            // Calculate the area
            int area = Math.min(heights[left], heights[right]) * (right - left);
            result = Math.max(result, area);
            // Now implement the pointer moving logic
            // if the left bar is lower than right bar, we must move towards a bigger bar so increment left pointer     
            if(heights[left]<=heights[right]){
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
