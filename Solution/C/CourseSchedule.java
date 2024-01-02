package Solution.C;

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

class Solution207DFS {
    private static final int VISITING = -1;
    private static final int VISITED = 1;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<List<Integer>> prereq = new ArrayList<>(numCourses);
        for(int i = 0; i < numCourses; i++){
            prereq.add(new ArrayList<>());
        }
        for(int[] pair : prerequisites){
            prereq.get(pair[0]).add(pair[1]);
        }

        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(!take(i, prereq, visited)) return false;
        }
        return true;
    }

    private boolean take(int course, ArrayList<List<Integer>> prereq, int[] visited){
        if(visited[course] == VISITED) return true;
        if(visited[course] == VISITING) return false;

        visited[course] = VISITING;
        for(int prev : prereq.get(course)){
            if(!take(prev, prereq, visited)) return false;
        }
        visited[course] = VISITED;
        return true;
    }
}