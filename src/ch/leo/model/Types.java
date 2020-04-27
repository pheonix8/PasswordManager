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
public class Types extends DefaultComboBoxModel<String> {

    private Vector<String> types;

    public Types() {
        this.types = new Vector<String>();
    }

    public void addType(String type) {
        types.add(type);
    }

    public void removeType(int index) {
        types.remove(index);
    }

    public String toString() {
        String out = "Types: ";
        for (String type : types) {
            out += type + ", ";
        }
        return out;
    }

    public String getElementAt(int index) {
        return types.get(index);
    }

    public int getSize() {
        return types.size();
    }

}

