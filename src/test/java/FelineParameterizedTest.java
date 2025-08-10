import com.example.Feline;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineParameterizedTest {
    Feline feline = new Feline();

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 5, 10})
    void getKittensReturnsSameValue(int input) {
        assertEquals(input, feline.getKittens(input));
    }
}
