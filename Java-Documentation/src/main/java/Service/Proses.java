package Service;

import Model.Transaction;
import java.util.*;

public class Proses {

    public static List<Transaction> parseSalesData(List<String> data) {
        List<Transaction> trx = new ArrayList<>();

        for (String line : data) {
            if (line.startsWith("#") || line.trim().isEmpty())
                continue; // skip header

            String[] parts = line.split(",");

            int id = Integer.parseInt(parts[0].trim());
            String item = parts[1].trim();
            int qty = Integer.parseInt(parts[2].trim());
            double price = Double.parseDouble(parts[3].trim());

            trx.add(new Transaction(id, item, qty, price));
        }

        return trx;
    }

    public static double getTotalSales(List<Transaction> trx) {
        double total = 0;

        for (Transaction t : trx) {
            total += t.getTotal();
        }

        return total;
    }
}