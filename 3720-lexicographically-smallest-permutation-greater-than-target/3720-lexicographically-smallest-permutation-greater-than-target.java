class Solution {
    int x=1;
    public String lexGreaterPermutation(String s, String target) {
        int[] c = new int[26];
        for(int i=0; i<s.length(); i++) {
            c[s.charAt(i)-'a']++;
        }
        StringBuilder a = new StringBuilder("");
        x=1;
        solve(a,target,c,0);
        return a.toString();
    }
    void solve(StringBuilder a, String t, int[] c, int i){
        if(x==0) return;
        if(i==t.length()) {
            if(a.toString().compareTo(t)>0) {
                x=0;
            }
            return;
        }
        
        for(int i1=0; i1<26; i1++){
            if(c[i1]!=0){
                if (a.toString().equals(t.substring(0, i)) && (char)(i1+'a') < t.charAt(i)) continue;

                a.append((char)(i1+'a'));
                c[i1]--;
                solve(a,t,c,i+1);
                if(x==0)return;
                a.deleteCharAt(a.length()-1);
                c[i1]++;
            }
        }
    }
}