package com.howtodoinjava.example.springconfigclient;

import lombok.experimental.Delegate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class MessageDelegate implements MessageService {

    @Delegate // lombok delegate (for the sake of brevity)
    private final MessageService delegate;

    public MessageDelegate(
            // just inject value from Spring configuration
            @Value("${message.service}") String country
    ) {
        MessageDelegate impl = null;
        switch (country) {
            case "prod":
                this.delegate = new ProdMessageServiceImpl();
                break;
            default:
                this.delegate = new DevMessageServiceImpl();
                break;
        }
    }
}