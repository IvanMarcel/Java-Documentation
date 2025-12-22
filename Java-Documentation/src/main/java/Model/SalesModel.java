package Model;

import java.util.ArrayList;
import java.util.List;

public class SalesModel {
    private List<Transaction> transaction;

    public SalesModel(){
        this.transaction = new ArrayList<>();
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }

    public List <Transaction> getTransaction(){
        return new ArrayList<>(transaction);
    }

    public int calculateGrandTotal(){
        return transaction.stream().mapToInt(Transaction::getTotal).sum();
    }

    public int getTransactionCount(){
        return transaction.size();
    }
 }
