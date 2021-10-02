// Time Complexity : O(n * k)
// Space Complexity : O(k)

class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        if(k > prices.length / 2){
            int result = 0;
             for(int i = 1; i < prices.length; i++) {
                 if(prices[i] > prices[i - 1]) {
                     result += prices[i] - prices[i - 1];
                 }
             }
            return result;
        }
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        Arrays.fill(buy, Integer.MAX_VALUE);
        for(int i = 0; i < prices.length; i++){
            for(int j = 1; j <= k; j++){
                buy[j] = Math.min(buy[j], prices[i] - sell[j - 1]);
                sell[j] = Math.max(sell[j], prices[i] - buy[j]);
            }
        }
        return sell[k];
    }
}