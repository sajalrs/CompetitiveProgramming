package LeetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseScheduleIVTest {
    private CourseScheduleIV courseScheduleIV;

    @BeforeEach
    public void setup() {
        courseScheduleIV = new CourseScheduleIV();
    }

    @Test
    @DisplayName("Input: numCourses = 2, prerequisites = [], queries = [[1,0],[0,1]]\n" +
            "Output: [false,false]")
    public void test1() {
        List<Boolean> ans = courseScheduleIV.checkIfPrerequisite(2, new int[][]{}, new int[][]{new int[]{1, 0}, new int[]{0, 1}});
        assertTrue(!ans.get(0));
        assertTrue(!ans.get(1));
    }


    @Test
    @DisplayName("Input: numCourses = 3, prerequisites = [[1,2],[1,0],[2,0]], queries = [[1,0],[1,2]]\n" +
            "Output: [true,true]")
    public void test2() {
        List<Boolean> ans = courseScheduleIV.checkIfPrerequisite(3, new int[][]{new int[]{1,2},new int[]{1,0},new int[]{2,0}}, new int[][]{new int[]{1, 0}, new int[]{1, 2}});
        assertTrue(ans.get(0));
        assertTrue(ans.get(1));
    }

    @Test
    @DisplayName("Input: numCourses = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]\n" +
            "Output: [false,true]")
    public void test3() {
        List<Boolean> ans = courseScheduleIV.checkIfPrerequisite(2, new int[][]{new int[]{1,0}}, new int[][]{new int[]{0, 1}, new int[]{1, 0}});
        assertTrue(!ans.get(0));
        assertTrue(ans.get(1));
    }
}
