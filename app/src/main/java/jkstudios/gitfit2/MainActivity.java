package jkstudios.gitfit2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.support.customtabs.*;

import java.util.List;
import java.util.Set;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void authorize(View view) {
        String url = "https://www.fitbit.com/oauth2/authorize?response_type=token&client_id=22874H&redirect_uri=myapp%3A%2F%2Fauthorized%2F&scope=activity%20nutrition%20heartrate%20location%20nutrition%20profile%20settings%20sleep%20social%20weight";
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(url));
        Intent intent = getIntent();
        if (Intent.ACTION_VIEW.equals(intent.getAction())) {
            Uri data = getIntent().getData();
            String token = data.getEncodedFragment();
            Log.e("Full URL", data.toString());
            Log.e("Token", token);
        }
    }
}
