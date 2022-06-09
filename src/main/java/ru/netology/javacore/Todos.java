package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    public String type;
    public String task;

    List<String> lis = new ArrayList<>();

    public void addTask(String task) {
        lis.add(task);
    }

    public void removeTask(String task) {
        lis.remove(task);
    }

    public String getAllTasks() {
        return String.valueOf(lis.stream().sorted().collect(Collectors.toList()));
    }

}
