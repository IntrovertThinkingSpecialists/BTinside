package ITS.BTinside.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ContentController {

    @PostMapping("/generateContent")
    public ResponseEntity<Map<String,String>> generateContent(@RequestBody Map<String, String> request){
        String topic =request.get("topic");
        String generatedContent = "The latest trends in AI include advancements in deep learning, reinforcement learning, and more.";

        return ResponseEntity.ok(Map.of("content",generatedContent));
    }
}
