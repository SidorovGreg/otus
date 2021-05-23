package io.sidorovgreg.otus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        String path = args.length > 0 ? args[0] : "src/main/resources";
        getTasks().forEach(task -> {
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
                } catch (IOException e) {
                    break;
                }
            }
        });
    }

    private static Collection<Task> getTasks() {
        try (Stream<Path> walk = Files.walk(Paths.get("src/main/java/io/sidorovgreg/otus/tasks"))) {
            return walk
                    .map(Path::getFileName)
                    .filter(file -> file.toString().endsWith(".java"))
                    .map(file -> "io.sidorovgreg.otus.tasks." + file.toString().replace(".java", ""))
                    .map(className -> {
                        try {
                            return (Task) Class.forName(className).getConstructor().newInstance();
                        } catch (Exception e) {
                            e.printStackTrace();
                            throw new RuntimeException(e.getMessage());
                        }
                    })
                    .collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

}