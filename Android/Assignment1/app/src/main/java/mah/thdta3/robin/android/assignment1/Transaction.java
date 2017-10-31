package mah.thdta3.robin.android.assignment1;

/**
 * Created by robin on 19/09/2017.
 */

public class Transaction {

    private String title, amount, category, date, username;
    private int id,type;

    public Transaction(String title, String amount, String category, String date, String username, int type){
        id = 0;
        this.title = title;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.username = username;
        this.type = type;
    }

    public Transaction(int id, String title, String amount, String category, String date, String username,int type){
        this. id = id;
        this.title = title;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.username = username;
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {

        return title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
