package com.example.piedrapapeltijeras;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View .OnClickListener{
    ImageButton piedra;
    ImageButton papel;
    ImageButton tijeras;
    ImageView pc;
    ImageView jugador;
    Integer pcnumber;
    Integer jugadornumber;
    TextView letrero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        piedra = findViewById(R.id.piedra);
        papel = findViewById(R.id.papel);
        tijeras = findViewById(R.id.tijeras);
        pc = findViewById(R.id.pc);
        jugador = findViewById(R.id.jugador);
        letrero = findViewById(R.id.comienza);
        piedra.setOnClickListener(this);
        papel.setOnClickListener(this);
        tijeras.setOnClickListener(this);
        jugadornumber = 0;


    }
    public Integer random()
    {
        Random r = new Random();
        pcnumber = r.nextInt(3 - 0)-0;
        System.out.println(pcnumber);
        switch (pcnumber)
        {
            case 0:
            {
                //piedra
                pc.setImageResource(R.drawable.hand3);
                return 0;

            }
            case 1:
            {
                //papel
                pc.setImageResource(R.drawable.hand4);
                return 1;
            }
            case 2:
            {
                //tijera
                pc.setImageResource(R.drawable.hand5);
                return 2;
            }
        }
        return 0;
    }
    public void ganador(Integer pc, Integer jugador)
    {
        if(jugador == pc)
        {
            letrero.setText("EMPATE");
        }
        if(jugador == 0)
        {
            switch (pc)
            {
                case 1:
                {
                    letrero.setText("PIERDES");
                }break;
                case 2:
                {
                    letrero.setText("GANAS");
                }break;
            }
        }
        if(jugador == 1)
        {
            switch (pc)
            {
                case 0:
                {
                    letrero.setText("GANAS");
                }break;
                case 2:
                {
                    letrero.setText("PIERDES");
                }
            }
        }
        if( jugador == 2)
        {
            switch (pc)
            {
                case 0:
                {
                    letrero.setText("PIERDES");
                }break;
                case 1:
                {
                    letrero.setText("GANAS");
                }break;
            }
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.piedra:
            {
                jugadornumber = 0;
                jugador.setImageResource(R.drawable.hand3);
                pcnumber=random();
                ganador(pcnumber,jugadornumber);

            }break;
            case R.id.papel:
            {
                jugadornumber = 1;
                jugador.setImageResource(R.drawable.hand4);
                pcnumber=random();
                ganador(pcnumber,jugadornumber);

            }break;
            case R.id.tijeras:
            {
                jugadornumber = 2;
                pcnumber=random();
                jugador.setImageResource(R.drawable.hand5);
                ganador(pcnumber,jugadornumber);

            }break;

        }


    }
}
