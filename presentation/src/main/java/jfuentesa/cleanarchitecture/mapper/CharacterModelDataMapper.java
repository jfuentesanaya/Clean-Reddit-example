package jfuentesa.cleanarchitecture.mapper;

import com.example.Character;

import jfuentesa.cleanarchitecture.model.CharacterModel;

/**
 * Created by jfuentesa on 25/10/2016.
 */

public class CharacterModelDataMapper {

    public CharacterModelDataMapper() {
    }

    /**
     *
     * @param character  Object to be transformed
     * @return CharacterModel
     */
    public CharacterModel transform (Character character){
        if (character == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }

        CharacterModel characterModel = new CharacterModel(character.getId());
        characterModel.setName(character.getName());
        characterModel.setAge(character.getAge());
        characterModel.setHair_color(character.getHair_color());
        characterModel.setThumbnail(character.getThumbnail());
        characterModel.setHeight(character.getHeight());
        characterModel.setWeight(character.getWeight());
        characterModel.setFriends(character.getFriends());
        characterModel.setProfessions(character.getProfessions());

        return characterModel;
    }
}
