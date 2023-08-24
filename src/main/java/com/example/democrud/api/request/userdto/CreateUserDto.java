package com.example.democrud.api.request.userdto;

import com.example.democrud.domain.users.Users;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDto {

    @Email(message = "이메일 형식으로 입력해주세요")
    private String email;

    @Pattern(regexp = "^(?=.*[!@#$%^&*()_+{}\\[\\]:;<>,.?~\\\\/-]).{8,}$", message = "비밀번호는 8자리 이상이며, 특수문자를 포함해야 합니다.")
    private String pwd;

    @NotNull(message = "이름을 입력해주세요.")
    private String userName;

    public Users createUser(CreateUserDto createUserDto) {
        return Users.builder()
                .email(createUserDto.getEmail())
                .pwd(createUserDto.getPwd())
                .userName(createUserDto.getUserName())
                .build();
    }
}
