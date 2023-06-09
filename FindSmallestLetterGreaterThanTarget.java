public class FindSmallestLetterGreaterThanTarget {
}

class Solution744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int left = 0, right = n - 1;
        int mid;

        while(left <= right){
            if(letters[left] > target) return letters[left];
            if(letters[right] <= target) return letters[0];

            mid = left + ((right - left) >> 1);
            if(letters[mid] > target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return letters[0];
    }
}