import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.stream.Stream;

import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class CatParameterizedTest {

    static Stream<Feline> felineProvider() {
        Feline mockFeline = mock(Feline.class);
        return Stream.of(null, mockFeline);
    }

    @ParameterizedTest
    @MethodSource("felineProvider")
    void constructorShouldSetPredatorField(Feline feline) throws Exception {
        Cat cat = new Cat(feline);
        java.lang.reflect.Field predatorField = Cat.class.getDeclaredField("predator");
        predatorField.setAccessible(true);
        Object predatorValue = predatorField.get(cat);

        assertEquals(feline, predatorValue);
    }
}

