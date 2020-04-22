package ru.donskov.ses.client;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

import javax.websocket.ClientEndpoint;
import java.net.URI;
import java.nio.ByteBuffer;

@ClientEndpoint
public class ExchangeClient extends WebSocketClient  {

    public ExchangeClient(URI serverUri, Draft draft) {
        super(serverUri, draft);
    }

    public ExchangeClient(URI serverURI) {
        super(serverURI);
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        send("{\n" +
                "   \"event\": \"subscribe\",\n" +
                "   \"channel\": \"candles\",\n" +
                "   \"key\": \"trade:1m:tBTCUSD\"\n" +
                "}");
        System.out.println("new connection opened");
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("closed with exit code " + code + " additional info: " + reason);
    }

    @Override
    public void onMessage(String message) {
        System.out.println("received message: " + message);
    }

    @Override
    public void onMessage(ByteBuffer message) {
        System.out.println("received ByteBuffer");
    }

    @Override
    public void onError(Exception ex) {
        System.err.println("an error occurred:" + ex);
    }

}

