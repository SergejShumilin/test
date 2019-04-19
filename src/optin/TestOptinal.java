package optin;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestOptinal {
    public static List<User> userList;

    public static void main(String[] args) {
        User sasha = new User(1, 40, "Sasha");
        User ivan = new User(2, 3, "Ivan");
        User petya = new User(3, 7, "Petya");
        User masha = new User(4, 11, "Masha");
        User misha = new User(5, 14, "Misha");
        User userNull = null;
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

        userList = new ArrayList<>();
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
                .map(user -> getNameChildWhereAge8(user))
                .forEach(System.out::println);
    }

    public static String getNameUser(Optional<User> user){
        return user.map(User::getName)
                .orElse(null);
    }
//не работает
//    public static List<User> getListChildren(Optional<User> user){
//        return user.filter(user1 -> user1.getChildren()!=null)
//                .flatMap(User::getChildren)
//                .collect(Collectors.toList())
//                .orElse(new ArrayList<>());
//    }

    public static String getNameChildWhereAge7(Optional<User> user){
        return user.filter(user1 -> user1.getAge()==7)
                .map(user1 -> user1.getName())
                .orElse("NoName");
    }
//не работает
    public static String getNameChildWhereAge8(Optional<User> user){
        return user.flatMap(user1 -> user1.getChildren().stream().filter(user2 -> user2.getAge()==8).findFirst())
                .map(user1 -> user1.getName())
                .orElseThrow(NoSuchElementException::new);
    }
//не работает
//    public static String getNameChildrenOrGetNoName(Optional<User> user) {
//        return user.flatMap(user1 -> user1.getChildren().stream())
//                .map(user1 -> user1.getName())
//                .orElseGet(TestOptinal::getNoName);
//    }
    public static String getNoName(){
        return "NoName";
    }
}
