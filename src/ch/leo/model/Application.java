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

    /**
     * Instantiates a new Application.
     *
     * @param application the application
     * @param username    the username
     * @param password    the password
     * @param email       the email
     * @param type        the type
     */
    public Application(String application, String username, String password, String email, String type) {
        this.password = password;
        this.username = username;
        this.application = application;
        this.email = email;
        this.type = type;
    }

    /**
     * Sets application.
     *
     * @param application the application
     * @param type        the type
     */
    public void setApplication(String application, String type) {
        setApplication(application);
        setType(type);
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets application.
     *
     * @return the application
     */
    public String getApplication() {
        return application;
    }

    /**
     * Sets application.
     *
     * @param application the application
     */
    public void setApplication(String application) {
        this.application = application;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
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
