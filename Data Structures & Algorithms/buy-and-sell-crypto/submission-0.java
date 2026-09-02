class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];

        for(int price : prices){
            minPrice = Math.min(price, minPrice);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        if(maxProfit <= 0){
            return 0;
        }
        
        return maxProfit;
    }
}

// i 번째 날의 neetCoin 가격
// 아무거래도 하지 않는다 -> 이익 0 내차순인경우.
//현재 가격이 minPrice보다 싸다 → 매수 가격 갱신
//그렇지 않다 -> 현재 가격 - minPrice로 이익 계산 → maxProfit 갱신