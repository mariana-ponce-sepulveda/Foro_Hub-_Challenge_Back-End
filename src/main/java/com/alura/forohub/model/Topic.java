package com.andromeda.forohub.model;

import com.andromeda.forohub.dto.TopicToUpdate;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String message;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;
    private Boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "topic", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Response> responses = new ArrayList<>();

    public void updateTopic(TopicToUpdate topic){
        if (topic.title() != null){
            this.title = topic.title();
        }
        if (topic.message() != null){
            this.message = topic.message();
        }
        if (topic.status() != null){
            this.status = topic.status();
        }
    }
}
