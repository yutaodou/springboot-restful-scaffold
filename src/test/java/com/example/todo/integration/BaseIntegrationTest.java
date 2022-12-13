package com.example.todo.integration;

import com.example.StartApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {StartApplication.class})
@AutoConfigureMockMvc
@Transactional
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = NONE)
@ExtendWith({SpringExtension.class, MariaDB4jExtension.class})
public class BaseIntegrationTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper mapper;

    @SneakyThrows
    protected String json(Object content) {
        return mapper.writeValueAsString(content);
    }

    @SneakyThrows
    protected ResultActions perform(MockHttpServletRequestBuilder requestBuilder) {
        return mockMvc.perform(requestBuilder);
    }

    @SneakyThrows
    protected ResultActions perform(MockHttpServletRequestBuilder requestBuilder, Object payload) {
        requestBuilder.contentType(APPLICATION_JSON_VALUE).content(json(payload));
        return mockMvc.perform(requestBuilder);
    }
}
