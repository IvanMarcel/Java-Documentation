package View;

import controller.SalesController;

import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
public class Main {
    private SalesController controller;

    public Main() {
        this.controller = new SalesController();
    }

    public void start() {
        if (controller.loadSalesFile("C:\\GitHub\\Java-Documentation\\Java-DocumentationSales\\src\\sales.txt"))
        {
            controller.generateReport("report.txt");
        }

    }

    public static void main(String[] args) throws IOException {
        new Main().start();
    }
}