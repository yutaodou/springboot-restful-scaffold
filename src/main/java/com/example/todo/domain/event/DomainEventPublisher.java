package com.example.todo.domain.event;

import com.google.common.eventbus.EventBus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DomainEventPublisher {
    private final EventBus eventBus;

    public void publish(DomainEvent event) {
        this.eventBus.post(event);
    }
}
