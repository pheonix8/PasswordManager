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
    private Vector<Application> allApplications, selectedApplications;
    private String selectedType;

    public Compilation() {
        allApplications = new Vector<Application>();
        selectedApplications = new Vector<Application>();
        selectedType = null;
    }

    public  int getOriginalSize(){
        return allApplications.size();
    }

    public int getSelectedSize(){
        return selectedApplications.size();
    }

    public void addApplication(Application application){
        allApplications.add(application);
        selectedApplications.add(application);
    }

    public String getApplication(int index){
        return allApplications.get(index).getApplication();

    }

    public void removeApplication(Application application){
        allApplications.remove(application);
    }

    @Override
    public String toString() {
        String out = "all Passwords:\n";

        for (Application application : allApplications) {
            out += application.toString() + "\n";
        }
        return out;
    }

    public int getSize() {
        if (selectedType == null)
            return allApplications.size();
        else
            return selectedApplications.size();
    }

    public Application getElementAt(int index) {
        if (selectedType == null)
            return allApplications.get(index);
        else
            return selectedApplications.get(index);
    }

    public  void setSelectedType(String type) {
        selectedApplications.clear();
        selectedType = type;
        System.out.println("Type = " + selectedType);
        for (Application application : allApplications) {
            if ( application.getType().compareToIgnoreCase(type) == 0)
                selectedApplications.add(application);
        }
        this.fireContentsChanged(this, 0, selectedApplications.size());
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
                allApplications.add(new Application(parse[0], parse[1], parse[2], parse[3], parse[4]));
            });
        } catch (IOException ex) {
            System.out.println("Unable to open file." + ex.toString());
        }

    }

}
