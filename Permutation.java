import java.util.*;

public class Permutation {

    /**
     * <p> Arrangements of a fixed length k of elements taken from
     * a given set of size n, in other words, these k-permutations
     * of n are the different ordered arrangements of a k-element
     * subset of an n-set.
     * The number of such k-permutations of n is denoted by P(n,k)
     * and A_n^k.
     * <p> P(n, k) = n!/(n-k)!
     * @return k-permutations of n
     */
    public static long permutation(int n, int k){
        return fact(n) / fact(n - k);
    }

    private static long fact(int n){
        if(n <= 1) return 1;
        return n * fact(n - 1);
    }

    /**
     * Time complexity: O(n * n!), BETTER approximation:
     * O(n^2 * (e * Γ(n + 1, 1) - n!))
     * @return all possible permutations of an array.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        permuteHelper(nums, 0, new int[nums.length], result);
        return result;
    }

    private void permuteHelper(int[] nums, int num, int[] permutation, List<List<Integer>> result){
        if(num == nums.length){
            List<Integer> list = new ArrayList<>(num);
            for(int i = 0; i < num; i++){
                list.add(permutation[i]);
            }
            result.add(list);
            return;
        }

        for(int ele : nums){
            boolean flag = true;
            for(int i = 0; i < num; i++){
                if(permutation[i] == ele){
                    flag = false;
                    break;
                }
            }
            if(flag){
                permutation[num] = ele;
                permuteHelper(nums, num + 1, permutation, result);
            }
        }
    }
}
