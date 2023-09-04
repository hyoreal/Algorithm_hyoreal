class Solution {
    public int solution(String myString, String pat) {
        myString = myString.toUpperCase();
        pat = pat.toUpperCase();
        return myString.contains(pat) ? 1 : 0;
    }
}