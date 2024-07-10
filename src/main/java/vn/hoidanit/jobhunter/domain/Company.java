package vn.hoidanit.jobhunter.domain;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.criteria.CriteriaBuilder.In;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import vn.hoidanit.jobhunter.util.SecurityUtil;

@Entity
@Table(name = "companies")
@Getter
@Setter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;

    @NotBlank(message = "name khong duoc de trong")
    private String name;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String description;

    private String logo;

    private String address;

    // @JsonFormat(pattern = "dd-MM-YYY HH:mm:ss a", timezone = "GTM+7")
    private Instant createdAt;
    // @JsonFormat(pattern = "dd-MM-YYY HH:mm:ss a", timezone = "GTM+7")
    private Instant updatedAt;

    private String createdBy;

    private String updatedBy;
    
    @PrePersist
    public void handleBeforeCreateAt(){
        this.createdBy = SecurityUtil.getCurrentUserLogin().isPresent() == true 
            ? SecurityUtil.getCurrentUserLogin().get()
            : "";
        this.createdAt = Instant.now();
    }

    @PreUpdate
    public void handleBeforeUpdate(){
        this.updatedBy = SecurityUtil.getCurrentUserLogin().isPresent() == true 
        ? SecurityUtil.getCurrentUserLogin().get()
        : "";
        this.updatedAt = Instant.now();
    }

}
