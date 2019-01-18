package com.nonexistentware.igor.demoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;

import com.nonexistentware.igor.demoquiz.Adapter.CategoryAdapter;
import com.nonexistentware.igor.demoquiz.Common.Decoration;
import com.nonexistentware.igor.demoquiz.DbHelper.DbHelper;


public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Demo Quiz");
        setSupportActionBar(toolbar);

        recyclerCategory = (RecyclerView) findViewById(R.id.recyclerCategory);
        recyclerCategory.setHasFixedSize(true);
        recyclerCategory.setLayoutManager(new GridLayoutManager(this, 2));

        CategoryAdapter adapter = new CategoryAdapter(MainActivity.this, DbHelper.getInstance(this).getAllCategories());
        int spaceInPixel = 4;
        recyclerCategory.addItemDecoration(new Decoration(spaceInPixel));
        recyclerCategory.setAdapter(adapter);


    }
}
