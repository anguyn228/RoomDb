package com.example.roomdatabasepratice;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.RoomDatabase;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {
    private Activity context;
    private TestDB database;
    private List<Test> testList;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.action_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TestAdapter.ViewHolder holder, int position) {
        Test test = testList.get(position);
        database = TestDB.getInstance(context);

        holder.textView.setText(test.getText());

        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Test d = testList.get(holder.getAdapterPosition());
                int sID = d.getID();
                String sText = d.getText();
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.editlayout);

                int width = WindowManager.LayoutParams.MATCH_PARENT;
                int height = WindowManager.LayoutParams.WRAP_CONTENT;

                dialog.show();

                EditText editText = dialog.findViewById(R.id.editText);
                Button buttonUpdate = dialog.findViewById(R.id.buttonUpdate);
            }
        });
    }

    @Override
    public int getItemCount() {
        return testList.size();
    }

    public TestAdapter(Activity context, List<Test> testList){
        this.context = context;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView btnEdit, btnDelete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            btnEdit = itemView.findViewById(R.id.imageEdit);
            btnDelete = itemView.findViewById(R.id.imageDelete);
        }
    }
}
