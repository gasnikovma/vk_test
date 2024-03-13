package com.gasnikovma.vk.models.entities;


import com.gasnikovma.vk.models.Album;
import com.gasnikovma.vk.models.HttpRequest;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "Albums")
@EntityListeners(AuditingEntityListener.class)
public class AlbumEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int albumId;


    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime localDateTime;


    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;

    @Column(name = "action")
    private String action;

}

