
import java.util.Objects;
import java.util.function.BiFunction;

public class HarryPotter {
    public static void main(String[] args) {
        draw(1, (x, y) -> x < y);
        draw(2, Objects::equals);
        draw(3, (x, y) -> x == 24 - y);
        draw(4, (x, y) -> x + y < 30);
    }

    private static void draw (final Integer number, final BiFunction<Integer, Integer, Boolean> func) {
        System.console().printf("Number %s:\n", number);
        for (int i = 0; i < 25; i++) {
            for (int y = 0; y < 25; y++) {
                System.console().printf(func.apply(i, y) ? "# " : ". ");
            }
            System.console().printf("\n");
        }
    }
}
