package CrackingTheCodingInterview;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IsUniqueTest {

    private IsUnique isUnique;

    @BeforeEach
    public void setUp() throws Exception {
        isUnique = new IsUnique();
    }

    @Test
    @DisplayName("Test Empty String")
    public void testEmpty(){
        assertEquals(true, isUnique.isUnique(""), "Empty String should be unique");
    }

    @Test
    @DisplayName("Test Empty String Inplace")
    public void testEmptyInplace(){
        assertEquals(true, isUnique.isUniqueInPlace(""), "Empty String should be unique");
    }

    @Test
    @DisplayName("Test Space")
    public void testSpace(){
        assertEquals(true, isUnique.isUnique(" "), "Just space should be unique");
    }

    @Test
    @DisplayName("Test Space Inplace")
    public void testSpaceInplace(){
        assertEquals(true, isUnique.isUniqueInPlace( " "), "Just space should be unique");
    }



    @Test
    @DisplayName("Test Mix Case")
    public void testMixCase(){
        assertEquals(false, isUnique.isUnique("Aa"), "Different cases but same character; should be false");
    }

    @Test
    @DisplayName("Test Mix Case Inplace")
    public void testMixCaseInplace(){
        assertEquals(false, isUnique.isUniqueInPlace( "Aa"), "Different cases but same character; should be false");
    }


}
