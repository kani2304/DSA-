class Solution {
    public boolean uniformArray(int[] a) {
        int odd = Integer.MAX_VALUE;

        for (int x : a)
            if (x % 2 != 0) odd = Math.min(odd, x);

        if (odd == Integer.MAX_VALUE) return true;

        for (int x : a)
            if (x % 2 == 0 && x <= odd) return false;

        return true;
    }
}