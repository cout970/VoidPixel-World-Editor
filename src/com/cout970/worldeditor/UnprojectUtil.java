package com.cout970.worldeditor;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.vector.Vector3f;

public class UnprojectUtil {
       
 
        public static Vector3f unproject(int mouseX, int mouseY){
                Vector3f v1 = unproject(mouseX, mouseY, 0);
                Vector3f v2 = unproject(mouseX, mouseY, 1);
                Vector3f normalized = new Vector3f(v2.x - v1.x, v2.y - v1.y, v2.z - v1.z );
                return normalized;
        }
       
 
        public static Vector3f unproject(int mouseX, int mouseY, float depth){
                IntBuffer viewport = BufferUtils.createIntBuffer(16);
                FloatBuffer modelView = BufferUtils.createFloatBuffer(16);
                FloatBuffer projectionView = BufferUtils.createFloatBuffer(16);
                float winX = mouseX;
                float winY = mouseY;
                FloatBuffer position = BufferUtils.createFloatBuffer(3);               

                GLManager.instance.preRender();
                GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, modelView);
                GL11.glGetFloat(GL11.GL_PROJECTION_MATRIX, projectionView);
                GL11.glGetInteger(GL11.GL_VIEWPORT, viewport);
                
                winY = viewport.get(3) - mouseY; // due to inverted coords
                GLU.gluUnProject(winX, winY, depth, modelView, projectionView, viewport, position);
                position.rewind();
                Vector3f result = new Vector3f(position.get(0), -position.get(1), position.get(2));
                GLManager.instance.posRender();
                return result;
        }

       
}