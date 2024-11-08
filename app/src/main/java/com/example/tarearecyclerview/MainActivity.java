package com.example.tarearecyclerview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements ContactoAdapter.OnItemClickListener {

    public ArrayList<Contacto> contactArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Set de datos
        contactArrayList = new ArrayList<>(Arrays.asList(new Contacto[]{
            new Contacto("Juan Pérez", "juan.perez@example.com", "123456789",R.drawable.juan_perez),
            new Contacto("María López", "maria.lopez@example.com", "987654321",R.drawable.maria_lopez),
            new Contacto("Carlos García", "carlos.garcia@example.com", "456123789",R.drawable.carlos_garcia),
            new Contacto("Ana Martínez", "ana.martinez@example.com", "789456123",R.drawable.ana_martinez),
            new Contacto("Luis Fernández", "luis.fernandez@example.com", "321654987",R.drawable.luis_fernandez),
            new Contacto("Laura Sánchez", "laura.sanchez@example.com", "654987321",R.drawable.laura_sanchez),
            new Contacto("Pedro Gómez", "pedro.gomez@example.com", "159753486",R.drawable.pedro_gomez),
            new Contacto("Elena Díaz", "elena.diaz@example.com", "753159486",R.drawable.elena_diaz),
            new Contacto("Miguel Torres", "miguel.torres@example.com", "951753486",R.drawable.miguel_torres),
            new Contacto("Sofía Ramírez", "sofia.ramirez@example.com", "357951486",R.drawable.sofia_ramirez)
        }));

        //Adaptador
        ContactoAdapter contactoAdapter = new ContactoAdapter(contactArrayList,this);

        //RecyclerView
        RecyclerView rvContactos = findViewById(R.id.contact_list);

        //Tipo de layout manager
        rvContactos.setLayoutManager(new LinearLayoutManager(this));

        //Asignar adaptador a RV
        rvContactos.setAdapter(contactoAdapter);

    }

    @Override
    public void onItemClick(View view, int position) {
        // Toast con los datos del contacto pulsado
        Contacto contacto = contactArrayList.get(position);
        Toast.makeText(this, contacto.toString(), Toast.LENGTH_SHORT).show();
    }
}