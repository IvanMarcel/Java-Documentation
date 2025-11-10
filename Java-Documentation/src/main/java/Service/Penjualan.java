package Service;

import java.io.*;
import java.util.*;

public class Penjualan {

    public static List<String> readFromFile(String filename) {
        List<String> output = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                output.add(line);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca file: " + e.getMessage());
        }

        return output;
    }
}