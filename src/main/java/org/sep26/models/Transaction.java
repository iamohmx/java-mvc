package org.sep26.models;

import java.sql.Date;

public class Transaction {
    private int goods_id, quantity, amount;
    private double price;
    private Date date;

    public Transaction(int goods_id, Date date, int quantity, int amount, double price) {
//        this.trans_id = trans_id;
        this.goods_id = goods_id;
        this.date = date;
        this.quantity = quantity;
        this.amount = amount;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                ", goods_id=" + goods_id +
                ", date=" + date +
                ", quantity=" + quantity +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }


}
