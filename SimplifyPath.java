import java.util.*;

public class SimplifyPath {
}

class Solution71 {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Deque<String> stack = new LinkedList<>();
        for(String dir : dirs){
            switch(dir){
                case "": break;
                case ".": break;
                case "..": stack.pollLast(); break;
                default: stack.addLast(dir);
            }
        }

        if(stack.size() == 0) return "/";
        StringBuilder builder = new StringBuilder();
        for(String dir : stack){
            builder.append('/');
            builder.append(dir);
        }
        return builder.toString();
    }
}