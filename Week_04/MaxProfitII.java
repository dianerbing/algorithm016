package wb.test;

public class MaxProfitII {
    public int maxProfit(int[] prices) {
        //低点买入，高点卖出
        boolean inOut = true;   //true - 待买入；false - 待卖出
        int in = 0, earn = 0;
        for (int i = 0; i < prices.length; i++) {
            if (inOut && i > 0 && prices[i] > prices[i-1]) {
                //买入
                in = prices[i-1];
                inOut = false;
                // System.out.println(in + "买入");
            }

            if (!inOut && i > 0 && prices[i] < prices[i-1]) {
                //卖出
                earn += prices[i-1] - in;
                inOut = true;
                // System.out.println(prices[i-1] + "卖出");
            }

            if (!inOut && i == prices.length - 1) {
                //卖出
                earn += prices[i] - in;
                inOut = true;
                // System.out.println(prices[i-1] + "卖出");
            }
        }

        return earn;
    }
}
