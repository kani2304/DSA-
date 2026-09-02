class Solution {
    public boolean uniformArray(int[] nums1) {
        int j=0; int odd=0; int even=0;
        while(j<nums1.length)
        {
            if(nums1[j]%2==0)
            {
                even++;
            }
            else{
                odd++;
            }
            j++;
        }
        if(even==nums1.length || odd==nums1.length) return true;
        int[] nums2=new int[nums1.length];
        for(int i=0;i<nums2.length;i++)
        {
            nums2[i]=nums1[i];
        }

        for(int i=0;i<nums2.length;i++)
        {
            nums2[i]=nums1[i]-nums1[i+1];
            if(nums2[i]%2==0)
            {
                even++;
            }
            else{
                odd++;
            }
            if(even==nums2.length || odd==nums2.length) return true;
        } 
        return false;
    }
}