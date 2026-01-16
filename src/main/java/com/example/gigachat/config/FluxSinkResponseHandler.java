package com.example.gigachat.config;

import chat.giga.client.ResponseHandler;
import chat.giga.model.completion.CompletionChunkResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.codec.ServerSentEvent;
import reactor.core.publisher.FluxSink;

@RequiredArgsConstructor
public class FluxSinkResponseHandler implements ResponseHandler<CompletionChunkResponse> {

    private final FluxSink<ServerSentEvent<CompletionChunkResponse>> sink;

    @Override
    public void onNext(CompletionChunkResponse chunk) {
        sink.next(createServerSentEvent(chunk));
    }

    @Override
    public void onComplete() {
        sink.complete();
    }

    @Override
    public void onError(Throwable th) {
        sink.error(th);
    }

    private ServerSentEvent<CompletionChunkResponse> createServerSentEvent(CompletionChunkResponse chunk) {
        return ServerSentEvent.builder(chunk).build();
    }
}