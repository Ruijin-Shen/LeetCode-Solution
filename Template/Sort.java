package Template;

/**
 * Sorting Algorithm    Time Complexity
 * Insertion Sort       worst: O(n^2)
 *                      best: O(n)
 *                      average: O(n^2)
 * Selection Sort       worst: O(n^2)
 *                      best: O(n^2)
 *                      average: O(n^2)
 * Quick Sort           worst: O(n^2)
 *                      best: O(nlogn)
 *                      average: O(nlogn)
 * Merge Sort           worst: O(nlogn)
 *                      best: O(nlogn)
 *                      average: O(nlogn)
 */
public class Sort {
    private static int[] temp = new int[10000];

    public static void quickSort(int[] array){
        quickSort(array, 0, array.length - 1);
    }

    /**
     * <p> Time complexity: average O(NlogN), best O(NlogN), worst O(N^2).
     * <p> Quicksort is not stable, meaning that the relative order
     * of equal sort items is not preserved.
     */
    public static void quickSort(int[] array, int left, int right){
        if(left >= right) return;

        // pivot CAN NOT be array[right].
        int i = left - 1, j = right + 1, pivot = array[(left + right) >> 1];

        // Partitioning
        while(true){
            // Do not use <= or >= to avoid performance problem when the array consists of identical elements.
            do i++; while(array[i] < pivot);
            do j--; while(array[j] > pivot);
            // Swap
            if(i < j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }else{
                break;
            }
        }

        // Divide and Conquer.
        quickSort(array, left, j);
        quickSort(array, j + 1, right);
    }

    public static void mergeSort(int[] array){
        mergeSort(array, 0, array.length - 1);
    }

    /**
     * <p> Time Complexity: O(NlogN).
     * <p> Space Complexity: O(N).
     * <p> Mergesort is stable, meaning that the relative order of
     * equal sort items is preserved. Mergesort requires additional
     * memory equal to the original array.
     */
    public static void mergeSort(int[] array, int left, int right){
        if(left >= right) return;

        int mid = left + right >> 1;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);

        int total = left, i = left, j = mid + 1;
        while(i <= mid && j <= right){
            // <= make the algorithm stable.
            if(array[i] <= array[j]) temp[total++] = array[i++];
            else temp[total++] = array[j++];
        }
        while(i <= mid) temp[total++] = array[i++];
        while(j <= right) temp[total++] = array[j++];

        for(i = left; i <= right; i++){
            array[i] = temp[i];
        }
    }
}