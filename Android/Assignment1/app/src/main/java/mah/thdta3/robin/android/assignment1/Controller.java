package mah.thdta3.robin.android.assignment1;


import android.app.DownloadManager;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by robin on 17/09/2017.
 */

public class Controller {
    private TransactionAddFragment transaddFragment;
    private TransactionHistoryFragment transactionHistoryFragment;
    private MenuFragment menuFragment;
    private MainActivity mainActivity;
    private LoginActivity loginActivity;
    private LoginFragment loginFragment;
    private SignupFragment signupFragment;
    private SQLiteDatabase db;
    private UserDBHelper userdb;
    private TransactionDBHelper transactiondb;
    private User currentUser;
    private Resources res;
    private DetailedFragment detailFragment;

    private int saveCurrentFragment;

    private int currentFragment = 0;
    private boolean customSearched = false;
    private String[] thTitle, detailInfo;
    private String[] thAddTitle;
    private int[] thAddCateory;
    private ArrayList<Transaction> allTransactions, typeTransactions, custom;
    private String[] addFields, loginFields, signFields;
    private boolean flag = false;

    //Used in the login/signup-proccess
    public Controller(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
        this.loginFragment = new LoginFragment();
        this.signupFragment = new SignupFragment();

        userdb = new UserDBHelper(loginActivity);

        loginFragment.setController(this);
        signupFragment.setController(this);


        loginActivity.setFragment(loginFragment,false);
    }

    //Used for the rest of the program
    public Controller(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.menuFragment = new MenuFragment();
        this.transactionHistoryFragment = new TransactionHistoryFragment();
        this.transaddFragment = new TransactionAddFragment();
        this.detailFragment = new DetailedFragment();

        menuFragment.setController(this);
        transactionHistoryFragment.setController(this);
        transaddFragment.setController(this);
        detailFragment.setController(this);

        transactiondb = new TransactionDBHelper(mainActivity);

        mainActivity.setFragment(menuFragment,false);
        initializeResources();
    }

    private void initializeResources() {
        res = mainActivity.getResources();
        thTitle = new String[]{res.getString(R.string.title_income),res.getString(R.string.title_ependiture)};
        thAddTitle = new String[]{res.getString(R.string.add_income),res.getString(R.string.add_expenditure)};
        thAddCateory = new int[]{R.array.types_income,R.array.types_expenditure};

    }

    public Bundle saveBundle(Bundle outState) {

        outState.putInt("currentFragment", saveCurrentFragment);
        switch (saveCurrentFragment){
            case 0:
                outState.putInt("addCurrent",currentFragment);
                outState.putParcelable("currentUser", currentUser);
                break;
            case 1:
                outState.putInt("addCurrent",currentFragment);
                outState.putParcelable("currentUser", currentUser);
                break;
            case 2:
                outState.putInt("addCurrent",currentFragment);
                outState.putParcelable("currentUser", currentUser);
                outState.putString("addDate", transaddFragment.getDate());
                outState.putString("addTitle", transaddFragment.getTitle());
                outState.putString("addAmount", transaddFragment.getAmount());
                outState.putString("addCategory",String.valueOf(transaddFragment.getSelCat()));
                break;
            case 3:
                outState.putInt("addCurrent",currentFragment);
                outState.putParcelable("currentUser", currentUser);
                break;
            case 4:
                outState.putString("username", loginFragment.getUsername());
                outState.putString("password",loginFragment.getPassword());
                break;
            case 5:
                outState.putString("username", signupFragment.getUsername());
                outState.putString("password",signupFragment.getPassword());
                outState.putString("firstname", signupFragment.getFirstname());
                outState.putString("surname",signupFragment.getPassword());
                break;
            case 6:
                outState.putInt("addCurrent",currentFragment);
                outState.putParcelable("currentUser", currentUser);
                outState.putString("detailTitle",detailFragment.getDetailTitle());
                outState.putString("detailType",detailFragment.getDetailType());
                outState.putString("detailAmount",detailFragment.getDetailAmount().substring(0,detailFragment.getDetailAmount().indexOf(" ")));
                outState.putString("detailDate",detailFragment.getDetailDate());
                outState.putString("detailCategory",detailFragment.getDetailCatergory());
                break;
        }

        return outState;
    }

