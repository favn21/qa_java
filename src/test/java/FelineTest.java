import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class FelineTest {

    @Test
    void eatMeatAndFamilyTest() throws Exception {
        Feline feline = new Feline();

        assertEquals("Кошачьи", feline.getFamily());
        assertNotNull(feline.eatMeat());
    }

    @Test
    void getKittensWithoutParamShouldReturnOne() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }


}

