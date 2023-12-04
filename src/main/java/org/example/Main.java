package org.example;

import org.example.entity.TableState;
import org.example.httpClient.HttpClient;
import org.example.panel.Login;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        HttpClient httpClient = new HttpClient();
        List<TableState> tableStates = httpClient.getTableStates(1, "sdfsdf");
        Login login = new Login();
    }

}