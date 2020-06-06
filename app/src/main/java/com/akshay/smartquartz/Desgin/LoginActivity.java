package com.akshay.smartquartz.Desgin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.akshay.smartquartz.API.ApiClient;
import com.akshay.smartquartz.API.ApiInterface;
import com.akshay.smartquartz.Bean.Bean_pass;
import com.akshay.smartquartz.Bean.Datum;
import com.akshay.smartquartz.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail;
    EditText etPass;
    String password;
    String email;
    Button btnSignIn;
    String APIPass="";
    Button btnSkip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail=(EditText)findViewById(R.id.login_screen_email);
        etPass=(EditText)findViewById(R.id.login_screen_pass);
        btnSignIn=(Button)findViewById(R.id.login_screen_SignIn);
        btnSkip=(Button)findViewById(R.id.login_screen_skip);


        email=etEmail.getText().toString();
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Bean_pass> call = apiService.getPassword();
        call.enqueue(new Callback<Bean_pass>() {

            @Override
            public void onResponse(Call<Bean_pass> call, retrofit2.Response<Bean_pass> response) {
                List<Datum> category = response.body().getData();

                 APIPass=category.get(0).getPassword();
          //     Toast.makeText(LoginActivity.this, ""+APIPass, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Bean_pass> call, Throwable t) {
              //  Toast.makeText(LoginActivity.this, "d - " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Toast.makeText(LoginActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
                Log.d("Error",t.getMessage());

                // Log error here since request failed
                 Log.e("Error", t.toString());
                 
            }


        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValidate()) {
                    password = etPass.getText().toString();
                    if (password.equals(APIPass)) {
                        Intent in = new Intent(LoginActivity.this, DashboardActivity.class);
                        startActivity(in);
                    } else {
                        Toast.makeText(LoginActivity.this, "Incorrect Password!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(LoginActivity.this,DashboardActivity.class);
                startActivity(in);
            }
        });
    }
    public boolean isValidate()
    {
        if(etPass.getText().toString().length()==0)
        {
            Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(etEmail.getText().toString().length()==0)
        {
            Toast.makeText(this, "Please Enter Email", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


}