    public void restoreBundle(Bundle savedInstanceState) {

        currentUser = savedInstanceState.getParcelable("currentUser");
        saveCurrentFragment = savedInstanceState.getInt("currentFragment");

        currentFragment = savedInstanceState.getInt("addCurrent");
        switch (saveCurrentFragment){
            case 0:
                getTransactions();
                currentFragment = 0;
                mainActivity.setFragment(transactionHistoryFragment,true);
                break;
            case 1:
                getTransactions();
                currentFragment = 1;
                mainActivity.setFragment(transactionHistoryFragment,true);
                break;
            case 2:
                getTransactions();
                flag = true;
                addFields = new String[]{
                        savedInstanceState.getString("addDate"),
                        savedInstanceState.getString("addTitle"),
                        savedInstanceState.getString("addAmount"),
                        savedInstanceState.getString("addCategory")};
                mainActivity.setFragment(transaddFragment,true);
                break;
            case 3:
                getTransactions();
                mainActivity.setFragment(menuFragment,true);
                break;
            case 4:
                flag = true;
                loginFields = new String[]{
                        savedInstanceState.getString("username"),
                        savedInstanceState.getString("password")
                };
                loginActivity.setFragment(loginFragment,true);
                break;
            case 5:
                flag = true;
                signFields = new String[]{
                        savedInstanceState.getString("username"),
                        savedInstanceState.getString("password"),
                        savedInstanceState.getString("firstname"),
                        savedInstanceState.getString("surname")
                };
                loginActivity.setFragment(signupFragment,true);
                break;
            case 6:
                Log.e("HEY","I WENT HERE!");
                detailInfo = new String[]{
                        savedInstanceState.getString("detailTitle"),
                        savedInstanceState.getString("detailType"),
                        savedInstanceState.getString("detailAmount"),
                        savedInstanceState.getString("detailDate"),
                        savedInstanceState.getString("detailCategory")
                };
                Log.e("test", ""+detailInfo[1]);
                mainActivity.setFragment(detailFragment,true);
                break;
        }
    }

