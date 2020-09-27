class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
         //there should be at most 2 different elements in nums more than n/3
         //so we can find at most 2 elements based on Boyer-Moore Majority Vote algo
         List<Integer> res = new ArrayList<Integer>();
         if(nums.length==0) return res;
         int count1=0,count2=0,m1=0,m2=0;
         for(int n : nums){
             if(m1==n) count1++;
             else if(m2==n) count2++;
             else if(count1==0) {
                 m1=n;
                 count1=1;
             }
             else if(count2==0) {
                 m2=n;
                 count2=1;
             }
             else{
                 count1--;
                 count2--;
             }
         }
         count1=0;
         count2=0;
         //count the number for the 2 elements
         for(int n:nums){
             if(n==m1) count1++;
             else if(n==m2) count2++;
         }
         //if those appear more than n/3
         if(count1>nums.length/3) res.add(m1);
         if(count2>nums.length/3) res.add(m2);
         return res;
    }
}
