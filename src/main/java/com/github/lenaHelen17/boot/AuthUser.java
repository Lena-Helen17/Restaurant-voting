package com.github.lenaHelen17.boot;

import com.github.lenaHelen17.boot.model.User;
import lombok.Getter;
import lombok.ToString;
import org.springframework.lang.NonNull;


@Getter
@ToString(of = "user")
public class AuthUser extends org.springframework.security.core.userdetails.User{

    private User user;

    public AuthUser(@NonNull User user) {
        super(user.getEmail(), user.getPassword(), user.getRoles());
        this.user = user;
    }

    public int id() {
        return user.id();
    }
}
