import Template.KMP;

public class FindTheIndexOfTheFirstOccurrenceInAString {
}

class Solution28KMP {
    public int strStr(String haystack, String needle) {
        return KMP.kmp(haystack, needle).stream().findFirst().orElse(-1);
    }
}
