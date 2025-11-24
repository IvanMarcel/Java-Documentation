package Service;

import Model.Transaction;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Laporan   {

    public static void writeReport(String filename, List<Transaction> transactions, double totalSales) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write("Sales Report");
            bw.newLine();
            bw.write("Generated at: " + now.format(fmt));
            bw.newLine();
            bw.write("------------------------------");
            bw.newLine();

            bw.write(String.format("%-8s %-20s %-8s %-15s %-15s",
                    "ID", "Item", "Qty", "Price", "Total"));
            bw.newLine();
            bw.write("--------------------------------------------------------------------------------");
            bw.newLine();

            for (Transaction t : transactions) {
                bw.write(String.format("%-8s %-20s %-8d %-15s %-15s",
                        String.format("%03d", t.getId()),
                        t.getItem(),
                        t.getQuantity(),
                        t.getPrice(),
                        t.getTotal()
                ));
                bw.newLine();
            }

            bw.write("--------------------------------------------------------------------------------");
            bw.newLine();
            bw.write("Total Sales: Rp  " + totalSales);
            bw.newLine();
            bw.write("------------------------------");
            bw.newLine();

        } catch (IOException e) {
            System.out.println("Gagal menulis laporan: " + e.getMessage());
        }
    }
}