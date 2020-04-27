package ch.leo.model;

/**
 * Project Password_Manager
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 13.04.2020
 */
public class Application {
    private String password;
    private String username;
    private String application;
    private String email;
    private String type;

    public Application(String application, String username, String password, String email, String type) {
        this.password = password;
        this.username = username;
        this.application = application;
        this.email = email;
        this.type = type;
    }

    public void setApplication(String application, String type) {
        setApplication(application);
        setType(type);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return application + ","
                + username + ","
                + password + ","
                + email + ","
                + type;
    }
}
