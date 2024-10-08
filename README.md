# TextSorter

`TextSorter` — это консольное Java-приложение для сортировки строк текста в файле по различным критериям. Программа читает строки из входного файла, сортирует их по выбранному критерию, добавляет количество повторений каждой строки и сохраняет результат в выходной файл.

## Особенности

- **Три типа сортировки:**
  1. По алфавиту.
  2. По количеству символов в строке.
  3. По определенному слову в строке (сортировка по порядковому номеру слова).
- **Подсчет повторений:** Каждая строка дополняется количеством её повторений в исходном файле.
- **Автоматическое использование файлов:** 
  - Входной файл: `src/main/java/file.txt`
  - Выходной файл: `src/main/java/out.txt`

## Как использовать

1. Убедитесь, что у вас есть Java 8 или более поздней версии.
2. Создайте необходимые файлы:
   - `input.txt` в директории `src/main/java/` с текстом, который вы хотите отсортировать.
   - `output.txt` в той же директории, куда будет записан результат.
3. Запустите программу:

