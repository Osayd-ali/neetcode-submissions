class Solution {
    public int maxProfit(int[] prices) {
        //input: integer array prices where prices[i] is the price of NeetCoin on the ith day
        // You may choose a single day to buy one NeetCoin and choose a different day in the future to sell it
        // output: return the maximum profit you can achieve, you may choose to not make any transactions, in which case the profit would be 0.
        //initializing a result variable which intitially holds 0 profit
        // // In this brute force nested loop approach, we are looking to find two values with the largest differnce
        // int res = 0;
        // // outer for loop for tracking the day at which the coin is best to buy, aka the minimum value in array
        // for(int i =0; i<prices.length; i++){
        //     int buy = prices[i]; // the value at the day we are buying the coin
        //     for(int j=i+1; j<prices.length; j++){
        //         int sell = prices[j]; // the value at the day we are selling the coin
        //         res = Math.max(res, sell - buy); // take the max value of previous result or the difference between sell and buy value
        //     }
        // }
        // return res;
        // Slightly optimal approach using parallel two pointers
        // left pointer will point to 0th index
        // right pointer will point to i+1th index for a start
        // maxP to track max profit
        int left = 0, right = 1;
        int maxP = 0;

        while(right<prices.length){ // as long as right index is within the array
            if(prices[left]<prices[right]){ // essentially looking for a small value to buy and a big value to sell to maximise profit
                int profit = prices[right] - prices[left];
                maxP = Math.max(maxP, profit);
            } else {
                left = right;
            }
            right++;
        }
        return maxP;
    }
}
