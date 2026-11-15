
package hk.kinbo.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private final int dark = Color.rgb(25, 45, 55);
    private LinearLayout content;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scroll = new ScrollView(this);
        scroll.setFillViewport(true);
        scroll.setBackgroundColor(Color.rgb(243, 247, 249));

        content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        content.setPadding(dp(24), dp(28), dp(24), dp(24));

        scroll.addView(content);
        setContentView(scroll);

        addText("健步", 32);
        addText("步行 × 戶外單車", 18);
        addText("介面測試版 0.1", 14);
        addSpace(22);

        addText("尚未開始運動", 24);
        addText("此版本尚未接入計步及 GPS。", 15);
        addSpace(22);

        addText("步行", 22);
        addText("步數：— 步", 18);
        addText("時間：—", 18);
        addText("距離：— 公里", 18);
        addText("估算活動熱量：— kcal", 18);
        addSpace(20);

        addText("戶外單車", 22);
        addText("時間：—", 18);
        addText("距離：— 公里", 18);
        addText("平均速度：— km/h", 18);
        addText("估算活動熱量：— kcal", 18);
        addSpace(20);

        addText("GPS 路線圖", 22);
        addText("尚未加入地圖及路線記錄。", 16);
        addSpace(20);

        addButton("開始步行（尚未啟用）");
        addButton("開始踩單車（尚未啟用）");
        addButton("歷史紀錄（尚未啟用）");
        addButton("個人設定（尚未啟用）");
    }

    private void addText(String text, int size) {
        TextView view = new TextView(this);
        view.setText(text);
        view.setTextSize(size);
        view.setTextColor(dark);
        view.setPadding(0, dp(5), 0, dp(5));
        content.addView(view);
    }

    private void addSpace(int height) {
        View space = new View(this);
        content.addView(
            space,
            new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                dp(height)
            )
        );
    }

    private void addButton(String title) {
        Button button = new Button(this);
        button.setText(title);
        button.setAllCaps(false);

        LinearLayout.LayoutParams params =
            new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            );

        params.topMargin = dp(8);
        content.addView(button, params);

        button.setOnClickListener(v ->
            Toast.makeText(
                MainActivity.this,
                "目前只供測試介面，未開始記錄運動。",
                Toast.LENGTH_LONG
            ).show()
        );
    }

    private int dp(int value) {
        return Math.round(
            value * getResources().getDisplayMetrics().density
        );
    }
}
