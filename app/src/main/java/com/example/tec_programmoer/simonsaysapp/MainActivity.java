package com.example.tec_programmoer.simonsaysapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new ConnectionClass().execute("select * from strings;");
        /*//ConnectionClass john = new ConnectionClass();
        //john.queryToDatabase("select * from strings;");



        String ip = "simonsaysdb.cvw0h6il9krp.eu-central-1.rds.amazonaws.com";
        String classs = "net.sourceforge.jtds.jdbc.Driver";
        String dbName = "SimonssaysDB";
        String userName = "tecskp1";
        String password = "1totrefire5";
        Connection conn = null;
        String ConnURL;



        try {
            Class.forName(classs);
            ConnURL = "jdbc:jtds:sqlServer://" + ip + ";"
                    + "databaseName=" + dbName
                    + ";user=" + userName
                    + ";password=" + password + ";";
            conn = DriverManager.getConnection(ConnURL);
        }catch (SQLException se) {
            Log.e (" testestERROR", se.getMessage());
        }catch (ClassNotFoundException e) {
            Log.e("ClassNotFoundERROR", e.getMessage());
        } //catch (Exception e) {
            //Log.e("ERROR", e.getMessage());
       // }

        try {
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("select * from strings;");

            while(result.next())//Iterate through the result from the query
            {
                //TODO: Update the view with the results found from the query
                String tempResult = result.getString(1);
                Log.d("result", tempResult);//Test statement, prints result to log
            }

            statement.close();
            result.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
}
