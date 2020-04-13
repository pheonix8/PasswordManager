package ch.leo.model;

import java.util.Vector;

/**
 * Project Password_Manager
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 13.04.2020
 */
public class Types {

    private Vector<Type> types;

    public Types(Vector<Type> types) {
        this.types = types;
    }

    public void addType(Type type){
        types.add(type);
    }

    public int getType(int index){
        types.get(index);
        return index;
    }

    public void removeType(int index){
        types.remove(index);
    }
}
