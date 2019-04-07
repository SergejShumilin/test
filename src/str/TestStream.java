package str;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


public class TestStream {
    private static List<User> userList;


    public static void main(String[] args) {
        User ivan = new User(1, 10, "Ivan");
        User petya = new User(2, 12, "Petya");
        User masha = new User(3, 15, "Masha");
        User secondMasha = new User(4, 9, "Masha");
        User olya = new User(4, 17, "Olya");
        User kolya = new User(5, 20, "Koly");
        User sasha = new User(6, 40, "Sasha");
        List<User> children = new ArrayList<>();
        children.add(ivan);
        children.add(masha);
        children.add(secondMasha);
        sasha.setChildren(children);
        userList = new ArrayList<>();
        userList.add(ivan);
        userList.add(petya);
        userList.add(masha);
        userList.add(olya);
        userList.add(kolya);
        userList.add(sasha);

//        countChildren(userList);
//        countAgeParents(userList);
//        countParentsOlderThan27Age(userList);
//        countSumAgeChild(userList);
//        sortedChildrenByAge(userList);
//        getChildrenAgeLess15(userList);
//        getUniqueChildrenName(userList);
//        getChildrenOlder17(userList);
//        getAllChildrenLess30(userList);
        getMaxAgeParent(userList);
    }


    private static void countChildren(List<User> userList) {
        long count = userList.stream()
                .filter(user -> user.getChildren() != null)
                .flatMap(user -> user.getChildren().stream())
                .count();
        System.out.println(count);
    }

    private static void countAgeParents(List<User> userList) {
        int sum = userList.stream()
                .filter(user -> user.getChildren() == null)
                .mapToInt(User::getAge)
                .sum();
        System.out.println(sum);
    }

    private static void countParentsOlderThan27Age(List<User> userList) {
        long count = userList.stream()
                .filter(user -> user.getChildren() != null)
                .filter(user -> user.getAge() > 27)
                .count();
        System.out.println(count);
    }

    private static void countSumAgeChild(List<User> userList) {
        int sum = userList.stream()
                .filter(user -> user.getChildren() != null)
                .flatMap(user -> user.getChildren().stream())
                .mapToInt(User::getAge)
                .sum();
        System.out.println(sum);
    }

    private static void sortedChildrenByAge(List<User> userList) {
        userList.stream()
                .filter(user -> user.getChildren() != null)
                .flatMap(user -> user.getChildren().stream())
                .sorted(Comparator.comparingInt(User::getAge))
                .forEach(System.out::println);
    }

    private static void getChildrenAgeLess15(List<User> userList) {
        userList.stream()
                .filter(user -> user.getChildren() != null)
                .flatMap(user -> user.getChildren().stream())
                .filter(user -> user.getAge() < 15)
                .forEach(System.out::println);
    }

    private static void getUniqueChildrenName(List<User> userList) {
        userList.stream()
                .filter(user -> user.getChildren() != null)
                .flatMap(user -> user.getChildren().stream())
                .map(user -> user.getName())
                .distinct()
                .forEach(s -> System.out.println(s));
    }

    private static void getChildrenOlder17(List<User> userList){
        boolean b = userList.stream()
                .filter(user -> user.getChildren() != null)
                .flatMap(user -> user.getChildren().stream())
                .anyMatch(user -> user.getAge() > 17);
        System.out.println(b);
    }

    private static void getAllChildrenLess30(List<User> userList){
        boolean b = userList.stream()
                .filter(user -> user.getChildren() != null)
                .flatMap(user -> user.getChildren().stream())
                .allMatch(user -> user.getAge() < 30);
        System.out.println(b);
    }

    private static void getMaxAgeParent(List<User> userList){
        Optional<User> max = userList.stream()
                .filter(user -> user.getChildren() != null)
                .max((Comparator.comparingInt(User::getAge)));
        System.out.println(max.get());
    }
}

