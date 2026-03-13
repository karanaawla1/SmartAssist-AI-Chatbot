package com.smartassist.service;

import com.smartassist.dto.ChatRequest;
import com.smartassist.dto.ChatResponse;
import com.smartassist.model.ChatMessage;
import com.smartassist.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class ChatService {

    private final ChatRepository chatRepository;
    private final RestTemplate restTemplate;

  @Value("${GROQ_API_KEY}")
private String groqApiKey;

@Value("${GROQ_API_URL}")
private String groqApiUrl;

    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
        this.restTemplate = new RestTemplate();
    }

    public ChatResponse chat(ChatRequest request) {
        String botReply = callGroqApi(request.getMessage());

        ChatMessage msg = new ChatMessage();
        msg.setSessionId(request.getSessionId());
        msg.setUserMessage(request.getMessage());
        msg.setBotResponse(botReply);
        chatRepository.save(msg);

        ChatResponse response = new ChatResponse();
        response.setSessionId(request.getSessionId());
        response.setReply(botReply);
        response.setTimestamp(LocalDateTime.now().toString());
        return response;
    }

    public List<ChatMessage> getHistory(String sessionId) {
        return chatRepository.findBySessionIdOrderByTimestampAsc(sessionId);
    }

    private String callGroqApi(String userMessage) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(groqApiKey);

        Map<String, Object> body = Map.of(
            "model", "llama-3.3-70b-versatile",
            "messages", List.of(
                Map.of("role", "user", "content", userMessage)
            )
        );

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

        try {
            ResponseEntity<Map> response = restTemplate.postForEntity(groqApiUrl, entity, Map.class);
            var choices = (List<Map>) response.getBody().get("choices");
            var message = (Map) choices.get(0).get("message");
            return (String) message.get("content");
        } catch (Exception e) {
            System.out.println("GROQ ERROR: " + e.getMessage());
            return "Sorry, I could not process your request right now.";
        }
    }
}