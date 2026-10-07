class Solution {
    public int maxProfit(int[] prices) {
     // Input: array of integers prices where prices[i], each index in prices array holds the price of neetcoin on the ith day
     // 0th day, 0th index price, 1st day 1st index price etc
     // Choose a single day to buy one neetcoin and choose a different day in the future to sell it
     // basically, choose the day aka index with the lowest value to buy the neet coin and choose the day aka index with the highest value to sell the neetcoin.
     // Return the maximum profit you can achieve, you may choose to not make any transactions in which case profit would be 0.
     // create a variable buy, which holds the index or the day of buying the coin
     // create a variable sell, which holds the index or the day of selling the coin
     // As the days pass, you cannot go to the previous elements of the buying index to look for a higher value of selling the coin, so you should only look for selling day in the forward direction coming after the buying day
     // We will also have a profit variable which calculates difference betweent the elements pointed by selling index and buying index
     // We keep updating this profit variable for every new two pair of elements
     // We will also keep a final profit which will hold the max profit calculated
     // We can use a two pointer approach, first pointer will look for the day of buying and second pointer will look for the day of selling
     // So left pointer will look for the day of buying, and right pointer will look for the day of selling. The only case where profit can be made, is, when prices[right] > prices[left], so for this condition calculate the profit and then increment our right pointer to look for an even greater profit.
     // but if prices[left] > prices[right], then we need to look for a new day of buying, so make our left go the right index, and also increment our right index
     int maxProfit = 0;
     
     int left = 0; 
     int right = 1;

     while(right < prices.length){
        if(prices[left] < prices[right]){
            int profit = prices[right] - prices[left];
            maxProfit = Math.max(maxProfit, profit);
        } else {
            left = right;
        }
        right++;
     }
     
     return maxProfit;

    }
}
