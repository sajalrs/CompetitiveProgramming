package LeetCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseScheduleTest {

    CourseSchedule courseSchedule;

    @BeforeEach
    public void setup() {
        courseSchedule = new CourseSchedule();
    }

    @Test
    @DisplayName("Input: numCourses = 2, prerequisites = [[1,0]]\n" +
            "Output: true\n" +
            "Explanation: There are a total of 2 courses to take. \n" +
            "To take course 1 you should have finished course 0. So it is possible.")
    public void test1() {
        assertTrue(courseSchedule.canFinish(2, new int[][]{new int[]{1, 0}}));
    }

    @Test
    @DisplayName("Input: numCourses = 2, prerequisites = [[1,0],[0,1]]\n" +
            "Output: false\n" +
            "Explanation: There are a total of 2 courses to take. \n" +
            "To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.")
    public void test2() {
        assertFalse(courseSchedule.canFinish(2, new int[][]{new int[]{1, 0}, new int[]{0, 1}}));
    }

}
