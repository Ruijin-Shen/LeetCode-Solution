import java.util.*;


public class Combination {
    private long mod;
    private long[][] table;

    /**
     * <p> Precompute the number of k-combinations of a set which
     * has n elements, denoted by C(n, k).
     * <p> Time complexity: O(n^2)
     * <p> Space complexity: O(n^2)
     */
    public Combination(long mod, int n){
        int length = n + 1;
        this.mod = mod;
        this.table = new long[length][length];
        for(int i = 0; i < length; i++){
            table[i][0] = table[i][i] = 1;
        }
        for(int i = 2; i < length; i++){
            for(int j = 1; j < i; j++){
                table[i][j] = (table[i - 1][j - 1] + table[i - 1][j]) % mod;
            }
        }
    }

    /**
     * <p> This function calculates the number of k-combinations
     * of a set which has n elements, denoted by C(n, k).
     * <p> Time complexity: O(1), for the two-dimensional
     * array {@code table} records the precomputed results.
     * <p> In mathematics, a combination is a selection of items
     * from a set that has distinct members, such that the order
     * of the selection does not matter.
     * <p> Formally,a k-combination of a set S is a subset of k
     * distinct elements of S. C(n, k) is equal to the binomial
     * coefficient: C(n, k) = n!/(k!(n-k)!)
     * @return the number of k-combinations of a set which has
     * n elements
     */
    public long combination(int n, int k){
        return table[n][k];
    }

    /**
     * Time complexity and space complexity: combineHelperDFS
     * and combineHelper
     * @return all possible combinations of k numbers chosen from
     * the range [1, n].
     * @see #combineHelperDFS(int, int, int, int, int[], List)
     * @see #combineHelperLexicographicOrder(int, int)
     */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        combineHelperDFS(n, k, 0, 0, new int[k], result);
        return result;
    }

    /**
     * Time complexity: O(C(n, k) * k)
     * Space complexity: O(k)
     */
    private static void combineHelperDFS(int n, int k, int depth, int num, int[] combination, List<List<Integer>> result){
        if(num == k){
            ArrayList<Integer> list = new ArrayList<>(k);
            for(int ele : combination) list.add(ele);
            result.add(list);
            return;
        }
        if(n - depth + num < k) return;

        for(int nextEle = depth + 1; nextEle <= n; nextEle++){
            combination[num] = nextEle;
            combineHelperDFS(n, k, nextEle, num + 1, combination, result);
        }
    }

    /**
     * Time complexity: O(C(n, k) * k)
     * Space complexity: O(k)
     */
    private static List<List<Integer>> combineHelperLexicographicOrder(int n, int k){
        List<List<Integer>> result = new LinkedList<>();
        int[] temp = new int[k + 1];
        for(int i = 0; i < k; i++){
            temp[i] = i + 1;
        }
        temp[k] = n + 1;

        while(true){
            List<Integer> combination =  new ArrayList<>(k);
            for(int i = 0; i < k; i++){
                combination.add(temp[i]);
            }
            result.add(combination);

            int gap = -1;
            for(int i = 0; i < k; i++){
                if(temp[i + 1] - temp[i] > 1){
                    gap = i;
                    break;
                }
            }
            if(gap != -1){
                temp[gap]++;
                for(int i = 0; i < gap; i++){
                    temp[i] = i + 1;
                }
            }else{
                break;
            }
        }
        return result;
    }
}