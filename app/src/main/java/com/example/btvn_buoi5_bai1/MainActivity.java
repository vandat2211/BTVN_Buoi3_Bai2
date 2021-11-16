package com.example.btvn_buoi5_bai1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.btvn_buoi3_bai2.R;
import com.example.btvn_buoi5_bai1.database.FilePDFDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ImageButton btnAdd;
    private List<FilePDF> mFileList;
    private  FileAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFDF40")));

        recyclerView = findViewById(R.id.recycleview);

        mFileList = new ArrayList<>();
        mFileList.add(new FilePDF("To Kill a Mockingbird"));
        mFileList.add(new FilePDF("To Kill a Mockingbird"));
        mFileList.add(new FilePDF("To Kill a Mockingbird"));
        mFileList.add(new FilePDF("To Kill a Mockingbird"));
        mFileList.add(new FilePDF("To Kill a Mockingbird"));

        /*adapter = new FileAdapter(new FileAdapter.IClickItem() {

        });*/

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FileAdapter(new FileAdapter.IClickItem() {

        });
        recyclerView.setAdapter(adapter);
        adapter.setData(mFileList);


        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickImageButtonAdd();
            }
        });

        loadData();

    }

    private void loadData() {
        mFileList = FilePDFDatabase.getInstance(this).filePDFDAO().getListFilePDF();
        adapter.setData(mFileList);
    }

    private void clickImageButtonAdd() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_add_item);
        EditText edtName = dialog.findViewById(R.id.edt_add_file_name);
        Button btnDialogAdd = dialog.findViewById(R.id.btn_add_file);
        Button btnDialogCancel = dialog.findViewById(R.id.btn_cancel);

        btnDialogCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        btnDialogAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strFileName = edtName.getText().toString();
                if(strFileName.equals("")){
                    Toast.makeText(MainActivity.this, "Vui lòng nhập tên file", Toast.LENGTH_SHORT).show();
                }else {
                    FilePDF filePDF = new FilePDF(strFileName);
                    FilePDFDatabase.getInstance(MainActivity.this).filePDFDAO().insertFilePDF(filePDF);
                    Toast.makeText(MainActivity.this, "Thêm file thành công", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    loadData();
                }
            }
        });
        dialog.show();
    }


}