package authorization;

public interface AuthService {

    boolean authUser(String username, String password);
}
