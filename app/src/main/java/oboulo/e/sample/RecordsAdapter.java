package oboulo.e.sample;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecordsAdapter extends RecyclerView.Adapter<RecordsAdapter.RecordsViewHolder>{

    private List<ModelDatum> listitems;

    public RecordsAdapter(List<ModelDatum> listitems) {
        this.listitems = listitems;
    }

    @NonNull
    @Override
    public RecordsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.example, parent, false);
        return new RecordsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecordsViewHolder holder, int position) {

        holder.name.setText(listitems.get(position).getName());
        holder.email.setText(listitems.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        //Log.e("dsdsdsd", String.valueOf(listitems.size()));
        return listitems.size();
    }


    public class RecordsViewHolder extends RecyclerView.ViewHolder{
        TextView name, email;
        public RecordsViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            email = (TextView) itemView.findViewById(R.id.email);
        }
    }
}
