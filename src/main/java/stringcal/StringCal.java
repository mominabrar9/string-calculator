package stringcal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringCal {

    public static void main(String[] args) {
        StringCal sc = new StringCal();
        System.out.println(sc.add("//;\n1;2"));
    }

    public int add(String str) {
        int sum = 0;
        String[] arr = str.split("[^A-Za-z0-9-]");
        List<String> negList = new ArrayList<>();

        for (String num : arr) {
            if (!num.isBlank()) {
                if (Integer.valueOf(num) < 0) {
                    negList.add(num);
                } else {
                    sum = sum + Integer.valueOf(num);
                }
            }
        }

        if (!negList.isEmpty()) {
            throw new RuntimeException(
                    "negative numbers not allowed " + negList.stream().collect(Collectors.joining(",")));
        }

        return sum;
    }
}
