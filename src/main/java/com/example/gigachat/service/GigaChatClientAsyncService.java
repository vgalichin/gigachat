package com.example.gigachat.service;

import chat.giga.client.GigaChatClientAsync;
import chat.giga.model.completion.CompletionChunkResponse;
import com.example.gigachat.config.FluxSinkResponseHandler;
import com.example.gigachat.factory.CompletionRequestFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class GigaChatClientAsyncService {

    private final GigaChatClientAsync gigaChatClientAsync;
    private final CompletionRequestFactory completionRequestFactory;

//    public SseEmitter completions(String content) {
//        CompletionRequest completionRequest = completionRequestFactory.create(content);
//        SseEmitterResponseHandler responseHandler = new SseEmitterResponseHandler();
//        gigaChatClientAsync.completions(completionRequest, responseHandler);
//        return responseHandler.getEmitter();
//    }

    public Flux<ServerSentEvent<CompletionChunkResponse>> webFluxCompletions(String content) {
        return Flux.create(sink -> {
            gigaChatClientAsync.completions(completionRequestFactory.create(content), new FluxSinkResponseHandler(sink));
        });
    }
}
