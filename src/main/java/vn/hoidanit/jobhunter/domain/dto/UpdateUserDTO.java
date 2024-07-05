package vn.hoidanit.jobhunter.domain.dto;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;
import vn.hoidanit.jobhunter.util.constant.GenderEnum;

@Setter
@Getter
public class UpdateUserDTO {
    private Long id;
    private String name;
    private String address;
    private GenderEnum gender;
    private int age;
    private Instant updatedAt;
}
