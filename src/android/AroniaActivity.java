
import android.app.Activity;
import android.os.Bundle;
import com.google.ar.sceneform.ux.ArFragment;
import android.support.v7.app.AppCompatActivity;

public class AroniaActivity extends AppCompatActivity {
    
    private ArFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getApplication().getResources().getIdentifier("activity_new", "layout", package_name));
        fragment = (ArFragment)
                getSupportFragmentManager().findFragmentById("sceneform_fragment");

    }
}