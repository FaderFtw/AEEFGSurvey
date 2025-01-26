package com.aeefgsurvey.backend.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Survey {

    @Id
    private String _id;

    @ElementCollection
    @CollectionTable(name = "survey_responses", joinColumns = @JoinColumn(name = "survey_id"))
    private List<Response> responses;

    private String gender;
    private Integer age;
    private String education;
    private String educationLevel;
    private String institution;
    private String proffesion;
    private String ville;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Version
    private Integer __v;

    @PrePersist
    public void generateId() {
        if (this._id == null) {
            this._id = UUID.randomUUID().toString();
        }
    }

    @Override
    public String toString() {
        return "Survey{" +
                "_id='" + _id + '\'' +
                ", responses=" + responses +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", education='" + education + '\'' +
                ", educationLevel='" + educationLevel + '\'' +
                ", institution='" + institution + '\'' +
                ", proffesion='" + proffesion + '\'' +
                ", ville='" + ville + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", __v=" + __v +
                '}';
    }
}