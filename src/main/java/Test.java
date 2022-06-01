import java.io.BufferedReader;

public class Test {
    public static void main(String[] args) {
        String first = "301;2110000;2129999;20000;ПАО \"Ростелеком\";г. Улан-Удэ|Республика Бурятия;7707049388";
        String second = "р-н Хилокский|Забайкальский край";
        String regex = "[;\\|]";
        String[] parts = first.split(regex);
        System.out.println(parts.length);
        for (int i = 0; i < parts.length; i++) {
            System.out.println(parts[i]);
        }

    }
}
