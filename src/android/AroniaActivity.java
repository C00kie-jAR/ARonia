package org.aronia.plugin;

import android.net.Uri;
import android.os.Bundle;

import com.google.ar.sceneform.assets.RenderableSource;
import com.google.ar.sceneform.ux.ArFragment;
import android.support.v7.app.AppCompatActivity;
import com.google.ar.sceneform.rendering.*;

public class AroniaActivity extends AppCompatActivity {
    
    private ArFragment fragment;
    private ModelRenderable duckRenderable;
    private static final String GLTF_ASSET =
            "https://raw.githubusercontent.com/AnalyticalGraphicsInc/cesium/master/Apps/SampleData/models/CesiumMilkTruck/CesiumMilkTruck-kmc.gltf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String package_name = getApplication().getPackageName();
        setContentView(getApplication().getResources().getIdentifier("activity_aronia", "layout", package_name));
        fragment = (ArFragment)
                getSupportFragmentManager().findFragmentById(getApplication().getResources().getIdentifier("activity_aronia", "id", package_name));

        ModelRenderable.builder()
                .setSource(this, RenderableSource.builder().setSource(
                        this,
                        Uri.parse(GLTF_ASSET),
                        RenderableSource.SourceType.GLTF2)
                        .setScale(0.5f)  // Scale the original model to 50%.
                        .setRecenterMode(RenderableSource.RecenterMode.ROOT)
                        .build())
                .setRegistryId(GLTF_ASSET)
                .build()
                .thenAccept(renderable -> duckRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            System.out.println(throwable.getStackTrace().toString());
                            return null;
                        });
        // ArSceneView arView = fragment.getArSceneView();
        // Scene scene = arView.getScene();
        // Node andy = new Node();
        // andy.setParent(scene);
        // ModelRenderable.builder()
        //         .setSource(this, getApplication().getResources().getIdentifier("raw/andy.sfb", null, package_name))
        //         .build()
        //         .thenAccept((renderable) -> {
        //             andy.setRenderable(renderable);
        //         });

    }
}