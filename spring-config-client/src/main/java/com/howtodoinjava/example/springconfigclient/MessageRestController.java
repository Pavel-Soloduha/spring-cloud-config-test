package com.howtodoinjava.example.springconfigclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MessageRestController {

	@Value("${message.service:Config Server is not working. Please check...}")
	private String msg;

    @Autowired
    private MessageService messageService;

    @GetMapping("/value")
    public String getMsgValue() {
        return msg;
    }

    @GetMapping("/msg")
    public String getMsg() {
        return messageService.getMessage();
    }
}
