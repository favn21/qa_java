import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CatTest {

    @Test
    void getSoundShouldReturnMeow() {
        Feline mockFeline = mock(Feline.class);
        Cat cat = new Cat(mockFeline);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void getFoodShouldReturnPredatorFoodFromInjectedFeline() throws Exception {
        Feline mockFeline = mock(Feline.class);
        List<String> mockFood = Arrays.asList("Мясо", "Птица");
        when(mockFeline.eatMeat()).thenReturn(mockFood);

        Cat cat = new Cat(mockFeline);
        assertEquals(mockFood, cat.getFood());
        verify(mockFeline).eatMeat();
    }

    @Test
    void getFoodFromFeline() throws Exception {
        Feline mockFeline = mock(Feline.class);
        when(mockFeline.eatMeat()).thenReturn(List.of("Мыши", "Птицы"));

        Cat cat = new Cat(mockFeline);
        assertEquals(List.of("Мыши", "Птицы"), cat.getFood());
        verify(mockFeline).eatMeat();
    }

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

