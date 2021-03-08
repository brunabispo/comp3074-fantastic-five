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
        String connectionURL = null;

        try{
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            connectionURL = "jdbc:jtds:sqlserver://" + ip + ":" + port + ";databasename=" + database
                    + ";user=" + username + ";password=" + password + ";";
            connection = DriverManager.getConnection(connectionURL);
        }
        catch (Exception exception){
            Log.e("Error ", exception.getMessage());
        }

        return connection;
    }
}