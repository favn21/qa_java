import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;


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



}

