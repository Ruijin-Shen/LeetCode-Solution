package Template;

/**
 * <p> disjoint-set data structure, union–find data structure,
 * merge–find set
 * <p> The disjoint-set data structure is a data structure that
 * stores a collection of disjoint (non-overlapping) sets.
 *
 * @author Ruijin Shen
 */
public class DisjointSet {
    private int[] parent;

    public DisjointSet(int n){
        this.parent = new int[n];
        for(int i = 0; i < n; i++){
            // Every element is a distinct set at first.
            this.parent[i] = i;
        }
    }

    public void union(int index1, int index2) {
        parent[find(index1)] = find(index2);
    }

    /**
     * <p> The {@code find} operation follows the chain of parent
     * pointers from a specified query node {@code index} until
     * it reaches a root element.
     * <p> This function is implemented with path compression technique,
     * making every node between the query node and the root point
     * to the root.
     *
     * Time complexity:
     *
     * @param index a specified query node
     * @return the set representative of the query node
     */
    public int find(int index) {
        if (parent[index] != index) {
            // path compression
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }
}
