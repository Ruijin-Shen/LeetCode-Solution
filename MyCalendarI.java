import java.util.*;
public class MyCalendarI {
}

class MyCalendar {
    private TreeMap<Integer, Integer> calendar;

    public MyCalendar() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        var entry = calendar.lowerEntry(end);
        if(entry != null && entry.getValue() > start){
            return false;
        }else{
            calendar.put(start, end);
            return true;
        }
    }
}