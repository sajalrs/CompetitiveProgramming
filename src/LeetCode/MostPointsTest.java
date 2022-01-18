package LeetCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MostPointsTest {
    MostPoints mostPoints;
    @BeforeEach
    public void setup(){
        mostPoints = new MostPoints();
    }

    @Test
    @DisplayName("Input: questions = [[3,2],[4,3],[4,4],[2,5]]\n" +
            "Output: 5\n" +
            "Explanation: The maximum points can be earned by solving questions 0 and 3.\n" +
            "- Solve question 0: Earn 3 points, will be unable to solve the next 2 questions\n" +
            "- Unable to solve questions 1 and 2\n" +
            "- Solve question 3: Earn 2 points\n" +
            "Total points earned: 3 + 2 = 5. There is no other way to earn 5 or more points.")
    public void test1(){
        assertEquals(5, mostPoints.mostPoints(new int[][]{new int[]{3,2},new int[]{4,3},new int[]{4,4},new int[]{2,5}}));
    }

    @Test
    @DisplayName("Input: questions = [[1,1],[2,2],[3,3],[4,4],[5,5]]\n" +
            "Output: 7\n" +
            "Explanation: The maximum points can be earned by solving questions 1 and 4.\n" +
            "- Skip question 0\n" +
            "- Solve question 1: Earn 2 points, will be unable to solve the next 2 questions\n" +
            "- Unable to solve questions 2 and 3\n" +
            "- Solve question 4: Earn 5 points\n" +
            "Total points earned: 2 + 5 = 7. There is no other way to earn 7 or more points.")
    public void test2(){
        assertEquals(7,mostPoints.mostPoints(new int[][]{new int[]{1,1},new int[]{2,2},new int[]{3,3},new int[]{4,4},new int[]{5,5}}));
    }

}
