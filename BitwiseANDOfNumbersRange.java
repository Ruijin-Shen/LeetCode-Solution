public class BitwiseANDOfNumbersRange {
}

class Solution201 {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while(left < right){
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift;
    }
}