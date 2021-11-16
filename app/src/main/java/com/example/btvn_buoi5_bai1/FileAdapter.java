package com.example.btvn_buoi5_bai1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btvn_buoi3_bai2.R;

import java.util.List;

public class FileAdapter extends RecyclerView.Adapter<FileAdapter.MyViewHolder>{

    private List<FilePDF> filePDFList;
    //private Context context;
    private IClickItem iClickItem;


    public interface IClickItem{

    }

    public FileAdapter(IClickItem iClickItem) {
        this.iClickItem = iClickItem;
    }

    public void setData(List<FilePDF> list){
        this.filePDFList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_file_pdf, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FileAdapter.MyViewHolder holder, int position) {
        final FilePDF filePDF = filePDFList.get(position);
        if(filePDF == null){
            return;
        }
        holder.tvFileName.setText(filePDF.getName() + "");
    }

    @Override
    public int getItemCount() {
        if(filePDFList != null){
            return filePDFList.size();
        }
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tvFileName;
        public MyViewHolder(@NonNull  View itemView) {
            super(itemView);
            tvFileName = itemView.findViewById(R.id.tvFile_name);

        }
    }
}
