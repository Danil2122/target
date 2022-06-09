package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TodosTests {
    Todos todos;
    List<String> list;

    @BeforeEach
    void beforeEach() {
        todos = new Todos();
        todos.addTask("Прибраться в ванной");
        todos.addTask("Прибраться в кваритире");
        todos.addTask("Арбитр юд");
        todos.addTask("Готовкой занимается мама");

        list = new ArrayList<>();
        list.add("Арбитр юд");
        list.add("Готовкой занимается мама");
        list.add("Прибраться в ванной");
        list.add("Прибраться в кваритире");
    }

    @Test
    void addTask() {
        list = new ArrayList<>();
        list.add("task 1");
        list.add("task 2");
        list.add("task 3");
        list.add("task 4");

//         String.valueOf(list.stream().sorted().collect(Collectors.toList()));
        String expected = String.valueOf(new ArrayList<String>(list));
        todos = new Todos();
        todos.addTask("task 1");
        todos.addTask("task 4");
        todos.addTask("task 3");
        todos.addTask("task 2");
        String actual = todos.getAllTasks();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void remouveTask() {
        list = new ArrayList<>();
        list.add("Прибраться в ванной");
        list.add("Прибраться в кваритире");
        String expected = String.valueOf(new ArrayList<String>(list));


        todos.removeTask("Арбитр юд");
        todos.removeTask("Готовкой занимается мама");
        String actual = todos.getAllTasks();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getAllTask() {

        String expected = String.valueOf(list.stream().sorted().collect(Collectors.toList()));

        String actual = todos.getAllTasks();

        Assertions.assertEquals(expected, actual);
    }


}

