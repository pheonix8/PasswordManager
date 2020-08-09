package ch.leo.model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;

import java.util.Vector;
import java.util.stream.Stream;



/**
 * Project PasswordManager
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 27.04.2020
 */
public class AllUsers {

    private final Vector<User> allUsers;

    private final String code = createCode();

    /**
     * Instantiates a new All users.
     */
    public AllUsers() {
        allUsers = new Vector();
    }

    /**
     * Add user.
     *
     * @param user the user
     */
    public void addUser(User user) {
        allUsers.add(user);
    }

    /**
     * Gets element at.
     *
     * @param index the index
     * @return the element at
     */
    public User getElementAt(int index) {
        return allUsers.get(index);
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize() {
        return allUsers.size();
    }

    /**
     * Createfile.
     */
    public void createfile() {

        PrintStream out = null;

        try {
            System.out.println("Start writing to file");
            out = new PrintStream(new FileOutputStream("./User/AllUsers.txt"));

            for (int i = 0; i < allUsers.size(); i++) {
                out.println(allUsers.elementAt(i));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("ArrayIndexOutOfBoundsException Error:" + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("PrintStream");
                out.close();
            } else {
                System.out.println("Couldn't open connenction");
            }
        }

    }

    /**
     * Readfile.
     */
    public void readfile() {

        try {
            Stream<String> lines = Files.lines(Paths.get("./User/AllUsers.txt"));
            lines.forEach((String t) -> {
                String[] parse = t.split(",");
                if (parse.length < 1) return;
                allUsers.add(new User(parse[0], parse[1]));
            });
        } catch (IOException ex) {
            System.out.println("Unable to open file." + ex.toString());
        }

    }

    /**
     *
     *
    public void sendEmail(int i) {
     *
     *final String username = "passw0rdmanager.host1@gmail.com";
     *final String password = "psaaword1";
     *
     *Properties prop = new Properties();
     *prop.put("mail.smtp.host", "smtp.gmail.com");
     *prop.put("mail.smtp.port", "587");
     *prop.put("mail.smtp.auth", "true");
     *prop.put("mail.smtp.starttls.enable", "true");
     *
     *Session session = Session.getInstance(prop,
                * new javax.mail.Authenticator() {
     *

            protected PasswordAuthentication getPasswordAuthentication() {
     *return new PasswordAuthentication(username, password);
     *}
     *
        });
     *
     *try {
     *Message message = new MimeMessage(session);
     *message.setFrom(new InternetAddress(username));
     *message.setRecipients(Message.RecipientType.TO,
                    * InternetAddress.parse(getElementAt(i).getEmail())
                    *             );
     *message.setSubject("Your Login Password");
     *message.setText(code);
     *
     *Transport.send(message);
     *
     *System.out.println("Done");
     *
     *} catch (MessagingException e) {
     *e.printStackTrace();
     *}
     *}
     */



    /**
     * Create code string.
     *
     * @return the string
     */
    public String createCode() {
        String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
        String CHAR_UPPER = CHAR_LOWER.toUpperCase();
        String NUMBER = "0123456789";
        String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
        SecureRandom random = new SecureRandom();

        StringBuilder sb = new StringBuilder(8);
        for (int i = 0; i < 8; i++) {

            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);

            sb.append(rndChar);

        }

        return sb.toString();
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }
}
