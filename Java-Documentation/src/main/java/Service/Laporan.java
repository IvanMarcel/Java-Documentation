package Service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Laporan {

    public static void writeReport(String filename, double totalSales) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try (FileWriter fw = new FileWriter(filename)) {
            fw.write("Sales Report\n");
            fw.write("Generated at: " + now.format(fmt) + "\n");
            fw.write("Total Sales: Rp " + totalSales + "\n");
        } catch (IOException e) {
            System.out.println("Gagal menulis laporan: " + e.getMessage());
        }
    }
}