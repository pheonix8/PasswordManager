package ch.leo.model;

import java.util.Vector;

/**
 * Project Password_Manager
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 13.04.2020
 */
public class Compilation {
    private Vector<Application> allApplications;

    public Compilation(Vector<Application> allApplications) {
        this.allApplications = allApplications;
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

    }

    public void readfile(){

    }

}
