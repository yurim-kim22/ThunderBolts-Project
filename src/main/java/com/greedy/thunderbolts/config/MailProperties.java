package com.greedy.thunderbolts.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@EnableConfigurationProperties
public class MailProperties {

    // SMTP 서버
    private String host;

    // 계정
    private String username;

    // 비밀번호
    private String password;

    // 포트번호
    private int port;

    // 메일연결자
    private String supplier;

    // 발신자 메일
    private String fromMail;

    // tls 설정
    private String socketFactoryClass;
}