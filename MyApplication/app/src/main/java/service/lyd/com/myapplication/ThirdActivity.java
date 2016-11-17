package service.lyd.com.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by lyd10892 on 2016/11/16.
 */

public class ThirdActivity extends Activity {
    private TextView mJumpView;
    private TextView mJumpView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);
        mJumpView = (TextView) findViewById(R.id.jump);
        mJumpView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumpToSecondActivity();
            }
        });


    }


    private void jumpToSecondActivity() {
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setClass(ThirdActivity.this, SecondActivity.class);
        startActivity(intent);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Toast.makeText(ThirdActivity.this, "jh", Toast.LENGTH_SHORT).show();
    }
}
