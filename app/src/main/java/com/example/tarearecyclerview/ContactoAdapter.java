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
    // Interfaz para que otra actividad pueda capturar el evento de click
    public interface OnItemClickListener{
        public void onItemClick(View view, int position);
    }

    private ArrayList<Contacto> agenda;

    private OnItemClickListener itemClickListener;

    public ContactoAdapter(ArrayList<Contacto> agenda, OnItemClickListener itemClickListener){
        this.agenda = agenda;
        this.itemClickListener = itemClickListener;
    }

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

    public class ContactoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView img;
        TextView tv_nombre;
        TextView tv_email;
        TextView tv_numero;


        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            // Propagar el evento de click a la actividad
            itemView.setOnClickListener(this);

            img = itemView.findViewById(R.id.foto_perfil);
            tv_nombre = itemView.findViewById(R.id.nombre);
            tv_email = itemView.findViewById(R.id.email);
            tv_numero = itemView.findViewById(R.id.numero);
        }

        /**
         * Called when a view has been clicked.
         * @param v The view that was clicked.
         *          Propaga el evento hacía fuera, así podemos capturarlo en el punto
         *          que queramos de nuestra aplicación
         */
        @Override
        public void onClick(View v) {
            itemClickListener.onItemClick(v, getAdapterPosition());

        }
    }
}
