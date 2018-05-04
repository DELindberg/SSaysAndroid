package com.example.tec_programmoer.simonsaysapp;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionClass extends AsyncTask<String, String, ResultSet>{

    //Formulate connection string components
    String ip = "simonsaysdb.cvw0h6il9krp.eu-central-1.rds.amazonaws.com";
    String classs = "net.sourceforge.jtds.jdbc.Driver";
    String dbName = "SimonsaysDB";
    String userName = "tecskp1";
    String password = "1totrefire5";


    @Override
    protected ResultSet doInBackground(String... strings) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
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
            Log.e ("ERROR", se.getMessage());
        }catch (ClassNotFoundException e) {
            Log.e("ERROR", e.getMessage());
        } catch (Exception e) {
            Log.e("ERROR", e.getMessage());
        }

        try {
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(strings[0]);

            while(result.next())//Iterate through the result from the query
            {
                //TODO: Update the view with the results found from the query
                String tempResult = result.getString(1);
                Log.d("Some tag:", tempResult);//Test statement, prints result to log
            }

            statement.close();
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(ResultSet result){
        //TODO: Get reference to view and post result in view.
    }
}