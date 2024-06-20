package com.example.sl.controller;

import com.example.sl.domain.service.StoryService;

import com.example.sl.entity.StoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/fan")
public class FanController {

    @Autowired
    private StoryService storyService;

    @GetMapping("/fan_cheerdetails")
    public void fancm(){

    }
    @GetMapping("/fan_cheermain")
    public void fancd(){

    }
    @GetMapping("/fan_faq")
    public void fanfq(){

    }
    @GetMapping("/fan_free")
    public void fanf(){

    }
    @GetMapping("/fan_main")
    public void fanm(){

    }
    @GetMapping("/fan_story")
    public String fanStoryPage() {
        return "fan/fan_story";
    }


    @GetMapping("/stories")
    public ResponseEntity<List<StoryEntity>> getStories() {
        return ResponseEntity.ok(storyService.findAll());
    }

    @PostMapping("/story")
    public ResponseEntity<?> addStory(@RequestParam("title") String title, @RequestParam("author") String author,
                                      @RequestParam("content") String content, @RequestParam("image") MultipartFile image) {
        try {
            StoryEntity story = storyService.save(title, author, content, image);
            return ResponseEntity.ok(story);
        } catch (Exception e) {
            e.printStackTrace();  // 오류를 콘솔에 출력합니다.
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Failed to add story.");
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @PutMapping("/story/{id}")
    public ResponseEntity<?> updateStory(@PathVariable Long id, @RequestParam("title") String title,
                                         @RequestParam("author") String author, @RequestParam("content") String content,
                                         @RequestParam("image") MultipartFile image) {
        try {
            StoryEntity story = storyService.update(id, title, author, content, image);
            return ResponseEntity.ok(story);
        } catch (com.example.sl.exception.ResourceNotFoundException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Story not found.");
            return ResponseEntity.status(404).body(errorResponse);
        } catch (Exception e) {
            e.printStackTrace();  // 오류를 콘솔에 출력합니다.
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Failed to update story.");
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @DeleteMapping("/story/{id}")
    public ResponseEntity<?> deleteStory(@PathVariable Long id) {
        try {
            storyService.delete(id);
            Map<String, String> successResponse = new HashMap<>();
            successResponse.put("message", "Story deleted successfully.");
            return ResponseEntity.ok(successResponse);
        } catch (com.example.sl.exception.ResourceNotFoundException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Story not found.");
            return ResponseEntity.status(404).body(errorResponse);
        } catch (Exception e) {
            e.printStackTrace();  // 오류를 콘솔에 출력합니다.
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Failed to delete story.");
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @GetMapping("/story/{id}")
    public ResponseEntity<?> getStory(@PathVariable Long id) {
        Optional<StoryEntity> story = storyService.findById(id);
        return story.map(storyEntity -> ResponseEntity.ok().body(storyEntity))
                .orElseGet(() -> {
                    Map<String, String> errorResponse = new HashMap<>();
                    errorResponse.put("message", "Story not found.");
                    return ResponseEntity.status(404).body(errorResponse);
                });
    }
}
