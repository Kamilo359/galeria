package com.example.galeria;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    private int[] koty = {
            R.drawable.kot1,
            R.drawable.kot2,
            R.drawable.kot3,
            R.drawable.kot4
    };

    private int aktualnyIndeks = 0;
    private ImageView imageView;
    private Button buttonPrev, buttonNext;
    private EditText editTextNumber;
    private TextView textViewInfo;
    private Switch switchTlo;
    private LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        buttonPrev = findViewById(R.id.button3);
        buttonNext = findViewById(R.id.button4);
        editTextNumber = findViewById(R.id.editTextNumber);
        textViewInfo = findViewById(R.id.textView);
        switchTlo = findViewById(R.id.switch1);
        mainLayout = findViewById(R.id.main);

        pokazObraz(aktualnyIndeks);

        buttonNext.setOnClickListener(v -> {
            aktualnyIndeks++;
            if (aktualnyIndeks >= koty.length) {
                aktualnyIndeks = 0;
            }
            pokazObraz(aktualnyIndeks);
        });

        buttonPrev.setOnClickListener(v -> {
            aktualnyIndeks--;
            if (aktualnyIndeks < 0) {
                aktualnyIndeks = koty.length - 1;
            }
            pokazObraz(aktualnyIndeks);
        });

        editTextNumber.setOnEditorActionListener((v, actionId, event) -> {
            String tekst = editTextNumber.getText().toString();
            if (!tekst.isEmpty()) {
                try {
                    int numer = Integer.parseInt(tekst);
                    if (numer >= 1 && numer <= koty.length) {
                        aktualnyIndeks = numer - 1;
                        pokazObraz(aktualnyIndeks);
                    } else {
                        Toast.makeText(this, "Podaj liczbę od 1 do " + koty.length, Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(this, "Nieprawidłowy numer!", Toast.LENGTH_SHORT).show();
                }
            }
            return true;
        });

        switchTlo.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                mainLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.blue_1565c0));
            } else {
                mainLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_00796B));
            }
        });
    }
    private void pokazObraz(int indeks) {
        imageView.setImageResource(koty[indeks]);
    }
}
