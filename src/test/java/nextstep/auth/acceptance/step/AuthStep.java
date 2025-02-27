package nextstep.auth.acceptance.step;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import nextstep.auth.oauth2.github.dto.GithubTokenRequest;
import nextstep.auth.token.dto.TokenRequest;
import nextstep.constants.Endpoint;
import nextstep.support.RestAssuredClient;

public class AuthStep {

    private static final String LOGIN_BASE_URL = Endpoint.LOGIN_BASE_URL.getUrl();

    /**
     * <pre>
     * 일반 로그인 API를 호출하는 함수
     * </pre>
     *
     * @param email 이메일
     * @param password 비밀번호
     * @return ExtractableResponse
     */
    public static ExtractableResponse<Response> 일반_로그인_요청(String email, String password) {
        TokenRequest 일반_로그인_요청_DTO = TokenRequest.builder()
                .email(email)
                .password(password)
                .build();
        String uri = String.format("%s/token", LOGIN_BASE_URL);

        return RestAssuredClient.post(uri, 일반_로그인_요청_DTO);
    }


    /**
     * <pre>
     * 깃허브 로그인 테스트 API를 호출하는 함수
     * </pre>
     *
     * @param code
     * @return ExtractableResponse
     */
    public static ExtractableResponse<Response> 깃허브_로그인_요청(String code) {
        GithubTokenRequest 깃허브_토큰_요청_DTO = new GithubTokenRequest(code);
        String uri = String.format("%s/github", LOGIN_BASE_URL);

        return RestAssuredClient.post(uri, 깃허브_토큰_요청_DTO);
    }
}
