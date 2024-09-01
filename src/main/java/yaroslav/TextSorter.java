package yaroslav;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class TextSorter {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);


        String defaultInputFile = "src/main/java/file.txt";
        String defaultOutputFile = "src/main/java/out.txt";


        String inputFile = defaultInputFile;
        String outputFile = defaultOutputFile;


        System.out.println("Выберите тип сортировки:");
        System.out.println("1 - По алфавиту");
        System.out.println("2 - По количеству символов в строке");
        System.out.println("3 - По слову в строке (укажите порядковый номер слова)");
        int sortType = Integer.parseInt(scanner.nextLine());

        final int wordIndex;
        if (sortType == 3) {
            System.out.print("Введите порядковый номер слова для сортировки: ");
            wordIndex = Integer.parseInt(scanner.nextLine()) - 1;
        } else {
            wordIndex = -1;
        }
        List<String> lines = Files.readAllLines(Paths.get(inputFile));


        Map<String, Long> lineCounts = lines.stream()
                .collect(Collectors.groupingBy(line -> line, Collectors.counting()));

        List<String> linesWithCounts = lines.stream()
                .map(line -> line + " (" + lineCounts.get(line) + ")")
                .collect(Collectors.toList());

        Comparator<String> comparator = null;

        switch (sortType) {
            case 1: // По алфавиту
                comparator = Comparator.naturalOrder();
                break;
            case 2: // По количеству символов
                comparator = Comparator.comparingInt(String::length);
                break;
            case 3: // По слову в строке
                comparator = Comparator.comparing(line -> {
                    String[] words = line.split(" ");
                    return words.length > wordIndex ? words[wordIndex] : "";
                });
                break;
            default:
                System.out.println("Неизвестный тип сортировки.");
                return;
        }



        Files.write(Paths.get(outputFile), linesWithCounts);

        System.out.println("Файл успешно отсортирован и сохранен в " + outputFile);
    }
}
