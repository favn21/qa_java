import com.example.Feline;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class FelineTest {

    @Test
    void FamilyTest() {
        Feline feline = new Feline();

        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void getKittensWithoutParamShouldReturnOne() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }
    @Test
    void eatMeat() throws Exception {
        Feline feline = new Feline();
        assertNotNull(feline.eatMeat());
    }



}

