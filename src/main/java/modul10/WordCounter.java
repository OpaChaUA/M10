package modul10;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
 class WordCounter {

    public void counter() {
        int deftRepeat = 1;

        Map<String, Integer> wordsRepeat = new HashMap<>();
        try (InputStream fis = new FileInputStream("src/main/java/modul10/words.txt");
             Scanner scanner = new Scanner(fis)) {
            while (scanner.hasNext()) {
                String wordLine = scanner.nextLine();
                String[] spWordLine = wordLine.split(" ");
                for (String words : spWordLine) {
                    if (wordsRepeat.containsKey(words)) {
                        wordsRepeat.put(words, wordsRepeat.get(words) + 1);
                    } else {
                        wordsRepeat.put(words, deftRepeat);
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return wordsRepeat.get(o1).compareTo(wordsRepeat.get(o2)) > 0 ? 1:-1;
            }
        };
        Map<String, Integer> result = new TreeMap<>(comparator.reversed());
        result.putAll(wordsRepeat);
        System.out.println(result);

    }
}


