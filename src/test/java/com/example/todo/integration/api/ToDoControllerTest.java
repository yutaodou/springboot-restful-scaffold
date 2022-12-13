package com.example.todo.integration.api;

import com.example.todo.api.dto.CreateToDoDTO;
import com.example.todo.integration.BaseIntegrationTest;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ToDoControllerTest extends BaseIntegrationTest {

    @Test
    @Sql(scripts = "/db/insert-todos.sql")
    @SneakyThrows
    void should_get_todos() {
        perform(get("/todos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$.[0].title").value("this is my todo"));
    }

    @SneakyThrows
    @Test
    void should_create_todo() {
        CreateToDoDTO createToDoDTO = CreateToDoDTO.builder().title("my-todo").build();
        perform(post("/todos"), createToDoDTO)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("my-todo"));
    }
}
