package com.example.recyclerviewpart1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
    private int numberOfViewHolders = 0;
    private ArrayList<Contact> contacts;
    public ContactsAdapter(ArrayList<Contact> contacts){
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        numberOfViewHolders++;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        System.out.println("VIEW HOLDER WAS REBOUND");
        Contact contact = contacts.get(position);
        TextView nameView = holder.itemView.findViewById(R.id.name);
        TextView phoneNumberView = holder.itemView.findViewById(R.id.phone_number);
        nameView.setText(contact.name);
        phoneNumberView.setText(contact.phoneNumber + "");
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}