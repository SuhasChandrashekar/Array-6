// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;
        int min = prices[0];
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }
}