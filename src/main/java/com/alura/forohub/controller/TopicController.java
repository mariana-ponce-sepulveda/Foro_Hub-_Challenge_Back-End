package com.andromeda.forohub.controller;

import com.andromeda.forohub.dto.TopicRequestDTO;
import com.andromeda.forohub.dto.TopicResponseDTO;
import com.andromeda.forohub.dto.TopicToUpdate;
import com.andromeda.forohub.service.TopicService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topics")
public class TopicController {

    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicResponseDTO> get(@PathVariable Long id){
        return ResponseEntity.ok(topicService.get(id));
    }

    @GetMapping()
    public ResponseEntity<Page<TopicResponseDTO>> getAll(@PageableDefault(size = 10, sort = "creationDate", direction = Sort.Direction.ASC) Pageable pagination){
        return ResponseEntity.ok(topicService.getAll(pagination));
    }

    @PostMapping()
    public ResponseEntity<TopicResponseDTO> register(@RequestBody @Valid TopicRequestDTO topic){
        var response = topicService.register(topic);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicResponseDTO> register(@PathVariable Long id, @RequestBody @Valid TopicToUpdate topic){
        var response = topicService.update(id, topic);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTopic(@PathVariable Long id){
        topicService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
