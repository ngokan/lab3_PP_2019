package com.example.nguyen_lab3_pp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class OutputActivity extends AppCompatActivity {
    RecyclerView list;
    ArrayList<String> outputID = new ArrayList<String>();
    ArrayList<String> outputFIO = new ArrayList<String>();
    ArrayList<String> outputDATE = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.output_activity);
        outputID = getIntent().getStringArrayListExtra("id"); //почему иногда тут 4 а иногда 5
        outputFIO = getIntent().getStringArrayListExtra("fio"); //почему иногда тут 4 а иногда 5
        outputDATE = getIntent().getStringArrayListExtra("date"); //почему иногда тут 4 а иногда 5
        list = (RecyclerView) findViewById(R.id.outList);
        list.setAdapter(new CustomAdapter(this, outputID.size()));
    }

    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

        private LayoutInflater inflater;
        Context context;
        private int number;

        CustomAdapter(Context context, int number) {
            this.number = number;
            this.context = context;
            this.inflater = LayoutInflater.from(context);
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            final View view = inflater.inflate(R.layout.list_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            holder.id.setText(outputID.get(position));
            holder.name.setText(outputFIO.get(position));
            holder.date.setText(outputDATE.get(position));
        }

        @Override
        public int getItemCount() {
            return number;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            View view;
            final TextView id, name, date;

            ViewHolder(final View view) {
                super(view);
                this.view = view;
                id = (TextView) view.findViewById(R.id.id);
                name = (TextView) view.findViewById(R.id.name);
                date = (TextView) view.findViewById(R.id.date);
            }
        }


    }
}