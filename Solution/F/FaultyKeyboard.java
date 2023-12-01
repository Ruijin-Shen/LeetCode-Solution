package Solution.F;

public class FaultyKeyboard {
}

class Solution2801 {
    public String finalString(String s) {
        StringBuilder builder = new StringBuilder();
        for(char c : s.toCharArray()){
            switch (c){
                case 'i':
                    builder.reverse();
                    break;
                default:
                    builder.append(c);
            }
        }
        return builder.toString();
    }
}
