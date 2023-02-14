package modul10.Task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JsonUser {
    private List<User> users = new ArrayList<>();

    public void usdJasonUser() throws IOException {
        addUsersToList();
        usersListToJson();
    }

    public void addUsersToList() throws IOException {
        InputStream fis = new FileInputStream("/Users/admin/Documents/GoIT/M10/src/main/java/modul10/Task2/file.txt");
        Scanner scanner = new Scanner(fis);
        scanner.nextLine();
        while (scanner.hasNext()) {
            String[] words = scanner.nextLine().split(" ");
            String name = words[0];
            int age = Integer.parseInt(words[1]);
            users.add(new User(name, age));
            fis.close();
        }
    }

    public void usersListToJson() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String toJson = gson.toJson(users);
        System.out.println(toJson);

        FileWriter fileWriter = new FileWriter("users.json");
        gson.toJson(users, fileWriter);
        fileWriter.close();
    }
}

