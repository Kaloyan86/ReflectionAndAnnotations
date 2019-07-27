package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Method[] methods = BlackBoxInt.class.getDeclaredMethods();
        Constructor constructor = BlackBoxInt.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = (BlackBoxInt) constructor.newInstance();
        Field innerValue = BlackBoxInt.class.getDeclaredField("innerValue");

        while (!line.equals("END")) {

            String[] tokens = line.split("_");
            String command = tokens[0];
            int value = Integer.parseInt(tokens[1]);

            Method method = currentMethod(methods, command);
            method.setAccessible(true);
            method.invoke(blackBoxInt, value);
            innerValue.setAccessible(true);
            System.out.println(innerValue.getInt(blackBoxInt));
            line = scanner.nextLine();
        }
    }

    private static Method currentMethod(Method[] method, String command) {

        return Arrays.stream(method).filter(method1 -> method1.getName().equals(command)).findFirst().orElse(null);


    }
}
