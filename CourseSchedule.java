import java.util.*;

public class CourseSchedule {
}

class Solution207TopologicalSort {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];

        HashMap<Integer, List<Integer>> courses = new HashMap<>();
        for(int[] pair : prerequisites){
            degree[pair[0]]++;
            courses.computeIfAbsent(pair[1], x -> new LinkedList<>()).add(pair[0]);
        }

        Deque<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(degree[i] == 0) queue.addLast(i);
        }

        int count = 0;
        while(!queue.isEmpty()){
            int course = queue.removeFirst();
            for(Integer nextCourse : courses.getOrDefault(course, new ArrayList<>())){
                degree[nextCourse]--;
                if(degree[nextCourse] == 0){
                    queue.addLast(nextCourse);
                }
            }
            count++;
        }

        return count == numCourses;
    }
}