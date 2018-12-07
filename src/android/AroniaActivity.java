
import android.app.Activity;
import android.os.Bundle;
import com.google.ar.sceneform.ux.ArFragment;

public class AroniaActivity extends Activity {
    
    private ArFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getApplication().getResources().getIdentifier("activity_new", "layout", package_name));
        fragment = (ArFragment)
                getSupportFragmentManager().findFragmentById(R.id.sceneform_fragment);

    }
}