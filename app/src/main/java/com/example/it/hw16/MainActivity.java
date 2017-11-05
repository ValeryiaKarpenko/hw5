package com.example.it.hw16;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private ServletConfig servletConfig=new ServletConfig();
    private int versionFromServlet =2;
    private boolean forse_update=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkVersion();
    }

    public void getConfigInfo(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                versionFromServlet =Integer.valueOf(servletConfig.getConfigVersion());
                forse_update=Boolean.valueOf(servletConfig.getForseUpdate());
            }
        }).start();
    }

    public void showAlertDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Info");
        builder.setMessage("New versionFromServlet is available");
        builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"Go to Goodle Play",Toast.LENGTH_SHORT).show();
                if (forse_update)
                    finish();

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (forse_update){
                    finish();
                }
                else {dialogInterface.cancel();}
            }
        });
        if (forse_update) {
            builder.setCancelable(false);
        }
        else{
            builder.setCancelable(true);
        }

        builder.show();
    }

    public void checkVersion(){
        if(BuildConfig.VERSION_CODE<versionFromServlet){
            showAlertDialog();
        }
    }
}