import Service.*;
import Model.Transaction;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> salesData = Penjualan.readFromFile("sales.txt");

        List<Transaction> transactionData = Proses.parseSalesData(salesData);

        double total = Proses.getTotalSales(transactionData);

        Laporan.writeReport("report.txt", transactionData, total);

        System.out.println("Laporan berhasil dibuat, Cek report.txt");

        for(String data : salesData) {
            System.out.println(data);
        }
    }
}