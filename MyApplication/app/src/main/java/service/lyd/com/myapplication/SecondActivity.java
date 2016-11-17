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

public class SecondActivity extends Activity {

    private TextView mJumpView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        mJumpView = (TextView) findViewById(R.id.jump);
        mJumpView.setText(this.getTaskId()+"");
        mJumpView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                jumpToThirdActivity();

            }
        });

    }

    private void jumpToThirdActivity() {
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setClass(SecondActivity.this,SecondActivity.class);
        startActivity(intent);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Toast.makeText(SecondActivity.this,"onNewIntent被调用",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ObserverManger.getInstance().notifyOthersChanged();
    }
}
