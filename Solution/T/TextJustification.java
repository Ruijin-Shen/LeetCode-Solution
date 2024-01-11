package Solution.T;

import java.util.*;

public class TextJustification {
}

class Solution68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        List<String> result = new LinkedList<>();

        int index = 0;
        while(index < n){
            ArrayList<String> curLine = new ArrayList<>();
            int count = words[index].length(), space = 0;
            curLine.add(words[index]);
            index++;

            while(index < n && count + 1 + words[index].length() <= maxWidth){
                curLine.add(words[index]);
                count += 1 + words[index].length();
                index++;
                space++;
            }

            space = maxWidth - count + space;

            if(curLine.size() == 1){
                result.add(curLine.get(0) + " ".repeat(space));
                continue;
            }


            int baseSpace = (index == n) ? 1 : space / (curLine.size() - 1);
            int remainning = (index == n) ? 0 : space % (curLine.size() - 1);


            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < curLine.size() - 1; i++){
                builder.append(curLine.get(i));
                builder.append(" ".repeat(baseSpace));
                if(remainning > 0){
                    builder.append(' ');
                    remainning--;
                }
            }
            builder.append(curLine.get(curLine.size() - 1));
            if(index == n) builder.append(" ".repeat(space - curLine.size() + 1));
            result.add(builder.toString());
        }
        return result;
    }
}