package com.andromeda.forohub.repository;

import com.andromeda.forohub.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

    Boolean existsByTitleAndMessage(String title, String message);
}
