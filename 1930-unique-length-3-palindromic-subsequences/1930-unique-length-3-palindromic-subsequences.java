class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<Character> done = new HashSet<>();

        int index = 0;
        int count = 0;

        while(index < s.length()){
            char curr = s.charAt(index);
            int right = s.length() -1;

            while(right > index+1 && s.charAt(right) != curr){
                right--;
            }
            if(right > index+1){
                Set<Character> set = new HashSet<>();
                for(int i = index+1; i< right; i++){
                    set.add(s.charAt(i));
                }
                count += set.size();
            }

            done.add(curr);
            while(index < s.length() && done.contains(s.charAt(index))){
                index++;
            }
        }
        return count;
    }
}