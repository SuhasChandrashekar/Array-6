// Time Complexity : O(exponentinal)
// Space Complexity : O(exponentinal)

class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        return helper(prices, 0, -1, 0);        
    }
    
    private int helper(int[] prices, int index, int prevBuy, int profit){
        //base
        if(index >= prices.length)
            return profit;
        //logic
        if(prevBuy == -1){
            return Math.max(helper(prices, index + 1, -1, profit), 
                           helper(prices, index + 1, prices[index], profit));
        }
        else
            return Math.max(helper(prices, index + 1, prevBuy, profit),
                            helper(prices, index + 2, -1, profit + prices[index] - prevBuy));
    }
}