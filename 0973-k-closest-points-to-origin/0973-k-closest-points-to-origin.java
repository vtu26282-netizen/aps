class Solution {
    public int[][] kClosest(int[][] points, int k) {

        // Step 1: Compute squared distances
        int n = points.length;
        int[][] V = new int[n][2]; // [squared_distance, index]
        for (int i = 0; i < n; i++) {
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            V[i][0] = dist;
            V[i][1] = i;
        }

        // Step 2: Sort by distance ascending
        Arrays.sort(V, (a, b) -> a[0] - b[0]);

        // Step 3: Extract K closest points
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) ans[i] = points[V[i][1]];
        return ans;
    }
}