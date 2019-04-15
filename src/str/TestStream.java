package str;


import java.util.*;
import java.util.stream.Collectors;


public class TestStream {
    private static List<User> userList;


    public static void main(String[] args) {
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


//        countChildren(userList);
//        countAgeParents(userList);
//        countParentsOlderThan27Age(userList);
//        countSumAgeChild(userList);
//        sortedChildrenByAge(userList);
//        getChildrenAgeLess15(userList);
//        getUniqueChildrenName(userList);
//        getChildrenOlder17(userList);
//        getAllChildrenLess30(userList);
//        getMaxAgeParent(userList);
//    getMinAgeChild(userList);
//    getAverageChildrenAge(userList);
//    getNameFirstParentsMoreNumber(userList, 50);
//        getFirstIdChildWhoAgeLessNumber(userList, 7);
//        getCountParentsWhoAgeBetween18and27(userList);
//    getSortedChildrenByAge(userList);
//    getSortedChildrenByAgeFrom3To6(userList);
//        getMultipliedByAgeOfParents(userList);
//        getParentsName(userList);
        getMapWithKeyId(userList);
    }

    private static long countChildren(List<User> userList) {
        long count = userList.stream()
                .filter(user -> user.getChildren() != null)
                .flatMap(user -> user.getChildren().stream())
                .count();
        return count;
    }

    private static long countAgeParents(List<User> userList) {
        int sum = userList.stream()
                .mapToInt(User::getAge)
                .sum();
        return sum;
    }

    private static long countParentsOlderThan27Age(List<User> userList) {
        long count = userList.stream()
                .filter(user -> user.getAge() > 27)
                .count();
        return count;
    }

    private static int countSumAgeChild(List<User> userList) {
        int sum = userList.stream()
                .filter(user -> user.getChildren() != null)
                .flatMap(user -> user.getChildren().stream())
                .mapToInt(User::getAge)
                .sum();
        return sum;
    }

    private static List<User> sortedChildrenByAge(List<User> userList) {
        return userList.stream()
                .filter(user -> user.getChildren() != null)
                .flatMap(user -> user.getChildren().stream())
                .sorted(Comparator.comparingInt(User::getAge))
                .collect(Collectors.toList());
    }

    private static List<User> getChildrenAgeLess15(List<User> userList) {
        return userList.stream()
                .filter(user -> user.getChildren() != null)
                .flatMap(user -> user.getChildren().stream())
                .filter(user -> user.getAge() < 15)
                .collect(Collectors.toList());
    }

    private static List<String> getUniqueChildrenName(List<User> userList) {
        return userList.stream()
                .filter(user -> user.getChildren() != null)
                .flatMap(user -> user.getChildren().stream())
                .map(User::getName)
                .distinct()
                .collect(Collectors.toList());
    }

    private static boolean getChildrenOlder17(List<User> userList) {
        return userList.stream()
                .filter(user -> user.getChildren() != null)
                .flatMap(user -> user.getChildren().stream())
                .anyMatch(user -> user.getAge() > 17);
    }

    private static boolean getAllChildrenLess30(List<User> userList) {
        return userList.stream()
                .filter(user -> user.getChildren() != null)
                .flatMap(user -> user.getChildren().stream())
                .allMatch(user -> user.getAge() < 30);
    }

    private static int getMaxAgeParent(List<User> userList) {
        return userList.stream()
                .max(Comparator.comparingInt(User::getAge))
                .get().getAge();

    }

    private static int getMinAgeChild(List<User> userList) {
        return userList.stream()
                .filter(user -> user.getChildren() != null)
                .flatMap(user -> user.getChildren().stream())
                .min((Comparator.comparingInt(User::getAge)))
                .get().getAge();

    }

    private static OptionalDouble getAverageChildrenAge(List<User> userList) {
         return userList.stream()
                .filter(user -> user.getChildren() != null)
                .flatMap(user -> user.getChildren().stream())
                .mapToInt(User::getAge)
                .average();
    }

    private static String getNameFirstParentsMoreNumber(List<User> userList, int i) {
        String name = userList.stream()
                .filter(user -> user.getAge() > i)
                .map(User::getName)
                .findFirst()
                .orElse("None");
        System.out.println(name);
        return name;
    }

    private static long getFirstIdChildWhoAgeLessNumber(List<User> userList, int i){
        Long id = userList.stream()
                .filter(user -> user.getChildren() != null)
                .flatMap(user -> user.getChildren().stream())
                .filter(user -> user.getAge() < i)
                .map(User::getId)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
        System.out.println(id);
        return id;
    }

    private static long getCountParentsWhoAgeBetween18and27(List<User> userList){
        long count = userList.stream()
                .filter(user -> user.getChildren()!=null)
                .filter(user -> user.getAge() > 18)
                .filter(user -> user.getAge() < 27)
                .count();
        System.out.println(count);
        return count;
    }

    private static List<User> getSortedChildrenByAge(List<User> userList){
        return userList.stream()
                .filter(user -> user.getChildren()!=null)
                .flatMap(user -> user.getChildren().stream())
                .sorted((Comparator.comparingInt(User::getAge)))
                .collect(Collectors.toList());
    }

    private static List<User> getSortedChildrenByAgeFrom3To6(List<User> userList){
        return userList.stream()
                .filter(user -> user.getChildren() != null)
                .flatMap(user -> user.getChildren().stream())
                .sorted((Comparator.comparingInt(User::getAge)))
                .skip(3)
                .limit(3)
                .collect(Collectors.toList());
    }

    private static long getMultipliedByAgeOfParents(List<User> userList){
         return userList.stream()
                .filter(user -> user.getChildren() != null)
                .mapToLong(User::getAge)
                .reduce((o1, o2) -> o1 * o2)
                .orElse(0);
    }

    private static List<String> getParentsName(List<User> userList){
        return userList.stream()
                .filter(user -> user.getChildren() != null)
                .flatMap(user -> Arrays.asList(user.getName().split(",")).stream())
                .collect(Collectors.toList());
    }

    private static Map<Long, List<User>> getMapWithKeyId(List<User> userList){
        return userList.stream()
                .filter(user -> user.getChildren()!=null)
                .collect(Collectors.toMap(user -> user.getId(), user -> user.getChildren()));
    }

}

