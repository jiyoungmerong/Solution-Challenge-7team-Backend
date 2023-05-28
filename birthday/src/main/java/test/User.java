package test;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class User {
    @NotNull(message = "이름을 적어주세요")
    @Size(min = 3, max = 10)
    private String name;

    @NotNull
    @Pattern(regexp = "[a-zA-z0-9]+@[a-zA-z]+[.]+[a-zA-z.]+")
    private String email;
}