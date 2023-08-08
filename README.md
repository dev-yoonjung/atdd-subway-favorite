# 지하철 노선도 미션

[ATDD 강의](https://edu.nextstep.camp/c/R89PYi5H) 실습을 위한 지하철 노선도 애플리케이션입니다.
<br/>
미션별 구한에 대한 자세한 설명은 각 미션의 PR을 확인해주세요.
<br/>

## 🚀 실습: 뼈대 코드 준비 & 문서화 실습

[Pull Request](https://github.com/next-step/atdd-subway-favorite/pull/524) | [Feature Branch](https://github.com/dev-yoonjung/atdd-subway-favorite/tree/practice)

- 뼈대 코드 설정
  - 지난 주차 미션의 코드로 설정
  <br/>

## 🚀 1단계: 내 정보 조회 기능 구현

[Pull Request](https://github.com/next-step/atdd-subway-favorite/pull/530) | [Feature Branch](https://github.com/dev-yoonjung/atdd-subway-favorite/tree/step-01)

- 요구사항 설명에서 제공되는 추가된 요구사항을 기반으로 내 정보 조회 기능 구현
  - url path가 아닌 header(authorization)을 이용하여 사용자 식별
- 인수 조건을 도출하고 검증 인수 테스트를 작성
  <br/>

## 🚀 2단계: 깃헙 로그인 인수 테스트

[Pull Request](https://github.com/next-step/atdd-subway-favorite/pull/537) | [Feature Branch](https://github.com/dev-yoonjung/atdd-subway-favorite/tree/step-02)

- AuthAcceptanceTest의 githubAuth 테스트를 성공하도록 변경
  - GithubClient의 요청이 Github이 아닌 GithubTestController에서 처리하도록 변경
  - code에 해당하는 사용자 정보를 이용하여 AccessToken 응답
  <br/>

## 🚀 3단계: 즐겨찾기 기능 구현

[Pull Request](https://github.com/next-step/atdd-subway-favorite/pull/543) | [Feature Branch](https://github.com/dev-yoonjung/atdd-subway-favorite/tree/step-03)

- 요구사항 설명에서 제공되는 추가된 요구사항을 기반으로 즐겨 찾기 기능 구현
- 추가된 요구사항을 정의한 인수 조건 도출
- 인수 조건을 검증하는 인수 테스트 작성
- 예외 케이스에 대한 검증
  - 로그인이 필요한 API 요청 시 유효하지 않은 경우 401 응답
