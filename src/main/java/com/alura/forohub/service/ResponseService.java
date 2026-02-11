package com.andromeda.forohub.service;

import com.andromeda.forohub.dto.RespRequestDTO;
import com.andromeda.forohub.dto.RespResponseDTO;
import com.andromeda.forohub.model.Response;
import com.andromeda.forohub.repository.ResponseRepository;
import com.andromeda.forohub.repository.TopicRepository;
import com.andromeda.forohub.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ResponseService {

    private final ResponseRepository responseRepository;
    private final TopicRepository topicRepository;
    private final UserRepository userRepository;

    public ResponseService(ResponseRepository responseRepository, TopicRepository topicRepository, UserRepository userRepository) {
        this.responseRepository = responseRepository;
        this.topicRepository = topicRepository;
        this.userRepository = userRepository;
    }

    public RespResponseDTO register(RespRequestDTO data) {
        var topic = topicRepository.getReferenceById(data.topicId());
        var user = userRepository.getReferenceById(data.userId());

        var response = new Response();
        response.setMessage(data.message());
        response.setCreationDate(LocalDateTime.now());
        response.setUser(user);
        response.setTopic(topic);
        responseRepository.save(response);
        return new RespResponseDTO(response);
    }
}
