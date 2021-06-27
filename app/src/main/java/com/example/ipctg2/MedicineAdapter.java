package com.example.ipctg2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public Button button;

        public ViewHolder(View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.textView5);
            button = itemView.findViewById(R.id.button);
        }
    }
    private List<Medicine> mMedicine;

    public MedicineAdapter(List<Medicine> medicine) {
        mMedicine = medicine;
    }
    @Override
    public MedicineAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View medView = inflater.inflate(R.layout.main_layout_row, parent, true);

        ViewHolder viewHolder = new ViewHolder(medView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MedicineAdapter.ViewHolder holder, int position) {
        Medicine medicine = mMedicine.get(position);
        TextView textView = holder.nameTextView;
        textView.setText(medicine.getName());
        Button button = holder.button;
        button.setText(medicine.getAmount());
    }

    @Override
    public int getItemCount() {
        return mMedicine.size();
    }
}