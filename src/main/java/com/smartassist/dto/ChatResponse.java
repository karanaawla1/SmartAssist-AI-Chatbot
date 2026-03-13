package com.smartassist.dto;

import lombok.Data;

@Data
public class ChatResponse {
    private String sessionId;
    private String reply;
    private String timestamp;
}