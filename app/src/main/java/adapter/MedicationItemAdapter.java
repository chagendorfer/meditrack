package adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import at.fhj.chagendorfer.meditrack.R;
import database.MedicationEntity;

public class MedicationItemAdapter extends RecyclerView.Adapter<MedicationItemAdapter.ViewHolder>{

    private final List<MedicationEntity> medList;

    public MedicationItemAdapter(List<MedicationEntity> medList){
        this.medList=medList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView name;
        CheckBox checkbox;

        public ViewHolder(View v) {
            super(v);
            icon = v.findViewById(R.id.med_icon);
            name = v.findViewById(R.id.med_name);
            checkbox = v.findViewById(R.id.cb_reminder_enabled);
        }
    }
    @Override
    public MedicationItemAdapter.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int viewtype){
        View v = LayoutInflater.from(viewgroup.getContext()).inflate(R.layout.medicationlist_item, viewgroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MedicationItemAdapter.ViewHolder holder, int position) {
        MedicationEntity med = medList.get(position);
        holder.name.setText(med.name);
        holder.checkbox.setChecked(med.reminderEnabled);

        holder.checkbox.setOnCheckedChangeListener((cb_reminder_enabled, isChecked) -> { //TODO: isChecked
            med.reminderEnabled = isChecked;
        });

    }

    @Override
    public int getItemCount() {
        return medList.size();
    }
}
