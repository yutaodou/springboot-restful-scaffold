package com.example.todo.controller;

import com.example.todo.api.dto.ToDoDTO;
import com.example.todo.domain.model.ToDo;
import com.example.todo.domain.service.ToDoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ToDoControllerTest {

    @InjectMocks
    private ToDoController controller;

    @Mock
    private ToDoService toDoService;

    @Test
    void should_return_list_of_toDo() {
        ToDo todo = ToDo.builder().id(1L).title("test todo").build();
        List<ToDo> todoList = List.of(todo);
        when(toDoService.findAll()).thenReturn(todoList);

        List<ToDoDTO> todos = controller.getToDoList();
        assertThat(todos).hasSize(1);

        var actual = todos.get(0);
        assertThat(actual.id()).isEqualTo(todo.getId());
        assertThat(actual.title()).isEqualTo(todo.getTitle());
    }
}
