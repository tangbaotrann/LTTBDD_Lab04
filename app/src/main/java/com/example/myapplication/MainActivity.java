package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import adapter.LanguageAdapter;
import model.Language;

public class MainActivity extends AppCompatActivity {

    private List<Language> listLanguage;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.idListView);
        listLanguage = new ArrayList<>();
        listLanguage.add(new Language(1, "Cá nấu lẫu, nấu mini... \n ShopDevang"));
        listLanguage.add(new Language(2, "Đồ chơi dạng mô hình \n Shop Thế giới đồ chơi"));
        listLanguage.add(new Language(3, "1KG Khô Gà Bơ Tổi... \n Shop LTD Food"));
        listLanguage.add(new Language(4, "Lãnh đạo giản đơn \n Shop Minh Long Book"));
        listLanguage.add(new Language(5, "Xe cần cẩu đa năng \n Shop Thế giới đồ chơi"));
        listLanguage.add(new Language(6, "Hiếu lòng con trẻ \n Shop Minh Long Book"));

        LanguageAdapter adapter = new LanguageAdapter(this, R.layout.item_custom_list_view, listLanguage);
        listView.setAdapter(adapter);
    }
}