package com.example.todo.infrastructure;

import com.example.todo.domain.model.ToDo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ToDoDOMapper {
    ToDoDOMapper MAPPER = Mappers.getMapper(ToDoDOMapper.class);

    ToDo toModel(ToDoDO doDO);

    ToDoDO toDo(ToDo toDo);
}
