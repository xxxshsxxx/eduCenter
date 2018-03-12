package ru.savshop.educenter.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class CurrentUser extends User {

    private ru.savshop.educenter.model.User user;

    public CurrentUser(ru.savshop.educenter.model.User user){
        super(user.getEmail(), user.getPassword(),
                AuthorityUtils.createAuthorityList(user.getType().name()));
        this.user = user;
    }

    public ru.savshop.educenter.model.User getUser(){
        return user;
    }

    public int getId(){
        return user.getId();
    }
}
