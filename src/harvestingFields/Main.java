package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Field[] fields = RichSoilLand.class.getDeclaredFields();

        String line = scanner.nextLine();
        while (!line.equals("HARVEST")) {
            printFields(fields, line);

            line = scanner.nextLine();
        }
    }

    private static void printFields(Field[] fields, String line) {
        if (line.equals("all")) {
            Arrays.stream(fields)
                    .forEach(field -> System.out.println(
                            String.format("%s %s %s"
                                    , Modifier.toString(field.getModifiers())
                                    , field.getType().getSimpleName()
                                    , field.getName()
                            )));
        }
        Arrays.stream(fields).filter(field -> Modifier.toString(field.getModifiers()).equals(line))
                .forEach(field -> System.out.println(
                        String.format("%s %s %s"
                                , Modifier.toString(field.getModifiers())
                                , field.getType().getSimpleName()
                                , field.getName()
                        )));
    }
}
