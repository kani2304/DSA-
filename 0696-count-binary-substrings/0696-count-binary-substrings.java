class Solution {
    public int countBinarySubstrings(String s) {
        List<Integer> table = new ArrayList<>();
        int count = 1;
        for (int i = 1;i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) count++;
            else {
                table.add(count);
                count = 1;
            }
        }
        table.add(count);
        int res = 0;
        for (int i = 1; i< table.size(); i++) {
            res += Math.min(table.get(i - 1), table.get(i));
        }
        return res;
    }
}