package com.todosalau.greenrecycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private ImageView folderImageView, categoriasImageView, estatisImageView, estadisticaImageView, adviceImageView, consejoImageView, logoutImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Vincular los elementos de la interfaz
        folderImageView = findViewById(R.id.folderImageView);
        categoriasImageView = findViewById(R.id.categoriasImageView);
        estatisImageView = findViewById(R.id.estatisImageView);
        estadisticaImageView = findViewById(R.id.estadisticaImageView);
        adviceImageView = findViewById(R.id.adviceImageView);
        consejoImageView = findViewById(R.id.consejoImageView);
        logoutImageView = findViewById(R.id.logoutImageView);

        // Navegar a la pantalla de categorías
        View.OnClickListener categoryClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToCategory();
            }
        };
        folderImageView.setOnClickListener(categoryClickListener);
        categoriasImageView.setOnClickListener(categoryClickListener);

        // Navegar a la pantalla de estadísticas
        View.OnClickListener statisticsClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToStatistics();
            }
        };
        estatisImageView.setOnClickListener(statisticsClickListener);
        estadisticaImageView.setOnClickListener(statisticsClickListener);

        // Navegar a la pantalla de consejos
        View.OnClickListener adviceClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToAdvice();
            }
        };
        adviceImageView.setOnClickListener(adviceClickListener);
        consejoImageView.setOnClickListener(adviceClickListener);

        // Cerrar sesión y regresar a la pantalla de login
        logoutImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToLogin();
            }
        });
    }

    private void navigateToCategory() {
        Intent intent = new Intent(HomeActivity.this, CategoryActivity.class);
        startActivity(intent);
    }

    private void navigateToStatistics() {
        Intent intent = new Intent(HomeActivity.this, StatisticsActivity.class);
        startActivity(intent);
    }

    private void navigateToAdvice() {
        Intent intent = new Intent(HomeActivity.this, AdviceActivity.class);
        startActivity(intent);
    }

    private void navigateToLogin() {
        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
        startActivity(intent);
        finish(); // Cerrar la sesión y finalizar esta actividad
    }
}
