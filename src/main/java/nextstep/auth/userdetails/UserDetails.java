package nextstep.auth.userdetails;

public interface UserDetails {
    String getUsername();

    String getPassword();

    String getRole();

    boolean checkPassword(String password);

}
