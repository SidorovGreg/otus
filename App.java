
import tasks.Task;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.*;

public class App {
    public static void main(String[] args) throws IOException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, ClassNotFoundException {
        Class<?> clazz = Class.forName(args[0]);
        Constructor<?> ctor = clazz.getConstructor();
        Task task = (Task) ctor.newInstance();
        String path = args[1];
        for (int i = 0; true; i++) {
            try {
                String in = Files.readAllLines(Paths.get(String.format("%s/test.%s.in", path, i))).stream()
                        .findFirst()
                        .orElse("");
                String out = Files.readAllLines(Paths.get(String.format("%s/test.%s.out", path, i))).stream()
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("expected result isn't exist"));
                String result = task.execute(in);
                if (Objects.equals(result, out)) {
                    System.out.printf("[%s] success%n", in);
                } else {
                    System.out.printf("[%s] fail: got %s, expected %s %n", in, result, out);
                }
            } catch (NoSuchFileException e) {
                break;
            }
        }
    }
}
