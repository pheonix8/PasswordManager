package ch.leo.model;

import java.util.Vector;

/**
 * Project PasswordManager
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 27.04.2020
 */
public class AllCompilations {

    private Vector<Compilation> allCompilations;

    /**
     * Instantiates a new All compilations.
     */
    public AllCompilations() {
        allCompilations = new Vector<Compilation>();
    }

    /**
     * Add compilation.
     *
     * @param compilation the compilation
     */
    public void addCompilation(Compilation compilation){
        allCompilations.add(compilation);
    }

    /**
     * Get size int.
     *
     * @return the int
     */
    public int getSize(){
        return allCompilations.size();
    }

    /**
     * Gets element at.
     *
     * @param index the index
     * @return the element at
     */
    public Compilation getElementAt(int index) {
        return allCompilations.get(index);
    }

    /**
     * Get elementbyname compilation.
     *
     * @param name the name
     * @return the compilation
     */
    public Compilation getElementbyname(String name){
        int index = 50;
        for (int i = 0; i < allCompilations.size(); i++) {
            if (allCompilations.get(i).getName().equalsIgnoreCase(name)){
                index = i;
                break;
            }
        }
        return allCompilations.get(index);
    }
}
