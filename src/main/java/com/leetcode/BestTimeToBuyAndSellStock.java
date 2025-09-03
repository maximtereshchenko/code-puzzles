package com.leetcode;

final class BestTimeToBuyAndSellStock {

    int maxProfit(int[] prices) {
        var buyingPrice = prices[0];
        var maxProfit = 0;
        for (var i = 1; i < prices.length; i++) {
            var current = prices[i];
            maxProfit = Math.max(maxProfit, current - buyingPrice);
            buyingPrice = Math.min(buyingPrice, current);
        }
        return maxProfit;
    }
}
