package com.todosalau.greenrecycle;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText, confirmPasswordEditText;
    private Button buttonRegister;
    private static HashMap<String, String> userDatabase = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Vincular elementos de la interfaz
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        buttonRegister = findViewById(R.id.buttonRegister);

        // Acción del botón de Registro
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString();
        String confirmPassword = confirmPasswordEditText.getText().toString();

        // Validación del campo de correo
        if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.setError("Por favor, ingrese un correo electrónico válido.");
            return;
        }

        // Validación del campo de contraseña
        if (TextUtils.isEmpty(password)) {
            passwordEditText.setError("Por favor, ingrese su contraseña.");
            return;
        }

        // Validación del campo de confirmación de contraseña
        if (TextUtils.isEmpty(confirmPassword) || !confirmPassword.equals(password)) {
            confirmPasswordEditText.setError("Las contraseñas no coinciden.");
            return;
        }

        // Guardar el usuario en la base de datos simulada
        userDatabase.put(email, password);
        Toast.makeText(this, "Registro exitoso. Ahora puede iniciar sesión.", Toast.LENGTH_LONG).show();

        // Navegar a la pantalla de login
        navigateToLogin();
    }

    private void navigateToLogin() {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
