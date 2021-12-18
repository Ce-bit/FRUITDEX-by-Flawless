package com.example.test;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
public class Sign_in extends AppCompatActivity {


    // Variable declarations
    private TextInputEditText mEmail, mPassword;
    private TextView mSignUp;
    private Button mSignIn;
    private ProgressBar mProgress;
    SharedPreferences sharedpreferences;
    // Volley Variables
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;

    public static final String MyPREFERENCES = "UserLogin";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mEmail = findViewById(R.id.emailAddress_EditText);
        mPassword = findViewById(R.id.password_EditText);
        mSignIn = findViewById(R.id.signin_button);
        mSignUp = findViewById(R.id.signup_textView);
        mProgress = findViewById(R.id.progress);


        mSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn(mEmail.getText().toString(), mPassword.getText().toString());
            }
        });


        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sign_in.this, MainActivity.class));
            }
        });


    }



    private void signIn( final String email, final String password) {
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        mProgress.setVisibility(View.VISIBLE);
        // Initializing Request queue
        mRequestQueue = Volley.newRequestQueue(Sign_in.this);

        mStringRequest = new StringRequest(Request.Method.POST,
                getBaseUrl(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);

                    String success = jsonObject.getString("success");
                    String message = jsonObject.getString("message");

                    if (success.equals("1")) {
                        editor.putString("EMAIL", email);
                        editor.putString("Password", password);
                        editor.commit();
                        mProgress.setVisibility(View.GONE);
                        Toast.makeText(Sign_in.this,message,Toast.LENGTH_SHORT).show();
                        // Finish
                        finish();
                        // Start activity dashboard
                        startActivity(new Intent(Sign_in.this,DetectorActivity.class));
                    }
                    if (success.equals("0")) {

                        mProgress.setVisibility(View.GONE);
                        Toast.makeText(Sign_in.this,message,Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {

                    mProgress.setVisibility(View.GONE);
                    Toast.makeText(Sign_in.this,e.toString(),Toast.LENGTH_SHORT).show();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                mProgress.setVisibility(View.GONE);
                Toast.makeText(Sign_in.this,error.toString(),Toast.LENGTH_SHORT).show();

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("email",email);
                params.put("password",password);

                return params;
            }
        };

        mStringRequest.setShouldCache(false);
        mRequestQueue.add(mStringRequest);
    }


    private String getBaseUrl (){
        return "http://"+getResources().getString(R.string.machine_ip_address)+"/android/sign_in.php";
    }

    }


