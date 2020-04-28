package com.wildcodeschool.sharemybrain.repository;

import com.wildcodeschool.sharemybrain.entity.Avatar;

import java.util.ArrayList;
import java.util.List;

public class AvatarRepository {

    private static List<Avatar> initAvatar() {

        List<Avatar> avatars = new ArrayList<>();
        avatars.add(new Avatar("cat.png"));
        avatars.add(new Avatar("bull.png"));
        avatars.add(new Avatar("fox.png"));
        avatars.add(new Avatar("deer.png"));
        avatars.add(new Avatar("dog.png"));
        avatars.add(new Avatar("monkey.png"));
        avatars.add(new Avatar("panda.png"));
        avatars.add(new Avatar("pig.png"));
        return avatars;

    }
}

