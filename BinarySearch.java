import java.io.BufferedReader;
import java.util.function.Predicate;

public class BinarySearch {
    public static boolean check(int i){
        return true;
    }

    // Find the minimum element.
    public static int binarySearchRight(int left, int right){
        while(left < right){
            int mid = left + right >> 1;
            if(check(mid)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    // Find the maximum element.
    public static int binarySearchLeft(int left, int right){
        while(left < right){
            int mid = left + right + 1 >> 1;
            if(check(mid)) left = mid;
            else right = mid - 1;
        }
        return left;
    }
}
