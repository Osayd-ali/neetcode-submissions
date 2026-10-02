//Input: Given an integer array heights
// heights[i] represents the height of the ith bar
// Choose any two bars to form a container. Return the maximum amount of water a container can store
// So choosing two bars with the highest of heights wouldn't count, as also need to factor in the breadth of our supposed container not just the height. 
// Choosing a container which can hold the most water comes down to, choosing the maximum area between two bars of the array
// Area of a rectangle is A = width * height
// Width is difference between the two bar's indices
// Height is already given in the array, so aim for choosing the highest heights typically, take the min of the selected heights
// So choosing the bars with the longest heights, but also should maintain the largest width.
// The most brute force approach would be, we try every possible pair of bars and compute the area for every possible pair, selecting the min height of the selected pair of bars
// So the brute force approach would be, select the first bar of our supposed pair through the outer loop, then through an inner loop visit all the remaining bars coming after the selected bar, and compute the area for each possible pair
// While computing the area for each possible pair, store it in a variable which keeps resetting after every inner loop iteration, but before that iteration ends, we store the max of our global result and area for that specific pair into our global result
// So this way we are updating our global result with the max of each area
// Width will be difference of the indices i.e. jth index minus ith index
// Height will be minimum of values selected at both indexes
class Solution {
    public int maxArea(int[] heights) {
        // int globalResult = 0; // This will hold our final result

        // for(int i=0; i<heights.length; i++){
        //     int width = 0; // For every possible pair, this will be recomputed
        //     int area = 1;
        //     for(int j=i+1; j<heights.length; j++){
        //         int height = Math.min(heights[i], heights[j]);
        //         width = j-i;
        //         area = width * height;
        //         globalResult = Math.max(globalResult, area);
        //     }
        // }

        // return globalResult;

        // But is there a real need for having inner loop to look for the second bar?
        // Cant we apply a two pointer approach and compute area between two bars for each iteration of our two pointer approach
        // By applying this convergent two pointer approach, we are already starting with the maximum width possible, so now we can only focus on looking at bars with the most heights, and move our pointers to bars with greater heights
        // Left pointer will point to the first index of the array of heights
        // Right pointer will point to the last index of the array of heights
        // Get the min of heights pointer by both indices, this will be our height
        // Compute the difference between both indices, this will be our width
        // Comput the area for each iteration
        // But whats the condition for incrementing and decrementing our left and right pointers
        // Move the pointer that has the smaller height value
        // Why the smaller height pointer? because we wanna increase our area maybe thats why
        // By applying this convergent two pointer approach, we are already starting with the maximum width possible, so now we can only focus on looking at bars with the most heights, and move our pointers to bars with greater heights

        int globalResult = 0;

        int left = 0;
        int right = heights.length - 1;

        while(left < right){
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);
            int area = width * height;

            // Whichever currently selected heights pointer by left and right is smaller move that
            if(heights[left] < heights[right]){
                left++;
            } else {
                right--;
            }
            globalResult = Math.max(globalResult, area);
        }
        return globalResult;
    }
}
