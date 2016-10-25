package com.example.data.entity.mapper;

import com.example.Character;
import com.example.data.entity.CharacterEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by jfuentesa on 24/10/2016.
 */

public class CharactersEntityDataMapper {

    public CharactersEntityDataMapper() {
    }

    public Collection<Character> transform(Collection<CharacterEntity> characterEntityCollection){
        List<Character> characterList = new ArrayList<>();

        if(characterEntityCollection != null){
            for(CharacterEntity characterEntity : characterEntityCollection){
                characterList.add(transform(characterEntity));
            }
        }else{
            characterList = Collections.emptyList();
        }
        return characterList;
    }

    private Character transform(CharacterEntity characterEntity){
        Character character = null;
        if(characterEntity!= null){
            character = new Character();
            character.setId(characterEntity.getId());
            character.setName(characterEntity.getName());
            character.setThumbnail(characterEntity.getThumbnail());
            character.setAge(characterEntity.getAge());
            character.setWeight(characterEntity.getWeight());
            character.setHeight(characterEntity.getHeight());
            character.setHair_color(characterEntity.getHair_color());
            character.setProfessions(characterEntity.getProfessions());
            character.setFriends(characterEntity.getFriends());
        }
        return character;
    }
}
