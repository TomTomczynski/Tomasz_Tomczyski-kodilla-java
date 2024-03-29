package com.crud.tasks.com.crud.tasks.trello;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class TrelloConfig {
    @Value("${trello.api.endpoint.prod}")
    private String trelloApiEndpoint;

    @Value("${trello.app.token}")
    private String trelloToken;

    @Value("${trello.app.key}")
    private String trelloAppKey;

    @Value("${trello.apo.user.id}")
    private String trelloUserId;
}
