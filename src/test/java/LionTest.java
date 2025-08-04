import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LionTest {

    @Test
    void lionConstructorShouldThrowForInvalidSex() {
        Feline mockFeline = mock(Feline.class);
        Exception exception = assertThrows(Exception.class, () -> new Lion("abc", mockFeline));
        assertTrue(exception.getMessage().contains("допустимые значения пола"));
    }

    @Test
    void lionShouldDelegateKittensAndFood() throws Exception {
        Feline mockFeline = mock(Feline.class);
        when(mockFeline.getKittens()).thenReturn(2);
        when(mockFeline.getFood("Хищник")).thenReturn(List.of("Мясо"));

        Lion lion = new Lion("Самец", mockFeline);

        assertEquals(2, lion.getKittens());
        assertEquals(List.of("Мясо"), lion.getFood());

        verify(mockFeline).getKittens();
        verify(mockFeline).getFood("Хищник");
    }
    @Test
    void lionConstructorShouldSetFeline() throws Exception {
        Feline mockFeline = mock(Feline.class);
        Lion lion = new Lion("Самец", mockFeline);
        assertNotNull(lion);
        assertEquals(mockFeline, lion.feline);
    }

}
