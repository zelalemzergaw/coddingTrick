import java.util.*;
import java.util.stream.Collectors;

public class Product {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(1);
        integerList.add(3);
        integerList.add(5);
        integerList.add(6);
        integerList.add(6);
        integerList.add(10);
        integerList.add(11);
        System.out.println(duplicate(integerList));
    }
    public static  List<Integer> duplicate(List<Integer> integerList){
        LinkedHashSet<Integer> setIn = new LinkedHashSet<>(integerList); //O(n)
        ArrayList<Integer> integerNoDup = new ArrayList<>(setIn); //O(n)
//        return integerNoDup;
        return integerList.stream().distinct().collect(Collectors.toList());
    }
}
