package vn.hoidanit.jobhunter.domain.response;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.hoidanit.jobhunter.util.constant.GenderEnum;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResUserDTO {
    private Long id;
    private String name;
    private String email;
    private int age;
    private Instant updatedAt;
    private Instant createdAt;
    private GenderEnum gender;
    private String address;
}
