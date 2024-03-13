package com.gasnikovma.vk.models.entities;


import com.gasnikovma.vk.models.HttpRequest;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@Entity
@Table(name = "Posts")
@EntityListeners(AuditingEntityListener.class)
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private int postId;


    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private long createdDate;


    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;

    @Column(name = "action")
    private String action;

}
