package com.example.SpringBoot_Production_Features.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Post extends AuditableEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @PrePersist
    public void prePersist() {}

    @PreUpdate
    public void preUpdate() {}

    @PreRemove
    public void preRemove() {}
}
