package io.github.brunogabriel.testcoveragereport;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

/**
 * Created by brunogabriel on 25/01/17.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button_hide).setOnClickListener(this);
        findViewById(R.id.button_msg).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_hide) {
            findViewById(R.id.button_hide).setVisibility(View.GONE);
        } else {
            ((AppCompatTextView) findViewById(R.id.text_hello))
                    .setText(getString(R.string.hello_world));
        }
    }

    public boolean isTextHelloWorld() {
        return ((AppCompatTextView) findViewById(R.id.text_hello)).getText()
                .toString().equalsIgnoreCase(getResources().getString(R.string.hello_world));
    }
}
