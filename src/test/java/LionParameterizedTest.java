import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class LionParameterizedTest {

    @ParameterizedTest
    @CsvSource({
            "Самец,true",
            "Самка,false"
    })
    void lionManeCheck(String sex, boolean expectedHasMane) throws Exception {
        Feline mockFeline = mock(Feline.class);
        Lion lion = new Lion(sex, mockFeline);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "Мужик", "Женщина", "123"})
    void lionInvalidSexThrowsParam(String invalidSex) {
        Feline mockFeline = mock(Feline.class);
        Exception ex = assertThrows(Exception.class, () -> new Lion(invalidSex, mockFeline));
        assertTrue(ex.getMessage().contains("допустимые значения пола"));
    }
}