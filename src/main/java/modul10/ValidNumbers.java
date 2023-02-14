package modul10;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ValidNumbers {
    public void checkNumbers() {
        File file = new File("src/main/java/modul10/numbers.txt");
        if (file.exists()) {
            try (InputStream fis = new FileInputStream(file);
                 Scanner scaner = new Scanner(fis)) {
                String result = null;
                while (scaner.hasNext()) {
                    result = scaner.nextLine();
                    if (result.matches("(\\(\\d{3}\\) |\\d{3}-)\\d{3}-\\d{4}")) {
                        System.out.println(result);
                    }

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
