package in.debate.debate;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by root on 18/10/15.
 */
public class ProfileViewActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_profileview);
    }


}
