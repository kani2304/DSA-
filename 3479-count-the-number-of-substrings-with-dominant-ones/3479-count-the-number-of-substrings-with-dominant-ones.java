class Solution {
    public int numberOfSubstrings(String s) {
        int ans = 0;
        int[] prefix = new int[s.length()];
        prefix[0] = s.charAt(0) == '1' ? 1 : 0;
        for(int i = 1 ; i < s.length() ; i++){
            prefix[i] = prefix[i-1] + (s.charAt(i) == '1' ? 1 : 0);
        }
        for(int i = 0 ; i < s.length() ; i++){
            for(int j = i ; j < s.length() ; j++){
                int one = prefix[j] - (i-1 >=0 ? prefix[i-1] : 0);
                int zero = j-i+1 - one;
                if(one < zero * zero){
                    int k = zero * zero - one;
                    j += k-1;
                }else if(one == zero * zero){
                    ans++;
                }else{
                    ans++;
                    int k = (int)Math.sqrt(one) - zero;
                    int next = j+k;
                    if(next >= s.length()){
                        ans += (s.length() - j - 1);
                        break;
                    }else{
                        ans += k;
                    }
                    j = next;
                }
            }
        }
        return ans;
    }
}