    public boolean checkFlag(){
        return flag;
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------
    //Fragment change methods, gonna condense to a single method most likely
    public void goToSignup() {
        saveCurrentFragment = 5;
        loginActivity.setFragment(signupFragment,true);

    }

    public void goToExpenditure(){
        saveCurrentFragment = 1;
        currentFragment = 1;
        mainActivity.setFragment(transactionHistoryFragment, true);
    }

    public void goToIncome() {
        saveCurrentFragment = 0;
        currentFragment = 0;
        mainActivity.setFragment(transactionHistoryFragment,true);
    }

    public void goToAddTransaction() {
        saveCurrentFragment = 2;
        mainActivity.setFragment(transaddFragment,true);
        //mainActivity.removeFragment(transactionHistoryFragment);
    }

    public void returnToLast() {
        switch (currentFragment){
            case 0:
                mainActivity.setFragment(transactionHistoryFragment,true);
                getTransactions();
                break;
            case 1:
                mainActivity.setFragment(transactionHistoryFragment,true);
                getTransactions();
                break;
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------
    //Methods used by the loginActivity, that is for the login and signup

    public void setLogin() {
        saveCurrentFragment = 4;
    }

    public String createUser() {
        if(signupFragment.getUsername().toString().equals("") || signupFragment.getPassword().toString().equals("")
                || signupFragment.getFirstname().toString().equals("") || signupFragment.getSurname().toString().equals("")){
            return "error, one or more fields are empty";
        }
        User user = new User( signupFragment.getFirstname().toString(), signupFragment.getSurname().toString(), signupFragment.getUsername().toString(), signupFragment.getPassword().toString());
        addUser(user);
        return "success";
    }

    public boolean login() {
        User user = loginUser(loginFragment.getUsername().toString(),loginFragment.getPassword().toString());
        if (user != null) {
            currentUser = user;
            return true;
        }
        else return false;
    }

    private void addUser(User user) {
        db = userdb.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(UserDBHelper.COLUMN_USERNAME, user.getUsername());
        values.put(UserDBHelper.COLUMN_NAME,user.getFirstname());
        values.put(UserDBHelper.COLUMN_SURNAME, user.getSurname());
        values.put(UserDBHelper.COLUMN_PASSWORD, user.getPassword());
        db.insert(UserDBHelper.TABLE_NAME,"",values);
    }

    private User loginUser(String username, String password){
        db = userdb.getWritableDatabase();
        int idIndex, usernameIndex, firstnameIndex,surnameIndex, passwordIndex;
        String query = "SELECT * FROM " + userdb.TABLE_NAME + " WHERE " + userdb.COLUMN_USERNAME + "= ?" + " AND " + userdb.COLUMN_PASSWORD + " = ?";

        Cursor c = db.rawQuery(query,new String[]{username,password});

        idIndex = c.getColumnIndex(userdb.COLUMN_ID);
        usernameIndex = c.getColumnIndex(userdb.COLUMN_USERNAME);
        firstnameIndex = c.getColumnIndex(userdb.COLUMN_NAME);
        surnameIndex = c.getColumnIndex(userdb.COLUMN_SURNAME);
        passwordIndex = c.getColumnIndex(userdb.COLUMN_PASSWORD);

        User user;
        if (c != null && c.moveToFirst()){
            c.moveToFirst();
            user = new User(c.getInt(idIndex),c.getString(firstnameIndex), c.getString(surnameIndex), c.getString(usernameIndex), c.getString(passwordIndex));
            c.close();
        }else{
            user = null;
        }
        return user;
    }

    public void startMainActivity(){
        loginActivity.startIntent(currentUser);
    }



    public void createUser(Intent intent) {
        currentUser = intent.getExtras().getParcelable("currentUser");
    }

    public void restoreLogin(){

        loginFragment.setPassword(loginFields[1]);
        loginFragment.setUsername(loginFields[0]);
        flag = false;
    }
    public void restoreSignup(){
        signupFragment.setUsename(signFields[0]);
        signupFragment.setPassword(signFields[1]);
        signupFragment.setFirstname(signFields[2]);
        signupFragment.setSurname(signFields[3]);
        flag = false;
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------
    //Methods used by the mainActivity


    public void updateUserName(){
        saveCurrentFragment = 3;
        menuFragment.setMenuTitle("" + currentUser.getFirstname() + " " + currentUser.getSurname());
    }

    public String createTransaction(){
        if (transaddFragment.getAmount().equals("") || transaddFragment.getCategory().equals("") || transaddFragment.getDate().equals("") || transaddFragment.getTitle().equals("")){
            return "Error, fields not properly filled";
        }
        Transaction trans = new Transaction(
                transaddFragment.getTitle().toString(),
                transaddFragment.getAmount().toString(),
                transaddFragment.getCategory().toString(),
                transaddFragment.getDate().toString(),
                currentUser.getUsername().toString(),
                currentFragment);
        addTransaction(trans);
        return "Success";
    }

    public void clearAdd() {
        transaddFragment.setAddTitle("");
        transaddFragment.setAddAmount("");
        transaddFragment.setAddDate("");
    }

    public void addTransaction(Transaction trans) {
        db = transactiondb.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(TransactionDBHelper.COLUMN_TYPE, currentFragment);
        values.put(TransactionDBHelper.COLUMN_TITLE, trans.getTitle());
        values.put(TransactionDBHelper.COLUMN_AMOUNT, trans.getAmount());
        values.put(TransactionDBHelper.COLUMN_CATEGORY, trans.getCategory());
        values.put(TransactionDBHelper.COLUMN_DATE, trans.getDate());
        values.put(TransactionDBHelper.COLUMN_USERNAME, trans.getUsername());
        db.insert(TransactionDBHelper.TABLE_NAME,"",values);

    }


    public void updateBalance() {
        int in = 0;
        int out = 0;
        int balance = 0;
        for (int j = 0; j < allTransactions.size(); j++) {
            if (allTransactions.get(j).getType()==0){
                in+=Integer.parseInt(allTransactions.get(j).getAmount());
            }else{
                out+=Integer.parseInt(allTransactions.get(j).getAmount());
            }
        }
        balance = in - out;
        menuFragment.setBalance(balance);
    }

    public void updateTHTitle(){
        saveCurrentFragment = currentFragment;
        transactionHistoryFragment.setTitle(thTitle[currentFragment]);
    }

    public void updateAddTitle(){
        transaddFragment.setOverTitle(thAddTitle[currentFragment]);
    }

    public void updateAddSpinner() {
        transaddFragment.setSpinner(thAddCateory[currentFragment]);
    }


    public void getTransactions() {
        db = transactiondb.getWritableDatabase();
        //transactiondb.onCreate(db);
        int idIndex,usernameIndex, titleIndex, amountIndex, categoryIndex, dateIndex, typeIndex;

        String query = "SELECT * FROM " + transactiondb.TABLE_NAME + " WHERE " + transactiondb.COLUMN_USERNAME + " = ?";

        Cursor c = db.rawQuery(query,new String[]{currentUser.getUsername().toString()});
        ArrayList<Transaction> trans = new ArrayList<>();

        idIndex = c.getColumnIndex(transactiondb.COLUMN_ID);
        usernameIndex = c.getColumnIndex(transactiondb.COLUMN_USERNAME);
        titleIndex = c.getColumnIndex(transactiondb.COLUMN_TITLE);
        amountIndex = c.getColumnIndex(transactiondb.COLUMN_AMOUNT);
        categoryIndex = c.getColumnIndex(transactiondb.COLUMN_CATEGORY);
        dateIndex = c.getColumnIndex(transactiondb.COLUMN_DATE);
        typeIndex = c.getColumnIndex(transactiondb.COLUMN_TYPE);

        if(c != null && c.moveToFirst()){
            c.moveToFirst();
            do {
                trans.add(new Transaction(
                        c.getInt(idIndex),
                        c.getString(titleIndex),
                        c.getString(amountIndex),
                        c.getString(categoryIndex),
                        c.getString(dateIndex),
                        c.getString(usernameIndex),
                        c.getInt(typeIndex)));
            } while (c.moveToNext());
        }
        allTransactions = trans;
    }

    public ArrayList<Transaction> fetchTransactions() {
        typeTransactions = new ArrayList<>();
        for (int i = 0; i < allTransactions.size(); i++) {
            if(allTransactions.get(i).getType()==currentFragment){
                typeTransactions.add(allTransactions.get(i));
            }
        }
        return typeTransactions;
    }

    public void updateAddFields() {
        transaddFragment.setAddDate(addFields[0]);
        transaddFragment.setAddTitle(addFields[1]);
        transaddFragment.setAddAmount(addFields[2]);
        transaddFragment.setAddCategory(Integer.parseInt(addFields[3]));
        flag=false;
    }

    public void customSearch() {
        String from, to;
        int idIndex,usernameIndex, titleIndex, amountIndex, categoryIndex, dateIndex, typeIndex;
        db = transactiondb.getWritableDatabase();
        from = transactionHistoryFragment.getFrom();
        to = transactionHistoryFragment.getTo();

            Cursor c = db.rawQuery("SELECT * FROM " + transactiondb.TABLE_NAME + " WHERE " + transactiondb.COLUMN_USERNAME + " = ? " + " AND " + transactiondb.COLUMN_TYPE + " = " + currentFragment
                    + " AND " + transactiondb.COLUMN_DATE + " BETWEEN" + " ? " + " AND " + " ? " , new String[]{currentUser.getUsername(), from, to});

        idIndex = c.getColumnIndex(transactiondb.COLUMN_ID);
        usernameIndex = c.getColumnIndex(transactiondb.COLUMN_USERNAME);
        titleIndex = c.getColumnIndex(transactiondb.COLUMN_TITLE);
        amountIndex = c.getColumnIndex(transactiondb.COLUMN_AMOUNT);
        categoryIndex = c.getColumnIndex(transactiondb.COLUMN_CATEGORY);
        dateIndex = c.getColumnIndex(transactiondb.COLUMN_DATE);
        typeIndex = c.getColumnIndex(transactiondb.COLUMN_TYPE);

        custom = new ArrayList<>();
        if(c != null && c.moveToFirst()){
            c.moveToFirst();
            do {
                custom.add(new Transaction(
                        c.getInt(idIndex),
                        c.getString(titleIndex),
                        c.getString(amountIndex),
                        c.getString(categoryIndex),
                        c.getString(dateIndex),
                        c.getString(usernameIndex),
                        c.getInt(typeIndex)));
            } while (c.moveToNext());
        }
        transactionHistoryFragment.updateList(custom);
    }

    public void showDetailedInformation(int position) {
        if (customSearched){
            detailInfo = new String[]{
                    custom.get(position).getTitle(),
                    String.valueOf(custom.get(position).getType()),
                    custom.get(position).getAmount(),
                    custom.get(position).getDate(),
                    custom.get(position).getCategory()};
        }else {
            detailInfo = new String[]{
                    typeTransactions.get(position).getTitle(),
                    String.valueOf(typeTransactions.get(position).getType()),
                    typeTransactions.get(position).getAmount(),
                    typeTransactions.get(position).getDate(),
                    typeTransactions.get(position).getCategory()};
        }
        mainActivity.setFragment(detailFragment,true);
        saveCurrentFragment = 6;
    }

    public void updateDetailFields() {
        detailFragment.setDetailTitle(detailInfo[0]);

        Log.e("gaw","" + detailInfo[1]);
        if (detailInfo[1].equals("0")||detailInfo[1].equals("Income")){
            detailFragment.setDetailType("Income");
        }else {detailFragment.setDetailType("Expenditure");}
        detailFragment.setDetailAmount(detailInfo[2] + " kr");
        detailFragment.setDetailDate(detailInfo[3]);
        detailFragment.setDetailCatergory(detailInfo[4]);
    }
}
