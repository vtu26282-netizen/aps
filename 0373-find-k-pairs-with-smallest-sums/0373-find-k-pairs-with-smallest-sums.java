class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) 
    {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        for(int m : nums1)
        {
            pq.offer(new int[]{m + nums2[0], 0});
        }

        List<List<Integer>> ans = new ArrayList<>();

        while(k-- > 0)
        {
            int[] pair = pq.poll();
            int sum = pair[0];
            int pos = pair[1];

            ans.add(Arrays.asList(sum - nums2[pos], nums2[pos]));

            if(pos + 1 < nums2.length)
            {
                pq.offer(new int[]{sum - nums2[pos] + nums2[pos + 1], pos + 1});
            }
        }

        return ans;
    }
}