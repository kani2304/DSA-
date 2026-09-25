class Solution {
    private String s;
    private int index;

    public List<String> braceExpansionII(String expression) {
        s = expression;
        index = 0;

        Set<String> result = parseUnion();

        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);

        return ans;
    }

    private Set<String> parseUnion() {
        Set<String> result = new HashSet<>();

        while (index < s.length() && s.charAt(index) != '}') {
            Set<String> part = parseConcat();
            result.addAll(part);

            if (index < s.length() && s.charAt(index) == ',') {
                index++;
            }
        }

        return result;
    }

    private Set<String> parseConcat() {
        Set<String> result = new HashSet<>();
        result.add("");

        while (index < s.length()
                && s.charAt(index) != '}'
                && s.charAt(index) != ',') {

            Set<String> current;

            if (s.charAt(index) == '{') {
                index++;
                current = parseUnion();
                index++;
            } else {
                current = new HashSet<>();
                current.add(String.valueOf(s.charAt(index)));
                index++;
            }

            Set<String> next = new HashSet<>();

            for (String a : result) {
                for (String b : current) {
                    next.add(a + b);
                }
            }

            result = next;
        }

        return result;
    }
}