    package com.example.aula2;

    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;

    import androidx.activity.EdgeToEdge;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.core.graphics.Insets;
    import androidx.core.view.ViewCompat;
    import androidx.core.view.WindowInsetsCompat;

    public class MainActivity extends AppCompatActivity {

        private EditText editTextNumero;
        private Button buttonGerar;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);

            setContentView(R.layout.activity_main);

            editTextNumero = findViewById(R.id.edvalorTabuada);
            buttonGerar = findViewById(R.id.btGerar);

            buttonGerar.setOnClickListener(v -> {

                String inputStr = editTextNumero.getText().toString();
                int numero;

                try {
                    numero = Integer.parseInt(inputStr);
                } catch (NumberFormatException e){
                    return;
                }

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("numero", numero);
                startActivity(intent);

            });

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }
    }