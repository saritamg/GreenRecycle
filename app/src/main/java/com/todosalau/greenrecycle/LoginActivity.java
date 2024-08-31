package com.todosalau.greenrecycle;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText edittextEmail, edittextPassword;
    private Button buttonLogin, buttonRegister;

    // Credenciales quemadas para la autenticación
    private static final String VALID_EMAIL = "usuario@ejemplo.com";
    private static final String VALID_PASSWORD = "password123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Vincular elementos de la interfaz
        edittextEmail = findViewById(R.id.edittext_email);
        edittextPassword = findViewById(R.id.edittext_password);
        buttonLogin = findViewById(R.id.button_login);
        buttonRegister = findViewById(R.id.button_register);

        // Acción del botón de Login
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateLogin();
            }
        });

        // Acción del botón de Registro
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToRegister();
            }
        });
    }

    private void validateLogin() {
        String email = edittextEmail.getText().toString().trim();
        String password = edittextPassword.getText().toString();

        // Validación del campo de correo
        if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edittextEmail.setError("Por favor, ingrese un correo electrónico válido.");
            return;
        }

        // Validación del campo de contraseña
        if (TextUtils.isEmpty(password)) {
            edittextPassword.setError("Por favor, ingrese su contraseña.");
            return;
        }

        // Validación de las credenciales
        if (email.equals(VALID_EMAIL) && password.equals(VALID_PASSWORD)) {
            // Usuario autenticado correctamente
            navigateToHome();
        } else {
            // Mostrar mensaje de error de credenciales incorrectas
            Toast.makeText(this, "Credenciales incorrectas. Si no está registrado, puede registrarse dando clic en 'Registro'.", Toast.LENGTH_LONG).show();
        }
    }

    private void navigateToHome() {
        // Navegar a la pantalla de inicio
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    private void navigateToRegister() {
        // Navegar a la pantalla de registro
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}
