package jfuentesa.cleanarchitecture.comparator;

import com.example.Character;

import java.util.Comparator;

/**
 * Created by jfuentesa on 25/10/2016.
 */

public class OrderByName implements Comparator<Character> {
    @Override
    public int compare(Character o1, Character o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
