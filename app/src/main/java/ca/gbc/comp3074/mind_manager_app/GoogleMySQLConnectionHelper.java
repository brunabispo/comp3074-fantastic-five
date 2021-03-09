package ca.gbc.comp3074.mind_manager_app;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class GoogleMySQLConnectionHelper {

    String username, password, ip, port, database;

    public Connection connectionclass(){
        ip = "34.69.115.126";
        database = "mindmanager";
        username = "root";
        password = "georgebrown";
        port = "3306";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Connection connection = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://34.69.115.126:3306/mindmanager","root","georgebrown");
        }
        catch (Exception exception){
            Log.e("Error ", exception.getMessage());
        }

        return connection;
    }
}