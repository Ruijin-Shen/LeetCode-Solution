package Solution.E;

public class ExcelSheetColumnTitle {
}

class Solution168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder builder = new StringBuilder();
        while(columnNumber != 0){
            int cur = columnNumber % 26;
            if(cur == 0) cur = 26;
            builder.append((char)(cur + 'A' - 1));
            columnNumber -= cur;
            columnNumber /= 26;
        }
        builder.reverse();
        return builder.toString();
    }
}