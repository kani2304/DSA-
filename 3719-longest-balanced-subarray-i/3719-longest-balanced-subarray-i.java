class Solution {
    public int longestBalanced(int[] nums) 
    {
        int n = nums.length;
        int max = 0;

        for(int i = 0; i < n; i++)
        {
            if(max >= n - i)
            {
                break;
            }

            Set<Integer> even = new HashSet<>();
            Set<Integer> odd = new HashSet<>();
            int ind = i;

            while(ind < n)
            {
                if(nums[ind] % 2 == 0)
                {
                    even.add(nums[ind]);
                }
                else
                {
                    odd.add(nums[ind]);
                }

                if(even.size() == odd.size())
                {
                    max = Math.max(max, ind - i + 1);
                }

                ind++;
            }
        }

        return max;
    }
}