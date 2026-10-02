import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(new StringBuilder(), 0, 0, n, ans);
        return ans;
    }

    void backtrack(StringBuilder s, int open, int close, int n, List<String> ans) {
        if (s.length() == 2 * n) {
            ans.add(s.toString());
            return;
        }
        if (open < n) {
            s.append('(');
            backtrack(s, open + 1, close, n, ans);
            s.deleteCharAt(s.length() - 1);
        }
        if (close < open) {
            s.append(')');
            backtrack(s, open, close + 1, n, ans);
            s.deleteCharAt(s.length() - 1);
        }
    }
}