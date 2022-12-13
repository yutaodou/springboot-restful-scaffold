package com.example.todo.domain.event;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class InterestedThirdParty {

    @Autowired
    public InterestedThirdParty(EventBus eventBus) {
        eventBus.register(this);
    }

    @Subscribe
    public void handleDomainEvent(ToDoCreatedEvent event) {
        log.info("handling event: {}", event);
    }
}
