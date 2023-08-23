public class KthSmallestElementInASortedMatrix {
}

class Solution378 {
    public int kthSmallest(int[][] matrix, int k) {
        int left = -1000000000, right = 1000000000;
        while(left < right){
            int mid = left + right >> 1;
            if(count(matrix, mid) < k){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    public int count(int[][] matrix, int target){
        int n = matrix.length;
        int count = 0;

        for(int i = 0, j = n - 1; i < n; i++){
            while(j >= 0 && matrix[i][j] > target) j--;
            count += j + 1;
        }
        return count;
    }
}
