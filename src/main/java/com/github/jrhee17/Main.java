package com.github.jrhee17;

import com.linecorp.armeria.client.WebClient;
import com.linecorp.armeria.common.AggregatedHttpResponse;
import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.common.SessionProtocol;
import com.linecorp.armeria.server.Server;

public final class Main {

    public static void main(String[] args) {

        Server server = Server.builder()
                              .service("/", (ctx, req) -> HttpResponse.of(200))
                              .port(0, SessionProtocol.HTTP)
                              .build();
        server.start().join();
        AggregatedHttpResponse res = WebClient.of("http://127.0.0.1:" + server.activeLocalPort()).blocking().get("/");
        System.out.println(res);
        server.stop().join();
    }
}