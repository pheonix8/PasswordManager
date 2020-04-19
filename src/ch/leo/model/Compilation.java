package ch.leo.model;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Vector;
import java.util.stream.Stream;

/**
 * Project Password_Manager
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 13.04.2020
 */
public class Compilation extends DefaultListModel<Application> {
    private Vector<Application> allApplications;

    public Compilation() {
        this.allApplications = new Vector<Application>();
    }

    public void addApplication(Application application){
        allApplications.add(application);
    }

    public int getApplication(int index){
        allApplications.get(index);
        return index;
    }

    public void removeApplication(int index){
        allApplications.remove(index);
    }

    public void createfile(){

        PrintStream out = null;

        try {
            System.out.println("Start writing to file");
            out = new PrintStream(new FileOutputStream("AllApplications_passwords.txt"));

            for (int i = 0; i < allApplications.size(); i++) {
                out.println(allApplications.elementAt(i));
            }
        } catch (ArrayIndexOutOfBoundsException e){
            System.err.println("ArrayIndexOutOfBoundsException Error:" + e.getMessage());
        } catch (IOException e){
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

    public void readfile(){

        try {
            Stream<String> lines = Files.lines(Paths.get("AllApplications_passwords.txt"));
            lines.forEach((String t) -> {
                String[] parse = t.split(",");
                if(parse.length<2) return;
                int i = Integer.parseInt(parse[4]);
                allApplications.add(new Application(parse[0], parse[1], parse[2], parse[3], i));
            });
        } catch (IOException ex) {
            System.out.println("Unable to open student file." + ex.toString());
        }

    }

}
