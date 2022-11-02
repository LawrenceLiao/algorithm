package week3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> to = new ArrayList<>(numCourses);
        int[] degrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++) to.add(new LinkedList<>());

        for (int[] prerequisite : prerequisites) {
            int x = prerequisite[0];
            int y = prerequisite[1];
            to.get(y).add(x);
            degrees[x]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        int[] lessons = new int[numCourses];
        int index = 0;

        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0) queue.offer(i);
        }


        while (!queue.isEmpty()) {
            int course = queue.poll();
            lessons[index++] = course;
            for (int x : to.get(course)) {
                degrees[x]--;

                if (degrees[x] == 0) queue.offer(x);
            }
        }
        return index == numCourses ? lessons : new int[]{};
    }
}
