class Solution {
    public int reverseBits(int n) {
        Integer m=n;
        String s = Integer.toBinaryString(n);

        while (s.length() < 32) {
            s = "0" + s;
        }
        System.out.println(s);
        String reversed = new StringBuilder(s).reverse().toString();
        System.out.println(reversed);
        return (int)Long.parseLong(reversed, 2);
    }
}
