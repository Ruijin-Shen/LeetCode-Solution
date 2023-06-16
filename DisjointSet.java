public class DisjointSet {
    private int[] parent;

    public DisjointSet(int n){
        this.parent = new int[n];
        for(int i = 0; i < n; i++){
            this.parent[i] = i;
        }
    }

    public void union(int index1, int index2) {
        parent[find(index1)] = find(index2);
    }

    public int find(int index) {
        if (parent[index] != index) {
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }

    public void Union(int index1, int index2){
        parent[find(index1)] = find(index2);
    }
}
