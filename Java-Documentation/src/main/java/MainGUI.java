import Model.Transaction;
import Service.Laporan;
import Service.Penjualan;
import Service.Proses;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.SwingConstants.NORTH;

public class MainGUI {
    List<Transaction> transaction = new ArrayList<>();
    Penjualan reader = new Penjualan();
    Proses processor = new Proses();
    Laporan report = new Laporan();

    public void start() {
        JFrame frame = new JFrame("Sales Report");
        frame.setSize(700,500);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout());
        JButton loadButton = new JButton("Load Sales File");
        JButton generateButton = new JButton("Generate Report");
        topPanel.add(loadButton);
        topPanel.add(generateButton);

        String[] columns = new String[]{"ID", "Nama", "Qty", "Price"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0 );
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);



//        JLabel label1 = new JLabel("Satu");
        JLabel label2 = new JLabel("Dua");
        JLabel label3 = new JLabel("Tiga");

//        panel.add(label1, BorderLayout.NORTH);
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(label3, BorderLayout.SOUTH);

        loadButton.addActionListener(e -> {
            List<String> salesData = reader.readFromFile("sales.txt");
            transaction = Proses.parseSalesData(salesData);
            for (Transaction t : transaction) {
                tableModel.addRow(new Object[] {t.getId(), t.getItem(),
                        t.getQuantity(), t.getPrice()});
            }
            int revenue = transaction.stream().mapToInt(
                    t -> (int) ( t.getQuantity() * t.getPrice())).sum();

            label3.setText("Total = " + revenue);
//            for (Transaction t : transaction) {
//                revenue_old += t.getQuantity() * t.getPrice();
//            }
        });

        generateButton.addActionListener(e -> {
            double total = processor.getTotalSales(transaction);

            report.writeReport("report.txt", transaction, total);
        });


        frame.add(panel);

        frame.setVisible(true);
    }

    public static void main(String[] args){
        new MainGUI().start();
    }
}
