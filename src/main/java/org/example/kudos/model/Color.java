package org.example.kudos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter
@Setter
public class Color {
    @Id
    @NotBlank()
    private String kudosType;
    @NotBlank()
    private String logoImage;
    @NotBlank()
    private String button;
}
