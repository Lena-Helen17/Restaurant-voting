package com.github.lenaHelen17.boot.web.testData;

import com.github.lenaHelen17.boot.model.Role;
import com.github.lenaHelen17.boot.model.User;
import com.github.lenaHelen17.boot.util.JsonUtil;


import java.util.Collections;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class UserTestData {
    public static final MatcherFactory.Matcher<User> USER_MATCHER = MatcherFactory.usingIgnoringFieldsComparator(User.class, "registered", "meals", "password");
    public static MatcherFactory.Matcher<User> USER_WITH_MEALS_MATCHER =
            MatcherFactory.usingAssertions(User.class,
                    //     No need use ignoringAllOverriddenEquals, see https://assertj.github.io/doc/#breaking-changes
                    (a, e) -> assertThat(a).usingRecursiveComparison()
                            .ignoringFields("registered", "meals.user", "password").isEqualTo(e),
                    (a, e) -> {
                        throw new UnsupportedOperationException();
                    });

    public static final Integer USER_ID = 1;
    public static final Integer ADMIN_ID = 2;
    public static final int NOT_FOUND = 100;
    public static final String USER_MAIL = "user@gmail.com";
    public static final String ADMIN_MAIL = "admin@mail.ru";

    public static final User userTest = new User(USER_ID,  USER_MAIL, "User_First", "User_Last", "password", Collections.singleton(Role.USER));
    public static final User adminTest = new User(ADMIN_ID, ADMIN_MAIL,"Admin_First","Admin_Last",  "admin", Collections.singleton(Role.ADMIN));


    public static User getNew() {
        return new User("new@gmail.com", "New", "New", "newPass", Collections.singleton(Role.USER));
    }

    public static User getUpdated() {
        return new User(USER_ID, USER_MAIL, "UpdatedName", "Update","newPass",  Set.of(Role.ADMIN));
    }

    public static String jsonWithPassword(User user, String passw) {
        return JsonUtil.writeAdditionProps(user, "password", passw);
    }
}
