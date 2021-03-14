package com.example.se2_einzelphase;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.BreakIterator;
import java.util.Arrays;
import java.util.stream.IntStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btn;
    private EditText matNo;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        matNo =  findViewById(R.id.inputMatNo);
        result =  findViewById(R.id.result);

        btn.setOnClickListener( (View.OnClickListener) this);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {

        TCP tcp = new TCP();

        if (v == btn) {

            // Eingegebenen String als matiklenummer (int) speichern
            int matrikelnummer = Integer.parseInt(matNo.getText().toString());

            System.out.println(matrikelnummer);

            String länge = Integer.toString(matrikelnummer);

            int a[] = new int[länge.length()];

            int z = 0;
            char [] charArray = länge.toCharArray();

            // Für jedes char in charArray den int Wert herasubekommen
            for (char c: charArray) {
                a[z] = Character.getNumericValue(c);
                z++;
            }

            // Array aufsteigend sortieren
             Arrays.sort(a);

            // Counter für gerade/ungerade Zahlen
            int gerade = 0;
            int ungerade = 0;

            for (int i = 0; i < a.length; i++) {
                if (a[i] % 2 == 0) {
                    gerade++;
                } else {
                    ungerade++;
                }
            }

            // neue Arrays mit der Länge von gerade/ungerade
            int[] evenArray = new int[gerade];
            int[] oddArray = new int[ungerade];

            // counter
            int j = 0;
            int y = 0;


            for (int i = 0; i < a.length; ++i) {

                if (a[i] % 2 == 0) {
                    evenArray[j] = a[i];
                    j++;

                } else {
                    oddArray[y] = a[i];
                    y++;
                }
            }

            // evenArray/oddArray zusammenfügen
            int combined[] = IntStream.concat(IntStream.of(evenArray), IntStream.of(oddArray)).toArray();

            // Array zu String machen
            StringBuilder sb = new StringBuilder();
            for (int i : combined) {
                sb.append(i);
            }

            String ergebnis = sb.toString();

            tcp.res = ergebnis;

            result.setText(tcp.res);
        }
    }
}