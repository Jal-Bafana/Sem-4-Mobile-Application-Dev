package com.example.k005_lab6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;

public class DrawingView extends View {
    private ArrayList<Path> paths = new ArrayList<>();  // Store all paths drawn
    private ArrayList<Paint> paints = new ArrayList<>();  // Store the paints used for each path
    private Path currentPath;
    private Paint currentPaint;

    public DrawingView(Context context) {
        super(context);
        init();
    }

    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        // Initialize the current path and paint
        currentPath = new Path();
        currentPaint = new Paint();
        currentPaint.setColor(0xFF000000);  // Default color (Black)
        currentPaint.setStrokeWidth(5f);     // Set the stroke width
        currentPaint.setStyle(Paint.Style.STROKE);  // Set the paint style to stroke
        currentPaint.setAntiAlias(true);     // Enable anti-aliasing
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // Draw all the paths
        for (int i = 0; i < paths.size(); i++) {
            canvas.drawPath(paths.get(i), paints.get(i));  // Draw each path with its respective paint
        }
        // Draw the current path being drawn
        canvas.drawPath(currentPath, currentPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                currentPath = new Path();  // Start a new path
                currentPath.moveTo(x, y);
                return true;
            case MotionEvent.ACTION_MOVE:
                currentPath.lineTo(x, y);  // Draw a line to the new touch point
                break;
            case MotionEvent.ACTION_UP:
                // When the user lifts their finger, save the current path and paint
                paths.add(currentPath);
                paints.add(currentPaint);
                break;
            default:
                return false;
        }
        invalidate();  // Redraw the view
        return true;
    }

    // Method to clear the drawing
    public void clear() {
        paths.clear();  // Clear the list of paths
        paints.clear(); // Clear the list of paints
        invalidate();   // Redraw the view
    }

    // Method to set the pen color
    public void setPenColor(int color) {
        currentPaint.setColor(color);  // Change the paint color for the current path
    }
}
