package org.aronia.plugin;

import android.app.Activity;
import android.os.Bundle;
import com.google.ar.sceneform.ux.ArFragment;
import android.support.v7.app.AppCompatActivity;

import android.service.autofill.TextValueSanitizer;
import com.google.ar.core.Anchor;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.ArSceneView;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.Scene;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.rendering.*;

public class AroniaActivity extends AppCompatActivity {
    
    private ArFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String package_name = getApplication().getPackageName();
        setContentView(getApplication().getResources().getIdentifier("activity_aronia", "layout", package_name));
        fragment = (ArFragment)
                getSupportFragmentManager().findFragmentById(getApplication().getResources().getIdentifier("activity_aronia", "id", package_name));

        ArSceneView arView = fragment.getArSceneView();
        Scene scene = arView.getScene();
        Node andy = new Node();
        andy.setParent(scene);
        ModelRenderable.builder()
                .setSource(this, getApplication().getResources().getIdentifier("raw/andy.sfb", null, package_name))
                .build()
                .thenAccept((renderable) -> {
                    andy.setRenderable(renderable);
                });

    }
}