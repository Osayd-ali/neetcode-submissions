// Input: Integer array prices where the index i represents the day and the vlaue at each index i prices[i] represents the value of neet coin on ith day
// Output: Choose a single day to buy a neet coin, and choose a day to sell it
// so a buy reference which will point to the day the coin should be bought
// A sell reference which will poin to the day the coin should be sold 
// In theory, to make a profit the value at sell reference must be greater than the value at buy reference. 
// Return the maximum profit that can be made
// so a global max reference which will store the max profit
// we will utilise a nested loop approach
// where outer loop is supposed to track the index at which neet coin will be bought, so basically buy index
// Through the inner loop,  we visit all the remaining elements coming after the outer loop's selected index and check if the current element is greater than the buy index element and calculate profit for that current element and store it in our global max profit reference. Profit can only be computed, if inner loop's sell index value is greater than outer loop's buy index value
// So outer loop -> finding buy index
// inner loop -> finding sell index
class Solution {
    public int maxProfit(int[] prices) {

        int maxProfit = 0;

        for(int i=0; i<prices.length; i++){
            int buy = i;
            for(int j = i+1; j<prices.length; j++){
                int sell = j;
                if(prices[sell] > prices[buy]){
                    maxProfit = Math.max(maxProfit, (prices[sell] - prices[buy]));
                }
            }
        }
        return maxProfit;
    }
}
