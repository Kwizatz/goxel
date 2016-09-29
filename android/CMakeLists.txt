cmake_minimum_required(VERSION 3.4.1)
find_package(Java COMPONENTS Development)

add_custom_command(OUTPUT com_aeongames_goxel_Goxel.h
	COMMAND ${Java_JAVAH_EXECUTABLE} ARGS "-classpath" "$ENV{CLASSPATH};${CMAKE_CURRENT_SOURCE_DIR}/src/main/java" "com.aeongames.goxel.Goxel"
	DEPENDS ${CMAKE_CURRENT_SOURCE_DIR}/src/main/java/com/aeongames/goxel/Goxel.java
	#WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR}/src/main/java
	)

set(CMAKE_C_FLAGS "-Wall -Werror -std=gnu99 -Wno-unknown-pragmas")
set(CMAKE_CXX_FLAGS "-std=gnu++11 -Wall -Werror -Wno-narrowing -Wno-unknown-pragmas")
include_directories(
        ../src
        ../ext_src/glfw
        ../ext_src/imgui
        ../ext_src/uthash
        ../ext_src/stb
)
set(GOXEL_SOURCES
		com_aeongames_goxel_Goxel.h
        ../src/action.c
        ../src/assets.c
        ../src/assets.inl
        ../src/block.c
        ../src/box.h
        ../src/camera.c
        ../src/color.c
        ../src/dicom.c
        ../src/goxel.c
        ../src/goxel.h
        ../src/gui.cpp
        ../src/image.c
        ../src/ivec.h
        ../src/mesh.c
        ../src/model3d.c
        ../src/mustache.c
        ../src/palette.c
        ../src/plane.h
        ../src/povray.c
        ../src/procedural.c
        ../src/profiler.c
        ../src/quantization.c
        ../src/qubicle.c
        ../src/render.c
        ../src/save.c
        ../src/shape.c
        ../src/texture.c
        ../src/tools.c
        ../src/utils.c
        ../src/vec.h
        ../src/vox.c
        ../src/wavefront.c
        ../ext_src/imgui/imconfig.h
        ../ext_src/imgui/imgui.cpp
        ../ext_src/imgui/imgui.h
        ../ext_src/imgui/imgui_draw.cpp
        ../ext_src/imgui/imgui_internal.h
        # These seem to need modifications:
        ../src/dialogs.c
        ../src/system.c
        # Main we'll have to reimplement.
        #../src/main.c
        )

set_source_files_properties(../ext_src/imgui/imgui.cpp PROPERTIES COMPILE_FLAGS "-DIMGUI_INCLUDE_IMGUI_USER_INL" )
add_library(goxel SHARED ${GOXEL_SOURCES})
set_target_properties(goxel PROPERTIES COMPILE_FLAGS "-DGLES3")
target_link_libraries(goxel GLESv3 z)
