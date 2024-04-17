package com.example.frag_r4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFrag.NameClicked {

    LinearLayout portrait, landscape;
    FragmentManager manager;
    Fragment listFrag, contentFrag;

    TextView tvContent;
    ImageView ivCall, ivLocation, ivLink;
    View v;


    Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        ivCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+contact.getPhone()));
                startActivity(i);
            }
        });

        ivLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("geo:(0,0)?q="+contact.getLocation()));
                startActivity(i);
            }
        });

        ivLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(contact.getUrl()));
                startActivity(i);
            }
        });


        if(portrait != null)
        {
            manager.beginTransaction()
                    .show(listFrag)
                    .hide(contentFrag)
                    .commit();

        }
        else
        {
            manager.beginTransaction()
                    .show(listFrag)
                    .show(contentFrag)
                    .commit();
        }

    }

    private void init()
    {
        portrait = findViewById(R.id.portrait_mode);
        landscape = findViewById(R.id.landscape_mode);
        manager = getSupportFragmentManager();


        listFrag = manager.findFragmentById(R.id.listfrag);
        contentFrag = manager.findFragmentById(R.id.contentfrag);
        assert contentFrag != null;
        v = contentFrag.requireView();

        tvContent = v.findViewById(R.id.tvContent_CF);
        ivCall = v.findViewById(R.id.ivCall);
        ivLink = v.findViewById(R.id.ivLink);
        ivLocation = v.findViewById(R.id.ivLocation);

        hideIcons();

    }

    private void hideIcons()
    {
        ivCall.setVisibility(View.GONE);
        ivLink.setVisibility(View.GONE);
        ivLocation.setVisibility(View.GONE);
    }
    private void showIcons()
    {
        ivCall.setVisibility(View.VISIBLE);
        ivLink.setVisibility(View.VISIBLE);
        ivLocation.setVisibility(View.VISIBLE);
    }

    @Override
    public void onNameClick(int index) {
        contact = MyApplication.contacts.get(index);
        showIcons();
       tvContent.setText(contact.getName());

       if(portrait!=null)
       {
           manager.beginTransaction()
                   .show(contentFrag)
                   .hide(listFrag)
                   .addToBackStack(null)
                   .commit();
       }
    }
}