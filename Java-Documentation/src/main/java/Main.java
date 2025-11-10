import Service.*;
import Model.Transaction;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> data = Penjualan.readFromFile("sales.txt");

        List<Transaction> trx = Proses.parseSalesData(data);

        double total = Proses.getTotalSales(trx);

        Laporan.writeReport("report.txt", total);

        System.out.println("Laporan berhasil dibuat!");

        for(String dataSales: data){
            System.out.println(dataSales);
        }
    }
}