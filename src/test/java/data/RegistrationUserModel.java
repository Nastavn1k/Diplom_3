package data;

public class RegistrationUserModel {

    private String email;
    private String password;
    private String name;

    public String getEmail() {
        return email;
    }

    public RegistrationUserModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegistrationUserModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public RegistrationUserModel setName(String name) {
        this.name = name;
        return this;
    }
}
