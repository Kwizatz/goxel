package com.aeongames.goxel;

import android.app.Activity;
import android.os.Bundle;

public class Goxel extends Activity
{
    private GoxelSurfaceView mSurfaceView;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mSurfaceView =
            ( GoxelSurfaceView ) findViewById ( R.id.SurfaceView );
    }
}
