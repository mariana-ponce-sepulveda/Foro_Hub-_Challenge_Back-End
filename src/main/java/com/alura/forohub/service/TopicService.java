package com.andromeda.forohub.service;

import com.andromeda.forohub.dto.TopicRequestDTO;
import com.andromeda.forohub.dto.TopicResponseDTO;
import com.andromeda.forohub.dto.TopicToUpdate;
import com.andromeda.forohub.exceptions.DuplicateException;
import com.andromeda.forohub.model.Topic;
import com.andromeda.forohub.repository.CourseRepository;
import com.andromeda.forohub.repository.TopicRepository;
import com.andromeda.forohub.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Service
public class TopicService {

    private final TopicRepository topicRepository;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public TopicService(TopicRepository topicRepository, CourseRepository courseRepository, UserRepository userRepository) {
        this.topicRepository = topicRepository;
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public TopicResponseDTO register(TopicRequestDTO data) {

        if (topicRepository.existsByTitleAndMessage(data.title(), data.message())){
            throw new DuplicateException("Ya existe un topico con el mismo título y mensaje");
        }

        var course = courseRepository.getReferenceById(data.courseId());
        var user = userRepository.getReferenceById(data.userId());

        var topic = new Topic();
        topic.setTitle(data.title());
        topic.setMessage(data.message());
        topic.setUser(user);
        topic.setCourse(course);
        topic.setStatus(true);
        topic.setCreationDate(LocalDateTime.now());

        topicRepository.save(topic);
        return new TopicResponseDTO(topic);
    }

    @Transactional(readOnly = true)
    public Page<TopicResponseDTO> getAll(Pageable pagination) {
        return topicRepository.findAll(pagination).map(TopicResponseDTO::new);
    }

    @Transactional(readOnly = true)
    public TopicResponseDTO get(Long id) {
        return new TopicResponseDTO(topicRepository.getReferenceById(id));
    }

    @Transactional
    public void delete(Long id) {
        topicRepository.deleteById(id);
    }

    @Transactional
    public TopicResponseDTO update(Long id, TopicToUpdate topic) {
        var topicUpdated = topicRepository.getReferenceById(id);
        topicUpdated.updateTopic(topic);
        return new TopicResponseDTO(topicUpdated);
    }
}

