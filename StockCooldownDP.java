// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2)
            return 0;
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        buy[0] = - prices[0];
        buy[1] = Math.max(buy[0], 0 - prices[1]);
        sell[1] = Math.max(0, prices[1] + buy[0]);
        for(int i = 2; i < n; i++){
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return Math.max(buy[n - 1], sell[n - 1]);
    }
}