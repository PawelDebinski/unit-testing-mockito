package pl.pawel.unittesting.business;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListMockTest {

    List mock = mock(List.class);

    @Test
    public void size_basic() {
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    public void returnDifferentValues() {
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void returnWithParameters() {
        when(mock.get(0)).thenReturn("hello");
        assertEquals("hello", mock.get(0));
    }

    @Test
    public void returnWithGenericParameters() {
        when(mock.get(anyInt())).thenReturn("hello");
        assertEquals("hello", mock.get(0));
        assertEquals("hello", mock.get(1));
    }
}
