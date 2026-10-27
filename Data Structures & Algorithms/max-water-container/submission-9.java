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
        int maxArea = 0;
        int left = 0;
        int right = heights.length - 1;
        while(left<right){
            int area = Math.min(heights[left], heights[right]) * (right-left);
            maxArea = Math.max(maxArea, area);
            if(heights[left] < heights[right]){
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
