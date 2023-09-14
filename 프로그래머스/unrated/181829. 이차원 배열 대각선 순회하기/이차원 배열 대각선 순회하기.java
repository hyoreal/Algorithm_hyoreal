import java.util.stream.IntStream;

class Solution {
    public int solution(int[][] board, int k) {
        return IntStream.range(0, board.length).filter(i -> i <= k).map(i -> IntStream.range(0, board[i].length).filter(j -> j <= k - i).map(j -> board[i][j]).sum()).sum();
    }
}