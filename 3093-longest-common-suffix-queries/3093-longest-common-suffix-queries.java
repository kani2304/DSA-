class Solution {
    class ListNode {
        ListNode[] next = new ListNode[26];
        int index = Integer.MAX_VALUE;
        int len = Integer.MAX_VALUE;
    }

    ListNode node = new ListNode();

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int n = wordsQuery.length;

        int[] ans = new int[n];

        int fill = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < wordsContainer.length; i++) {
            createTrie(wordsContainer[i], i);
            if (wordsContainer[i].length() < min) {
                min = wordsContainer[i].length();
                fill = i;
            }

        }

        for (int i = 0; i < n; i++) {
            ans[i] = getIndex(wordsQuery[i]);
            if (ans[i] == -1) {
                ans[i] = fill;
            }
        }

        return ans;

    }

    private void createTrie(String word, int idx) {
        ListNode curr = node;
        int n = word.length();

        for (int i = n - 1; i >= 0; i--) {
            int ch = word.charAt(i) - 'a';
            if (curr.next[ch] == null) {
                curr.next[ch] = new ListNode();
                curr.next[ch].index = idx;
                curr.next[ch].len = n;
            } else {
                if (curr.next[ch].len > n) {
                    curr.next[ch].index = idx;
                    curr.next[ch].len = n;
                } else if (curr.next[ch].len == n) {
                    curr.next[ch].index = Math.min(curr.next[ch].index, idx);
                }
            }

            curr = curr.next[ch];
        }
    }

    private int getIndex(String word) {
        ListNode curr = node;
        int n = word.length();
        int ans = -1;

        for (int i = n - 1; i >= 0; i--) {
            int ch = word.charAt(i) - 'a';
            if (curr.next[ch] == null) {
                return ans;
            } else {
                ans = curr.next[ch].index;
            }

            curr = curr.next[ch];
        }
        return ans;
    }

}