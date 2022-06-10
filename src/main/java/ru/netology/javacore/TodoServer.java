package ru.netology.javacore;

import com.google.gson.*;

import java.io.*;
import java.lang.reflect.Type;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class TodoServer {


    public TodoServer(int port, Todos todos) throws IOException {
        while (true) {
            try (
                    ServerSocket serverSocket = new ServerSocket(port);
                    Socket clientSocket = serverSocket.accept(); // ждем подключения
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            ) {

                String json = in.readLine();

                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                todos = gson.fromJson(json, Todos.class);
                if (todos.type.equals("ADD")) {
                    todos.addTask(todos.task);
                } else {
                    todos.removeTask(todos.task);
                }

                out.println(todos.getAllTasks());
            }
        }
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + "port...");
    }
//    public String ParseJson(String json){
//        String as = ("{ \"type\": \"ADD\", \"task\": \"task # \" }");
//
//        JsonParser jsonParser = new JsonParser();
//        Object obj = jsonParser.parse(as);
//        JsonObject jsonObject = (JsonObject) obj;
//
////        String type = (String) jsonObject.get("type");
//
////        JsonArray jsonArray = (JsonArray) jsonParser.parse(json);
//
//        GsonBuilder gsonBuilder = new GsonBuilder();
//        Gson gson = gsonBuilder.create();
//        String todos = gson.fromJson(json, todos);
//
//    }
}
