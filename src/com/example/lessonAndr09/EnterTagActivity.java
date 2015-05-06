package com.example.lessonAndr09;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnterTagActivity extends Activity {

    EditText tags;
    Button searchGifsBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_tag);

        tags = (EditText) findViewById(R.id.tags);
        searchGifsBtn = (Button) findViewById(R.id.search_gifs_btn);

        searchGifsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tags.getText().length() > Const.MIN_TAG_SIZE) {

                    String tagsStr = swapSpaceToPlus(tags.getText());

                    Log.d("myTag", tagsStr);

                    Intent intent = new Intent(EnterTagActivity.this, DownloadActivity.class);
                    intent.putExtra("tags",tagsStr);
                    startActivity(intent);

                }
            }
        });
    }

    private String swapSpaceToPlus(Editable text) {
        return text.toString().replace(' ','+');
    }
}
