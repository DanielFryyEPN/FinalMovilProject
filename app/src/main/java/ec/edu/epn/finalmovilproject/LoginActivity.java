package ec.edu.epn.finalmovilproject;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.File;

/**
 * Created by danie on 6/13/2017.
 */

public class LoginActivity extends AppCompatActivity {
    private TextView lblAyuda;
    private Button btnIngresar;
    private EditText txtUsuario, txtPassword;
    private ProgressBar progressBar;
    private ScrollView loginContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        lblAyuda = (TextView) findViewById(R.id.lblAyuda);
        lblAyuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HelpDialog dialog = new HelpDialog();
                dialog.show(getFragmentManager(), "");
            }
        });

        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgress(true);
                txtUsuario = (EditText) findViewById(R.id.txtUsuarioLog);
                txtPassword = (EditText) findViewById(R.id.txtPasswordLog);
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        progressBar = (ProgressBar) findViewById(R.id.progressBarLogin);
        loginContainer = (ScrollView) findViewById(R.id.loginContainer);
    }

    private void showProgress(final boolean show) {
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
        loginContainer.setVisibility(show ? View.GONE : View.VISIBLE);
    }
}
