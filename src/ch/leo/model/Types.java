package ch.leo.model;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

/**
 * Project Password_Manager
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 13.04.2020
 */
public class Types extends DefaultComboBoxModel<Type> {

    private Vector<Type> types;

    public Types(){
        this.types = new Vector<Type>();
    }

    public void addType(Type type){
        types.add(type);
    }

    public int getIndexOfType(Type type){
        return types.indexOf(type);
    }

    public Type getType(int index){

        return types.get(index);

    }

    public void removeType(int index){
        types.remove(index);
    }

    public void createfile() {

        PrintStream out = null;

        try {
            System.out.println("Start writing to file");
            out = new PrintStream(new FileOutputStream("Types.txt"));

            for (int i = 0; i < types.size(); i++) {
                out.println(types.elementAt(i));
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

    public void readfile() {

        ArrayList<String> list = new ArrayList<String>();

        Scanner inFile = null;
        try {
            inFile = new Scanner(new File("Types.txt"));
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }

        while (inFile.hasNextLine()) {
            list.add(inFile.nextLine());
        }

        for (int i = 0; i < list.size(); i++) {
            types.add(new Type(list.get(i)));
        }


    }

    @Override
    public String toString() {
        return "" + types;
    }

}

