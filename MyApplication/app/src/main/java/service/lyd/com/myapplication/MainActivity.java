package service.lyd.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ObserverManger.IListener{

    private TextView mJumpView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mJumpView = (TextView) findViewById(R.id.jump);
        mJumpView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumpToSecondActivity();
            }
        });

        ObserverManger.getInstance().registListeners(this);

    }

    private void jumpToSecondActivity() {
        Intent intent = new Intent();
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setClass(MainActivity.this,SecondActivity.class);
        startActivity(intent);
        
    }

    @Override
    public void notifyDataSetChanged() {
        Toast.makeText(MainActivity.this,"上个页面通知我刷新了",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ObserverManger.getInstance().unRegistListener(this);
    }
}
