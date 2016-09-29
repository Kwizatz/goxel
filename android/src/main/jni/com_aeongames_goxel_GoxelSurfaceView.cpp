#include <android/log.h>
#include "com_aeongames_goxel_GoxelSurfaceView.h"

extern "C" {
#include "goxel.h"
}

static JavaVM* gJavaVM = nullptr;
static goxel_t gGoxel{};
static inputs_t gInputs{};

jint JNICALL JNI_OnLoad ( JavaVM *aJavaVM, void *reserved )
{
    __android_log_print ( ANDROID_LOG_INFO,"Goxel","%d:%s",__LINE__,__FUNCTION__);
    gJavaVM = aJavaVM;
    __android_log_print ( ANDROID_LOG_INFO,"Goxel","%d:%s",__LINE__,__FUNCTION__);
    return JNI_VERSION_1_6;
}

void JNICALL JNI_OnUnload ( JavaVM *vm, void *reserved )
{
    __android_log_print ( ANDROID_LOG_INFO,"Goxel","%d:%s",__LINE__,__FUNCTION__);
}

void JNICALL Java_com_aeongames_goxel_GoxelSurfaceView_acquire
  (JNIEnv *, jobject)
{
    __android_log_print ( ANDROID_LOG_INFO,"Goxel","%d:%s",__LINE__,__FUNCTION__);
    memset(&gGoxel, 0, sizeof(goxel_t));
    goxel_init(&gGoxel);
    __android_log_print ( ANDROID_LOG_INFO,"Goxel","%d:%s",__LINE__,__FUNCTION__);
}

void JNICALL Java_com_aeongames_goxel_GoxelSurfaceView_release
  (JNIEnv *, jobject)
{
    __android_log_print ( ANDROID_LOG_INFO,"Goxel","%d:%s",__LINE__,__FUNCTION__);
    goxel_release(&gGoxel);    
    __android_log_print ( ANDROID_LOG_INFO,"Goxel","%d:%s",__LINE__,__FUNCTION__);
}

void JNICALL Java_com_aeongames_goxel_GoxelSurfaceView_draw
  (JNIEnv *, jobject)
{
    __android_log_print ( ANDROID_LOG_INFO,"Goxel","%d:%s",__LINE__,__FUNCTION__);
    GL(glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT));
    goxel_iter(&gGoxel, &gInputs);
    memset(&gInputs, 0, sizeof(inputs_t));
    goxel_render(&gGoxel);
    __android_log_print ( ANDROID_LOG_INFO,"Goxel","%d:%s",__LINE__,__FUNCTION__);
    /* Force Swap Buffers? */
    //eglSwapBuffers( eglGetCurrentDisplay(), eglGetCurrentSurface( EGL_DRAW ) );
}