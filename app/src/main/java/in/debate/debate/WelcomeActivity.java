package in.debate.debate;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class WelcomeActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_welcome);
        final ImageView loader=(ImageView) findViewById(R.id.loader);
        loader.setVisibility(View.GONE);
        final LinearLayout welcome_top_layout=(LinearLayout) findViewById(R.id.welcome_top_layout);
        Button welcome_signin=(Button) findViewById(R.id.welcome_signin);
        final int height=welcome_top_layout.getHeight();
        Log.d("Height",""+height);
        ResizeAnimation resizeAnimation = new ResizeAnimation(
                welcome_top_layout,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        resizeAnimation.setDuration(2000);
        welcome_top_layout.startAnimation(resizeAnimation);
        welcome_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ResizeAnimation resizeAnimation = new ResizeAnimation(
                        welcome_top_layout,
                        2000,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );
                resizeAnimation.setDuration(2000);
                Animation animation = AnimationUtils.loadAnimation(WelcomeActivity.this, R.anim.rotate);
                loader.startAnimation(animation);
                loader.setVisibility(View.VISIBLE);
                welcome_top_layout.startAnimation(resizeAnimation);
                final Intent profileview=new Intent(WelcomeActivity.this,NewsFeedActivity.class);
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loader.setVisibility(View.GONE);
                        startActivity(profileview); //Do something after 100ms

                    }
                }, 3000);

            }
        });
        }

    public class ResizeAnimation extends Animation {
        final int targetHeight;
        View view;
        int startHeight;

        public ResizeAnimation(View view, int targetHeight, int startHeight) {
            this.view = view;
            this.targetHeight = targetHeight;
            this.startHeight = startHeight;
        }

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            int newHeight = (int) (startHeight + targetHeight * interpolatedTime);
            view.getLayoutParams().height = newHeight;
            view.requestLayout();
        }

        @Override
        public void initialize(int width, int height, int parentWidth, int parentHeight) {
            super.initialize(width, height, parentWidth, parentHeight);
        }

        @Override
        public boolean willChangeBounds() {
            return true;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        return super.onOptionsItemSelected(item);
    }
}
