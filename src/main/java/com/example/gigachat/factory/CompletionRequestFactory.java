package com.example.gigachat.factory;

import chat.giga.model.ModelName;
import chat.giga.model.completion.ChatMessage;
import chat.giga.model.completion.ChatMessageRole;
import chat.giga.model.completion.CompletionRequest;
import org.springframework.stereotype.Component;

@Component
public class CompletionRequestFactory {

    public CompletionRequest create(String content) {
        return CompletionRequest.builder()
                .model(ModelName.GIGA_CHAT_MAX)
                .message(ChatMessage.builder()
                        .content(content)
                        .role(ChatMessageRole.USER)
                        .build())
                .build();
    }


}
