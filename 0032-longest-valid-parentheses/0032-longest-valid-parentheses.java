class Solution {
    public int longestValidParentheses(String s) {
        int open = 0, close = 0;
        int ans = 0;

        // Left -> Right
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                open++;
            else
                close++;

            if (open == close)
                ans = Math.max(ans, open + close);

            if (close > open) {
                open = 0;
                close = 0;
            }
        }

        // Right -> Left
        open = 0;
        close = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(')
                open++;
            else
                close++;

            if (open == close)
                ans = Math.max(ans, open + close);

            if (open > close) {
                open = 0;
                close = 0;
            }
        }

        return ans;
    }
}