class Solution {
    static int timer;
    static List<List<Integer>> adj;
    static int[] disc;
    static int[] low;
    static List<List<Integer>> bridges;


    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        adj = new ArrayList<>();

        for (int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for (List<Integer> edge : connections) {
                 int u = edge.get(0);
                 int v = edge.get(1);

                  adj.get(u).add(v);
                  adj.get(v).add(u);

    }
    disc = new int[n];
        low = new int[n];

        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);

        bridges = new ArrayList<>();

        timer = 0;

        
        for (int i = 0; i < n; i++) {

            if (disc[i] == -1) {
                dfs(i, -1);
            }
        }

        return bridges;

}
static void dfs(int u, int parent) {

        disc[u] = low[u] = timer++;

        for (int v : adj.get(u)) {

            
            if (v == parent)
                continue;

            
            if (disc[v] == -1) {

                dfs(v, u);

                
                low[u] = Math.min(low[u], low[v]);

                
                if (low[v] > disc[u]) {
                    bridges.add(Arrays.asList(u, v));
                }
            }
            else {
               
                low[u] = Math.min(low[u], disc[v]);
            }
        }
}
}