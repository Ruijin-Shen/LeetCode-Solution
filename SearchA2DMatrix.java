public class SearchA2DMatrix {
}

class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        int left = 0, right = m * n - 1;
        while(left < right){
            int mid = (left + right + 1) >> 1;
            if(matrix[mid / n][mid % n] <= target){
                left = mid;
            }else{
                right = mid - 1;
            }
        }
        return matrix[left / n][left % n] == target;
    }
}