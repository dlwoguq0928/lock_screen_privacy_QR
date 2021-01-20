package kr.physia.lockscreen.privacyqr;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button onBtn, offBtn, exitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //버튼 동작
        onBtn= (Button)findViewById(R.id.button);
        offBtn= (Button)findViewById(R.id.button2);
        exitBtn= (Button)findViewById(R.id.button3);
        onBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ScreenService.class);
                startService(intent);
                onBtn.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                offBtn.setBackgroundColor(Color.TRANSPARENT);
            }

        });
        offBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ScreenService.class);
                stopService(intent);
                onBtn.setBackgroundColor(Color.TRANSPARENT);
                offBtn.setBackgroundColor(Color.TRANSPARENT);
            }
        });
        exitBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
            }
        });
    }
}
