class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] res = new int[n];
        Set<Integer> seenA = new HashSet<>();
        Set<Integer> seenB = new HashSet<>();
        int cnt = 0;

        for(int i = 0; i<n; i++){
            
            if (seenB.contains(A[i])) {
                cnt++;
            }

            if (seenA.contains(B[i])) {
                cnt++;
            }

            // same new element added from both sides
            if (A[i] == B[i]) {
                cnt++;
            }

            seenA.add(A[i]);
            seenB.add(B[i]);

            res[i] = cnt;
        }
        return res;
    }   
}