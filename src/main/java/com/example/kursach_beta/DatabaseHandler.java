package com.example.kursach_beta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);

        return dbConnection;
    }

    public void zapisSeans(String id_seans, String data_seans, String time_seans, String id_usluga,
                           String id_client, String id_rabotnik, String id_pc){

        String insert = "INSERT INTO" + ConstSeans.SEANS_TABLE + "(" + ConstSeans.SEANS_ID + "," +
                ConstSeans.SEANS_DATA + "," + ConstSeans.SEANS_TIME + "," + ConstSeans.SEANS_USLUGA +
                "," + ConstSeans.SEANS_CLIENT + "," + ConstSeans.SEANS_RAB + "," + ConstSeans.SEANS_PC +
                ")" + "VALUES(?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, id_seans);
            prSt.setString(2, data_seans);
            prSt.setString(3, time_seans);
            prSt.setString(4, id_usluga);
            prSt.setString(5, id_client);
            prSt.setString(6, id_rabotnik);
            prSt.setString(7, id_pc);

            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void zapisZal(String id_zala, String name_zala, String id_rabotnik){

        String insert = "INSERT INTO" + ConstZal.ZAL_TABLE + "(" + ConstZal.ZAL_ID + "," + ConstZal.ZAL_NAME +
                "," + ConstZal.ZAL_RABOTNIK + ")" + "VALUES(?, ?, ?)";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, id_zala);
            prSt.setString(2, name_zala);
            prSt.setString(3, id_rabotnik);

            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void zapisUslug(String id_usluga, String name_uslugi, String cost_minut){

        String insert = "INSERT INTO" + ConstUsluga.USLUGI_TABLE + "(" + ConstUsluga.USLUGI_ID +
                "," + ConstUsluga.USLUGI_NAME + "," + ConstUsluga.USLUGI_COST + ")" +
                "VALUES(?, ?, ?)";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, id_usluga);
            prSt.setString(2, name_uslugi);
            prSt.setString(3, cost_minut);

            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void zapisComp(String id_pc, String character_pc, String id_zala) {

        String insert = "INSERT INTO" + ConstPC.PC_TABLE + "," + ConstPC.PC_ID + "," + ConstPC.PC_CHARACTER +
                "," + ConstPC.PC_ZAL + ")" + "VALUES(?, ?, ?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, id_pc);
            prSt.setString(2, character_pc);
            prSt.setString(3, id_zala);

            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void zapisRab(String id_rabotnik, String surname, String name, String address, String phone){
        String insert = "INSERT INTO" + ConstRab.RAB_TABLE + "(" + ConstRab.RAB_ID + "," + ConstRab.RAB_SURNAME + ","
                + ConstRab.RAB_NAME + "," + ConstRab.RAB_ADDRESS + "," + ConstRab.RAB_PHONE + ")"+
                "VALUES(?, ?, ?, ?, ?)";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, id_rabotnik);
            prSt.setString(2, surname);
            prSt.setString(3, name);
            prSt.setString(4, address);
            prSt.setString(5, phone);

            prSt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();

        }
    }

    public void zapisClient(String id_client, String surname, String name, String address){

        String insert = "INSERT INTO " + Const.CLIENT_TABLE + "(" + Const.CLIENT_ID + "," + Const.CLIENT_SURNAME +
                "," + Const.CLIENT_NAME + "," + Const.CLIENT_ADDRESS + ")" +
                "VALUES(?, ?, ?, ?)";
        try {
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, id_client);
        prSt.setString(2, surname);
        prSt.setString(3, name);
        prSt.setString(4, address);

            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void zapRab(String text, String text1, String text2, String text3, String text4) {
    }
}
