package strtwo;

import java.util.*;
import java.util.stream.Collectors;

public class TestStream {
    private static List<User> userList;

    public TestStream() {
        User ivan = new User(1, 10, "Ivan");
        User petya = new User(2, 12, "Petya");
        User masha = new User(3, 15, "Masha");
        User secondMasha = new User(4, 9, "Masha");
        User olya = new User(5, 17, "Olya");
        User kolya = new User(6, 20, "Koly");
        User misha = new User(7, 14, "Misha");
        User pasha = new User(8, 20, "Pasha");
        User vera = new User(9, 12, "Vera");
        User katya = new User(10, 17, "Katya");
        User sasha = new User(13, 40, "Sasha");
        User vitya = new User(14, 50, "Vitya");
        List<User> children = new ArrayList<>();
        children.add(ivan);
        children.add(masha);
        children.add(secondMasha);
        children.add(misha);
        children.add(pasha);
        children.add(katya);
        sasha.setChildren(children);
        List<User> childrenOfVitya = new ArrayList<>();
        childrenOfVitya.add(petya);
        childrenOfVitya.add(vera);
        vitya.setChildren(childrenOfVitya);
        userList = new ArrayList<>();
        userList.add(ivan);
        userList.add(petya);
        userList.add(masha);
        userList.add(secondMasha);
        userList.add(olya);
        userList.add(kolya);
        userList.add(misha);
        userList.add(pasha);
        userList.add(vera);
        userList.add(katya);
        userList.add(sasha);
        userList.add(vitya);
    }

    public static void main(String[] args) {
        TestStream testStream = new TestStream();
//        getSumAgeParents(userList);
//        getMaxAgeParent(userList);
    }

    private static int getSumAgeParents(List<User> userList) {
        return userList.stream()
                .filter(user -> user.getChildren() != null)
                .mapToInt(user -> user.getAge()).sum();

    }

    private static long getCountParentOlder27(List<User> userList){
       return userList.stream()
                .filter(user -> user.getChildren()!=null)
                .filter(user -> user.getAge()>27)
                .count();
    }

    private static long getCountChildren(List<User> userList){
        return userList.stream()
                .filter(user -> user.getChildren()!=null)
                .flatMap(user -> user.getChildren().stream())
                .count();
    }

    private static long getSumAgesChildren(List<User> userList){
        return userList.stream()
                .filter(user -> user.getChildren()!=null)
                .flatMap(user -> user.getChildren().stream())
                .mapToLong(User::getAge)
                .sum();
    }

    private static List<User> getChildrenSortedByAge(List<User> userList){
        return userList.stream()
                .filter(user -> user.getChildren()!=null)
                .flatMap(user -> user.getChildren().stream())
                .sorted(Comparator.comparingInt(User::getAge))
                .collect(Collectors.toList());
    }

    private static List<User> getChildrenLess10(List<User> userList){
       return userList.stream()
                .filter(user -> user.getChildren()!=null)
                .flatMap(user -> user.getChildren().stream())
                .filter(user -> user.getAge() < 10)
                .collect(Collectors.toList());
    }

    private static List<String> getListUniqueNameChildren(List<User> userList){
        return userList.stream()
                .filter(user -> user.getChildren()!=null)
                .flatMap(user -> user.getChildren().stream())
                .map(user -> user.getName())
                .distinct()
                .collect(Collectors.toList());
    }

    private static boolean getSomeChildrenOlder17(List<User> userList){
        return userList.stream()
                .filter(user -> user.getChildren()!=null)
                .flatMap(user -> user.getChildren().stream())
                .anyMatch(user -> user.getAge()>17);
    }

    private static boolean getAllChildrenLess30(List<User> userList){
        return userList.stream()
                .filter(user -> user.getChildren()!=null)
                .flatMap(user -> user.getChildren().stream())
                .allMatch(user -> user.getAge()<30);
    }

    private static int getMaxAgeParent(List<User> userList){
        return userList.stream()
                .filter(user -> user.getChildren()!=null)
                .max(Comparator.comparingInt(User::getAge))
                .get().getAge();
    }

    private static int getMinAgeChild(List<User> userList){
        return userList.stream()
                .filter(user -> user.getChildren()!=null)
                .flatMap(user -> user.getChildren().stream())
                .min((user1, user2) -> user1.getAge()-user2.getAge())
                .get().getAge();
    }

    private static OptionalDouble getAverageAgeChildren(List<User> userList) {
        return userList.stream()
                .filter(user -> user.getChildren()!=null)
                .flatMap(user -> user.getChildren().stream())
                .mapToInt(user-> user.getAge())
                .average();
    }

    private static long getMultyAgeParents(List<User> userList){
        return userList.stream()
                .filter(user -> user.getChildren()!=null)
                .mapToLong(user -> user.getAge())
                .reduce((user, user2) -> user*user2)
                .orElse(0);
    }

    private static String getFirstNameParentWhereAgeMoreNumber(List<User> userList, int i){
        return userList.stream()
                .filter(user -> user.getChildren()!=null)
                .filter(user -> user.getAge() < i)
                .map(User::getName)
                .findFirst()
                .orElse("none");
    }

    private static Long getFirstIdChildWhereAgeLessNumber(List<User> userList){
        return userList.stream()
                .filter(user -> user.getChildren()!=null)
                .flatMap(user -> user.getChildren().stream())
                .filter(user -> user.getAge()<10)
                .map(user -> user.getId())
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
