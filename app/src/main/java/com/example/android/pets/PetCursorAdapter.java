package com.example.android.pets;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.android.pets.data.PetContract;
import com.example.android.pets.data.PetContract.PetEntry;

/**
 * Created by summi on 18-07-2017.
 */
public class PetCursorAdapter extends CursorAdapter {

    public PetCursorAdapter(Context context, Cursor cursor){
        super(context, cursor, 0);
    }


    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nameTextView = (TextView) view.findViewById(R.id.name);
        TextView summaryTextView = (TextView) view.findViewById(R.id.summary);

        String petName = cursor.getString(cursor.getColumnIndex(PetEntry.COLUMN_PET_NAME));
        String petBreed = cursor.getString(cursor.getColumnIndex(PetEntry.COLUMN_PET_BREED));

        if(TextUtils.isEmpty(petBreed)){
            petBreed = context.getString(R.string.unknown_breed);
        }

        nameTextView.setText(petName);
        summaryTextView.setText(petBreed);
    }
}
