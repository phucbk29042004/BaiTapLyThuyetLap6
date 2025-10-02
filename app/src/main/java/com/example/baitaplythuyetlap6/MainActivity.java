package com.example.baitaplythuyetlap6;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView ivUitLogo;
    private Button btnFadeInXml, btnFadeOutXml, btnBlinkXml, btnZoomInXml, btnZoomOutXml,
            btnRotateXml, btnMoveXml, btnSlideUpXml, btnBounceXml, btnCombineXml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewsByIds();

        // Animation từ XML
        handleClickAnimationXml(btnFadeInXml, R.anim.anim_fade_in);
        handleClickAnimationXml(btnFadeOutXml, R.anim.anim_fade_out);
        handleClickAnimationXml(btnBlinkXml, R.anim.anim_blink);
        handleClickAnimationXml(btnZoomInXml, R.anim.anim_zoom_in);
        handleClickAnimationXml(btnZoomOutXml, R.anim.anim_zoom_out);
        handleClickAnimationXml(btnRotateXml, R.anim.anim_rotate);
        handleClickAnimationXml(btnMoveXml, R.anim.anim_move);
        handleClickAnimationXml(btnSlideUpXml, R.anim.anim_slide_up);
        handleClickAnimationXml(btnBounceXml, R.anim.anim_bounce);
        handleClickAnimationXml(btnCombineXml, R.anim.anim_combine);

        // Animation từ Code
        handleClickAnimationCode(findViewById(R.id.btn_fade_in_code), createFadeInAnim());
        handleClickAnimationCode(findViewById(R.id.btn_zoom_in_code), createZoomInAnim());
        handleClickAnimationCode(findViewById(R.id.btn_rotate_code), createRotateAnim());

        // Mở SecondActivity với hiệu ứng
        ivUitLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);

                // Animation chuyển màn hình
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

    // Hàm ánh xạ view
    private void findViewsByIds() {
        ivUitLogo = findViewById(R.id.iv_uit_logo);
        btnFadeInXml = findViewById(R.id.btn_fade_in_xml);
        btnFadeOutXml = findViewById(R.id.btn_fade_out_xml);
        btnBlinkXml = findViewById(R.id.btn_blink_xml);
        btnZoomInXml = findViewById(R.id.btn_zoom_in_xml);
        btnZoomOutXml = findViewById(R.id.btn_zoom_out_xml);
        btnRotateXml = findViewById(R.id.btn_rotate_xml);
        btnMoveXml = findViewById(R.id.btn_move_xml);
        btnSlideUpXml = findViewById(R.id.btn_slide_up_xml);
        btnBounceXml = findViewById(R.id.btn_bounce_xml);
        btnCombineXml = findViewById(R.id.btn_combine_xml);
    }

    // Hàm xử lý animation XML
    private void handleClickAnimationXml(Button btn, int animId) {
        btn.setOnClickListener(v -> {
            Animation animation = AnimationUtils.loadAnimation(this, animId);
            ivUitLogo.startAnimation(animation);
        });
    }

    // Hàm xử lý animation Code
    private void handleClickAnimationCode(Button btn, final Animation animation) {
        btn.setOnClickListener(v -> ivUitLogo.startAnimation(animation));
    }

    // Các hàm tạo animation bằng code
    private Animation createFadeInAnim() {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(1000);
        anim.setFillAfter(true);
        return anim;
    }

    private Animation createZoomInAnim() {
        ScaleAnimation anim = new ScaleAnimation(
                1, 3, 1, 3,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setDuration(1000);
        return anim;
    }

    private Animation createRotateAnim() {
        RotateAnimation anim = new RotateAnimation(
                0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setDuration(600);
        return anim;
    }
}
