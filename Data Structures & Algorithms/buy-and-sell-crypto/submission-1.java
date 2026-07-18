class Solution {
    public int maxProfit(int[] prices) {
       // input is an integer array prices of Neetcoin
       // each index represents the prices at that particular day
       // Choose a single day to buy one neet coind 
       // Choose a different day to sell that neet coin
       // Output: return the maximum profit attained
       // so the maximum difference between the selling price and the buying price
       // we could actually use a nested loop to approach this problem
       // we will run an outerloop to track for the day when we can buy the coin (so essentially the most minimum value)
       // the inside loop will be used to visit all the remaining elements and track which index has the highest value
       // we will try to visit all other elements in the inner loop and calculate profit for each element visited
       // which ever profit is the highest, we will select that index as our selling day and return the profit 
       int profit = 0;
       for(int i=0; i<prices.length; i++){
        for(int j=i+1; j<prices.length; j++){
            int maxProfit = prices[j] - prices[i];
            profit = Math.max(profit, maxProfit);
        }
       }
       return profit;
    }
}
