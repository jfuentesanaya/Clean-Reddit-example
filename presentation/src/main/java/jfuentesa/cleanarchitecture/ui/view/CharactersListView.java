package jfuentesa.cleanarchitecture.ui.view;

import com.example.Character;

import java.util.Collection;

/**
 * Created by jfuentesa on 21/10/2016.
 */

public interface CharactersListView extends LoadDataView {
    void renderCharacterList(Collection<Character> characterCollection);

}
