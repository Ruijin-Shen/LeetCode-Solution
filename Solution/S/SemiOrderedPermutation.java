package Solution.S;

public class SemiOrderedPermutation {
}

class Solution2717{
    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length;
        int index1 = 0, indexn = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == 1){
                index1 = i;
            }
            if(nums[i] == n){
                indexn = i;
            }
        }

        if(index1 < indexn){
            return index1 + n - indexn - 1;
        }else{
            return index1 + n - indexn - 2;
        }
    }
}
