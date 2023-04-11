package org.fleetingly.auth.domain;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class UserDetails {

    private Long id;
    @NotBlank
    private String name;
    @Min(1)
    @Max(100)
    private int age;
    @NotBlank
    private String position;
}
