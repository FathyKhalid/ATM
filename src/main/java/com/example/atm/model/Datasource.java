package com.example.atm.model;

import com.example.atm.Controllers.mainController;

import java.sql.*;
import java.time.LocalDate;

public class Datasource {

    public static final String DB_NAME = "Accountant.db";
    public static final  String CONNECTION_STRING = "jdbc:sqlite:F:\\Java\\ATM\\DataBase\\" + DB_NAME;
    public static final String TABLE_ACCOUNTANTS = "accountants";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DATE = "birth_date";
    public static final String COLUMN_POSTAL = "postal_code";
    public static final String COLUMN_CARD_NUM = "card_number";
    public static final String COLUMN_PIN = "pin";
    public static final String COLUMN_BALANCE = "balance";
    public static final int INDEX_ID = 1;
    public static final int INDEX_NAME = 2;
    public static final int INDEX_BIRTH = 3;
    public static final int INDEX_POSTAL = 4;
    public static final int INDEX_CARD = 5;
    public static final int INDEX_PIN = 6;
    public static final int INDEX_BALANCE = 7;


    private static Datasource instance = new Datasource();
    public static Datasource getInstance(){
        return instance;
    }

    private Connection con;
    public Boolean open()
    {
        try {
            con = DriverManager.getConnection(CONNECTION_STRING);
            return true;
        } catch (SQLException e)
        {
            System.out.println("Couldn't connect to the database: " + e.getMessage());
            return false;
        }
    }
    public void close(){
        try {
            if(con != null)
            {
                con.close();
            }
        }catch (SQLException e)
        {
            System.out.println("Couldn't close connection: "+ e.getMessage());
        }
    }
    public void createTable()
    {
        try (Statement statement = con.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_ACCOUNTANTS +" (" + COLUMN_ID +" INTEGER, "
                                    + COLUMN_NAME +" Text, " +COLUMN_DATE +" DATE, "+ COLUMN_POSTAL +" INTEGER, "
                                    + COLUMN_CARD_NUM +" TEXT, " +COLUMN_PIN +" TEXT, " +COLUMN_BALANCE +" DOUBLE)");
        } catch (SQLException e)
        {
            System.out.println("Create table Failed: "+ e.getMessage());
        }

    }
    public int returnIdLast()
    {
        try (Statement statement = con.createStatement()) {
              ResultSet resultSet = statement.executeQuery("SELECT * FROM "+ TABLE_ACCOUNTANTS+" ORDER BY 1 DESC LIMIT 1");
              return resultSet.getInt("id");
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    public double getBalance()
    {
        try (Statement statement = con.createStatement()) {
            statement.execute("SELECT balance FROM "+TABLE_ACCOUNTANTS+" WHERE "+COLUMN_CARD_NUM+" = "+mainController.getCardLoginNum());
            return statement.getResultSet().getDouble("balance");
            //return statement.executeQuery("SELECT "+COLUMN_BALANCE+" FROM "+TABLE_ACCOUNTANTS+" WHERE "+COLUMN_CARD_NUM+" = "+ mainController.getCardLoginNum());
        }catch (SQLException e)
        {
            System.out.println("Can't return Balance: "+ e.getMessage());
            return 0;
        }
    }
    public String getPIN()
    {
        try (Statement statement = con.createStatement()) {
            statement.execute("SELECT * FROM "+TABLE_ACCOUNTANTS+" WHERE "+COLUMN_CARD_NUM+" = "+mainController.getCardLoginNum());
            return statement.getResultSet().getString("pin");
            //return statement.executeQuery("SELECT "+COLUMN_BALANCE+" FROM "+TABLE_ACCOUNTANTS+" WHERE "+COLUMN_CARD_NUM+" = "+ mainController.getCardLoginNum());
        }catch (SQLException e)
        {
            System.out.println("Can't return PIN: "+ e.getMessage());
            return null;
        }
    }
    public void updatePIN(String pinIn)
    {
        try (Statement statement = con.createStatement()){
            statement.execute("UPDATE "+TABLE_ACCOUNTANTS+" SET "+COLUMN_PIN+" = "+pinIn+" WHERE "+COLUMN_CARD_NUM+" ='"+mainController.getCardLoginNum()+"'");
        }catch (SQLException e)
        {
            System.out.println("Can't update PIN: "+ e.getMessage());
        }

    }
    public String find(String number, String pin)
    {
        try (Statement statement = con.createStatement()){
            return statement.executeQuery("SELECT * FROM "+TABLE_ACCOUNTANTS+" WHERE "+COLUMN_CARD_NUM+" ='"+number+"' AND pin='"+pin+"'").getString("name");
        }catch (SQLException e)
        {
            return "";
        }
    }
    public void deleteAcc(String number, String pin)
    {
        try (Statement statement = con.createStatement()){
            statement.execute("DELETE FROM "+TABLE_ACCOUNTANTS+" WHERE "+COLUMN_CARD_NUM+" ='"+number+"' AND pin='"+pin+"'");
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void deposit(double amountIn)
    {
        try (Statement statement = con.createStatement()){
            statement.execute("UPDATE "+TABLE_ACCOUNTANTS+" SET "+COLUMN_BALANCE+" = "+(getBalance()+amountIn)
                                    +" WHERE "+COLUMN_CARD_NUM+" ='"+mainController.getCardLoginNum()+"'");
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public boolean withdraw(double amountIn)
    {
        if(amountIn > getBalance())
            return false;
        try (Statement statement = con.createStatement()){
            statement.execute("UPDATE "+TABLE_ACCOUNTANTS+" SET "+COLUMN_BALANCE+" = "+(getBalance()-amountIn)
                                +" WHERE "+COLUMN_CARD_NUM+" ='"+mainController.getCardLoginNum()+"'");
            return true;
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public String returnCardNum(String cardNumberIn)
    {
        try (Statement statement = con.createStatement()){
            return statement.executeQuery("SELECT * FROM "+TABLE_ACCOUNTANTS+" WHERE "+COLUMN_CARD_NUM+" ='"+cardNumberIn+"'").getString("card_number");
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public void addAcc(int idIn, String fullName, LocalDate dateIn, String postalIn, String creditNumber,String pinIn, double balanceIn)
    {
        try(Statement statement = con.createStatement()){
            statement.execute("INSERT INTO "+TABLE_ACCOUNTANTS+" (id, name, birth_date, postal_code, card_number, pin, balance) VALUES ('"
                    +idIn+"', '"+fullName+"', '"+dateIn+"', '"+postalIn+"', '"+creditNumber+"', '"+pinIn+"', '"+balanceIn+"')");
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
