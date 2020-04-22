package ru.donskov.ses.controller;

import org.java_websocket.client.WebSocketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.donskov.ses.client.ExchangeClient;
import ru.donskov.ses.service.InfoService;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/info")
public class InfoController {

    private final InfoService infoService;

    @Autowired
    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping()
    public String findExchange() throws URISyntaxException {
        WebSocketClient client = new ExchangeClient(new URI("wss://api-pub.bitfinex.com/ws/2"));
        client.connect();
        return "All is good";
    }
}