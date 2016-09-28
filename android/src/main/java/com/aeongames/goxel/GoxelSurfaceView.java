package com.aeongames.goxel;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.content.Context;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

class GoxelSurfaceView
    extends GLSurfaceView
    implements GLSurfaceView.Renderer
{
    public GoxelSurfaceView ( Context context )
    {
        super ( context );
        Log.i ( "Goxel", "GoxelSurfaceView(Context context)" );
        setEGLContextClientVersion ( 3 );
        setRenderer ( this );
    }

    public GoxelSurfaceView ( Context context, AttributeSet attrs )
    {
        super ( context, attrs );
        Log.i ( "Goxel", "GoxelSurfaceView(Context context, AttributeSet attrs)" );
        setEGLContextClientVersion ( 3 );
        setRenderer ( this );
    }

    @Override
    public boolean onTouchEvent ( MotionEvent e )
    {
        Log.i ( "Goxel", "onTouchEvent" );
        int action = e.getActionMasked();
        switch ( action )
        {
        case MotionEvent.ACTION_DOWN:
            break;
        case MotionEvent.ACTION_MOVE:
            break;
        case MotionEvent.ACTION_UP:
            break;
        case MotionEvent.ACTION_CANCEL:
            break;
        default:
            return false;
        }
        invalidate();
        return true;
    }
    /* Renderer */
    @Override
    public void onSurfaceCreated ( GL10 gl, EGLConfig config )
    {
        Log.i ( "Goxel", "onSurfaceCreated" );
        GLES30.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
    }
    @Override
    public void onDrawFrame ( GL10 gl )
    {
        Log.i ( "Goxel", "onDrawFrame" );
        GLES30.glClear(GLES30.GL_COLOR_BUFFER_BIT);
    }
    @Override
    public void onSurfaceChanged ( GL10 gl, int width, int height )
    {
        Log.i ( "Goxel", "onSurfaceChanged" );
        GLES30.glViewport(0, 0, width, height);
    }
}
