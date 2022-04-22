package com.example.xsmittetryk05.mockito;

import com.example.xsmittetryk05.service.TodoBusinessImpl;
import com.example.xsmittetryk05.service.TodoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

//@RunWith(MockitoJUnitRunner.class)
public class VerifyMock {

    //@Mock
    //TodoService todoServiceMock; // = mock(TodoService.class);

    @Test
    void testDeleteTodos() {
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to dance");
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
        verify(todoServiceMock).deleteTodo("Learn to dance");
        verify(todoServiceMock, never()).deleteTodo("Learn Spring");
    }

    @Test
    void testDeleteTodosNotRelatedToSpringTimes1() {
        //Given
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to dance");
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        verify(todoServiceMock, times(1)).deleteTodo("Learn to dance");

    }

    @Test
    void test2DeleteTodosNotRelatedToSpringTimes1() {
        //Given
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to dance");
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        verify(todoServiceMock, atLeast(1)).deleteTodo("Learn to dance");

    }



}
