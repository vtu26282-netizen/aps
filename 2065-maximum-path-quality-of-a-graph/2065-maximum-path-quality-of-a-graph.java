class Solution {
    private class Edge{
        int dest;
        int time;
        int wt;
        
        Edge(){
            
        }
        
        Edge(int dest, int time, int wt){
            this.dest = dest;
            this.time = time;
            this.wt = wt;
        }
    }
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        HashMap<Integer, List<Edge>> graph = new HashMap<>();
        for(int i = 0; i < values.length; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            int [] edge = edges[i];
            int src = edge[0];
            int dest = edge[1];
            int time = edge[2];
            int weight = values[src];
            
            List<Edge> al = graph.get(src);
            al.add(new Edge(dest, time, weight));
            graph.put(src, al);
            al = graph.get(dest);
            al.add(new Edge(src, time, values[dest]));
            graph.put(dest, al);
        }
        ans = 0;
        int [] visited = new int[values.length];
        dfs(graph, values, 0, 0, maxTime, 0, visited);
        return ans;
    }
    
    int ans;
    
    private void dfs(HashMap<Integer, List<Edge>> graph, int[] values, int src, int time, int maxtime, int score, int [] visited){
        if(time > maxtime){
            return;
        }
        if(visited[src] == 0){
            score += values[src];
        }
        if(src == 0){
            ans = Math.max(ans, score);
        }
        List<Edge> al = graph.get(src);
        
        visited[src]++;
        for(Edge e : al){
            
            dfs(graph, values, e.dest, e.time + time, maxtime, score, visited);
        }
        visited[src]--;
    }
}