class Solution {

    public int minimumPairRemoval(int[] nums) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int n : nums) {
            list.add(n);
        }

        int operations = 0;

        while (!isSorted(list)) {

            int minSum = Integer.MAX_VALUE;
            int index = 0;

            // find adjacent pair with minimum sum
            for (int i = 0; i < list.size() - 1; i++) {
                int sum = list.get(i) + list.get(i + 1);
                if (sum < minSum) {
                    minSum = sum;
                    index = i;
                }
            }

            // merge the pair
            list.remove(index);
            list.remove(index);
            list.add(index, minSum);

            operations++;
        }

        return operations;
    }

    private boolean isSorted(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}