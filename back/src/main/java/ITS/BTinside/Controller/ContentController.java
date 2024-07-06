package ITS.BTinside.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ContentController {

    @Value("${openai.api.key}")
    private String openaiApiKey;

    @PostMapping("/generateContent")
    public ResponseEntity<Map<String, String>> generateContent(@RequestBody Map<String, String> request) {
        String topic = request.get("topic");

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(openaiApiKey);

        String openAiUrl = "https://api.openai.com/v1/engines/davinci-codex/completions";
        String requestBody = "{\"prompt\":\"Generate a blog post outline about " + topic + "\",\"max_tokens\":150}";

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
        String openAiResponse = restTemplate.exchange(openAiUrl, HttpMethod.POST, entity, String.class).getBody();

        // 적절히 JSON 파싱하여 필요한 데이터 추출
        String generatedContent = extractContentFromResponse(openAiResponse);

        return ResponseEntity.ok(Map.of("content", generatedContent));
    }

    private String extractContentFromResponse(String response) {
        // 응답에서 필요한 데이터를 추출하는 로직 구현
        // 예: JSON 파싱하여 choices[0].text 값 추출
        return "Extracted content from response"; // 예시
    }
}
