class Solution {
    // input: An array of heights
    // output: an integer which represents the maximum area the container can hold
    // each index in our array is represented as height bars
    // we need to find two indexes which are far apart from each other but also high enough to maximise our area
    // area would be calculater by height and width
    // height that's the min of two selected bars and mutiplied by the difference of their indexes that would be our width
    public int maxArea(int[] heights) {
        int res = 0; //result tracker to track out result
        for (int i = 0; i < heights.length; i++) { // keeping track of our first height bar
            for (int j = i + 1; j < heights.length; j++) { // keeping track of our second height bar
                res = Math.max(res, Math.min(heights[i], heights[j]) * (j - i)); 
                //calculating area
            }
        }
        return res;
    }
    // optimal using two pointer
    //     int l = 0;
    //     int r = heights.length - 1;
    //     int res = 0;

    //     while (l < r) {
    //         int area = Math.min(heights[l], heights[r]) * (r - l);
    //         res = Math.max(res, area);
    //         if (heights[l] <= heights[r]) {
    //             l++;
    //         } else {
    //             r--;
    //         }
    //     }
    //     return res;
}
