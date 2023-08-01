package nextstep.auth.oauth2.github.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nextstep.auth.oauth2.OAuth2UserRequest;

@NoArgsConstructor
@AllArgsConstructor
public class GithubProfileResponse implements OAuth2UserRequest {

    @Getter
    private String email;

    private Integer age;

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public Integer getAge() {
        return age;
    }
}