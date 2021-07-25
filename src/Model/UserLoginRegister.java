package Model;

public class UserLoginRegister {

    private String username;
    private String password;

    public UserLoginRegister(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserLoginRegister() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
