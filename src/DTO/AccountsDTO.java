package DTO;

public class AccountsDTO {
    private String __username;
    private String __password;

    public AccountsDTO () {

    }

    public AccountsDTO(String username, String password) {
        this.__password = password;
        this.__username = username;
    }

    public void set__password(String __password) {
        this.__password = __password;
    }

    public String get__password() {
        return __password;
    }

    public void set__username(String __username) {
        this.__username = __username;
    }

    public String get__username() {
        return __username;
    }

    @Override
    public String toString() {
        return __username + " " + __password;
    }
}
