package optin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestOptinal {
    private static List<User> userList;

    public static void main(String[] args) {
        User sasha = new User(1, 40, "Sasha");
        User ivan = new User(2, 3, "Ivan");
        User petya = new User(3, 7, "Petya");
        User masha = new User(4, 11, "Masha");
        User misha = new User(5, 14, "Misha");
        User userNull = new User();
        User vitya = new User(6, 50, "Vitya");
        User pasha = new User(7, 8, "Pasha");
        List<User> childrenSasha = new ArrayList<>();
        childrenSasha.add(ivan);
        childrenSasha.add(petya);
        childrenSasha.add(masha);
        sasha.setChildren(childrenSasha);
        List<User> childrenVitya = new ArrayList<>();
        childrenVitya.add(pasha);
        vitya.setChildren(childrenVitya);

        userList.add(sasha);
        userList.add(ivan);
        userList.add(petya);
        userList.add(masha);
        userList.add(misha);
        userList.add(userNull);
        userList.add(vitya);
        userList.add(pasha);

        userList.stream()
                .map(Optional::ofNullable)
                .map(TestOptinal::getNameUser)
                .forEach(System.out::println);
    }

    public static String getNameUser(Optional<User> user){
        return user.map(User::getName)
                .orElse(null);
    }

}
