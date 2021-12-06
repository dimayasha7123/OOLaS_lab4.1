package OOLaS_lab41;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Stack;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        System.out.println("Stack");
        System.out.println("Создать текстовый файл. Распечатать гласные буквы этого файла в обратном порядке.");
        System.out.println("=================================================================================");

        try {

            Stack<Character> vowelStack = new Stack<>();
            Files.lines(Path.of("input.txt"))
                    .reduce((s1, s2) -> s1 + "\n" + s2).orElse("")
                    .chars()
                    .mapToObj((x) -> (char) x)
                    .peek(System.out::print)
                    .forEach((x) -> Stream.of('a', 'e', 'i', 'o', 'q', 'u', 'y', 'A', 'E', 'I', 'O', 'Q', 'U', 'Y')
                            .forEach((y) -> {
                                if (x.equals(y)) vowelStack.push(x);
                            }));

            System.out.println("\nГласные в обратном порядке:");
            while (vowelStack.size() != 0) System.out.print(vowelStack.pop() + " ");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
