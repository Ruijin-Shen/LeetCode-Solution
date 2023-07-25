public class FindTheIndexOfTheFirstOccurrenceInAString {
}

class Solution28KMP {
    public int strStr(String haystack, String needle) {
        var result = KMP.kmp(haystack, needle);
        if(result.size() == 0){
            return -1;
        }else{
            return result.get(0);
        }
    }
}
