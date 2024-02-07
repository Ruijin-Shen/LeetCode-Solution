package Solution.L;

import java.util.*;

public class LongestAbsoluteFilePath {
}

class Solution388 {
    public int lengthLongestPath(String input) {
        String[] strs = input.split("\\n");
        Deque<String> path = new ArrayDeque<>();
        int length = 0;
        int result = 0;
        for(String str : strs){
            int depth = level(str);
            while(path.size() > depth){
                length -= path.removeLast().length();
            }
            path.addLast(str);
            length += str.length();
            if(str.indexOf('.') != -1){
                int curLength = length + path.size() - 1 - (path.size() - 1) * path.size() / 2;
                result = Math.max(result, curLength);
            }
        }
        return result;
    }

    private int level(String str){
        int count = 0;
        while(count < str.length() && str.charAt(count) == '\t') count++;
        return count;
    }
}