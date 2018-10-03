package pl.pawel.unittesting.partone.business;

import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List<String> mock = mock(List.class);

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

    @Test
    public void verificationBasics() {
        String value1 = mock.get(0);
        String value2 = mock.get(1);

        verify(mock).get(0); // verify that get() was called with argument '0'
        verify(mock, times(2)).get(anyInt()); // verify that get() was called with any argument two times
        verify(mock, atLeastOnce()).get(anyInt()); // verify that get() was called at least once
        verify(mock, atMost(2)).get(anyInt()); // verify that get() was called at most once
        verify(mock, never()).get(2); // verify that get() with argument '2' was never called
    }

    @Test
    public void argumentCapturing() {
        mock.add("SomeString");

        // capturing parameter passed into 'add' method
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("SomeString", captor.getValue());
    }

    @Test
    public void multipleArgumentCapturing() {
        mock.add("SomeString1");
        mock.add("SomeString2");

        // capturing parameter passed into 'add' method
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());

        List<String> allValues = captor.getAllValues();
        assertEquals("SomeString1", allValues.get(0));
        assertEquals("SomeString2", allValues.get(1));
    }

    @Test
    public void mocking() {
        ArrayList arrayListMock = mock(ArrayList.class);
        System.out.println(arrayListMock.get(0)); // null
        System.out.println(arrayListMock.size()); // 0
        arrayListMock.add("test");
        arrayListMock.add("test2");
        System.out.println(arrayListMock.size()); // 0
        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size()); // 5
    }

    @Test
    public void spyin() {
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("test0");
        System.out.println(arrayListSpy.get(0)); // test0
        System.out.println(arrayListSpy.size()); // 1
        arrayListSpy.add("test");
        arrayListSpy.add("test2");
        System.out.println(arrayListSpy.size()); // 3
        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size()); // 5
        arrayListSpy.add("test4");
        System.out.println(arrayListSpy.size()); // 5
        verify(arrayListSpy).add("test4");
    }

}
