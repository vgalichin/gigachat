package com.example.gigachat.config;

import chat.giga.client.GigaChatClientAsync;
import chat.giga.client.auth.AuthClient;
import chat.giga.client.auth.AuthClientBuilder;
import chat.giga.model.Scope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GigaChatClientAsyncConfig {

    private static final String AUTH_KEY = "MDE5YTM1MmEtYjkzMi03MjZkLTkzNjYtN2Y3YjAyNTJjYjIzOjFjMjc3ZTFiLWZlYTQtNDUzOS04NDk5LTlhOThlY2U3Yjg5Mg==";

    @Bean
    public GigaChatClientAsync gigaChatClientAsync() {
        return GigaChatClientAsync.builder()
                .verifySslCerts(false)
                .authClient(AuthClient.builder()
                        .withOAuth(AuthClientBuilder.OAuthBuilder.builder()
                                .scope(Scope.GIGACHAT_API_PERS)
                                .authKey(AUTH_KEY)
                                .build())
                        .build())
                .build();
    }
}
