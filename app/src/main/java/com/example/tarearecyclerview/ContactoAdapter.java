package com.example.tarearecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder>{
    ArrayList<Contacto> agenda;

    public ContactoAdapter(ArrayList<Contacto> agenda){this.agenda = agenda;}

    @NonNull
    @Override
    public ContactoAdapter.ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ContactoAdapter.ContactoViewHolder contactoViewHolder =
                new ContactoViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.contacto,parent,false)
                );
        return contactoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoAdapter.ContactoViewHolder holder, int position) {
        Contacto contacto = agenda.get(position);
        holder.img.setImageResource(contacto.getFoto());
        holder.tv_nombre.setText(contacto.getNombre());
        holder.tv_email.setText(contacto.getEmail());
        holder.tv_numero.setText(contacto.getNumeroMovil());
    }

    @Override
    public int getItemCount() {return agenda.size();}

    public class ContactoViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView tv_nombre;
        TextView tv_email;
        TextView tv_numero;


        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.foto_perfil);
            tv_nombre = itemView.findViewById(R.id.nombre);
            tv_email = itemView.findViewById(R.id.email);
            tv_numero = itemView.findViewById(R.id.numero);
        }
    }
}
