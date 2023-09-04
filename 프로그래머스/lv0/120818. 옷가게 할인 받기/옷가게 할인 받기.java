class Solution {
    public int solution(int price) {
        double answer = price >= 500000 ? price - price * 0.2 : price >= 300000 ? price - price * 0.1 : price >= 100000 ? price - price * 0.05 : price;
        return (int) answer;
    }
}