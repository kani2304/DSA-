class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> li= new ArrayList<List<Integer>>();
         Arrays.sort(arr);
         int minDiff=Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++){
          minDiff=Math.min(Math.abs(arr[i+1]-arr[i]),minDiff);
        }
         for(int i=0;i<arr.length-1;i++){
         if(minDiff==Math.abs(arr[i+1]-arr[i])){
             List<Integer> li1=new ArrayList<>();
             li1.add(arr[i]);
             li1.add(arr[i+1]);
            li.add(li1);
         }
        }
        return li;
    }
}