package Solution.P;

public class PeakIndexInAMountainArray {
}

class Solution852BinarySearch {
    public int peakIndexInMountainArray(int[] arr) {
        // Binary Search
        int left = 1, right = arr.length - 2;
        while(left < right){
            int mid = (left + right + 1) >> 1;
            if(arr[mid - 1] < arr[mid]) left = mid;
            else right = mid - 1;
        }
        return left;
    }
}