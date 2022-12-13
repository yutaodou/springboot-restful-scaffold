package com.example.todo.infrastructure;

import com.example.todo.domain.model.ToDo;
import com.example.todo.domain.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ToDoRepositoryImpl implements ToDoRepository {
    private final ToDoJpaRepository jpaRepository;
    private static final ToDoDOMapper MAPPER = ToDoDOMapper.MAPPER;

    @Override
    public Optional<ToDo> getById(Long uuid) {
        return jpaRepository.findById(uuid).map(MAPPER::toModel);
    }

    @Override
    public ToDo save(ToDo toSave) {
        var toDoDO = MAPPER.toDo(toSave);
        return MAPPER.toModel(jpaRepository.save(toDoDO));
    }

    @Override
    public List<ToDo> findAll() {
        return jpaRepository.findAll().stream().map(MAPPER::toModel).toList();
    }
}
