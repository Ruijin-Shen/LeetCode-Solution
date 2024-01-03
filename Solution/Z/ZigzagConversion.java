package Solution.Z;

public class ZigzagConversion {
}

class Solution6 {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;

        StringBuilder result = new StringBuilder();
        int n = s.length();
        int period = 2 * numRows - 2;

        for(int row = 0; row < numRows; row++){
            int index = row;
            while(index < n){
                result.append(s.charAt(index));
                if(row != 0 && row != numRows - 1){
                    int nextIndex = index + period - 2 * row;
                    if(nextIndex < n) result.append(s.charAt(nextIndex));
                }
                index += period;
            }
        }
        return result.toString();
    }
}