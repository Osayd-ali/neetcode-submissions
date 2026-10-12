//Input: given an integer array prices where prices[i] is the price of Neetcoin on the ith day
//Indexes are representing the days, and the values are representing the price of neet coin on that day
//Choose a single day to buy one neet coin, so choose an index for buying
//Choose a different day in the future to sell it, so choose an index for selling
//Return the maximum profit you can achieve
// So max profit can only be calculated, if we choose the day with the lowest value for buying and choose a day with the highest value for selling
// if no profit can be computed then return 0
// For this problem, we need to maintain the original order of indexes so we cannot sort the array
// buy reference, will point to the day that you're going to buy the coin
// sell reference, will point to the day that you're doing to sell the coin
// use a nested loop approach, where outer loop looks for buying index, and inner loop looks for selling index and calculate the max profit
// For each comparison of values, keep updating our max profit
// As days cant be reversed, we cannot choose a previous day to sell the coin, so when looking for selling index always look forward one after the buying day
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i=0; i<prices.length; i++){
            for(int j=i+1; j<prices.length; j++){
                // Profit can only be calculated if the selling value is greater than the buying value
                if(prices[j] > prices[i]){
                    int profit = prices[j] - prices[i];
                    maxProfit = Math.max(profit, maxProfit);
                }
            }
        }
        return maxProfit;
    }
}
