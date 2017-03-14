package mn.signlanguage.widgets;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;

import java.util.List;

/**
 * Created by Tortuvshin Byambaa on 2/18/2017.
 */

public class CircleMenu extends ViewGroup {
    private List<View> childViewsList;
    private float downX;
    private float downY;
    private float offsetAngle;
    private float preOffsetAngle;
    private float lastAngle;
    private View firstView;
    private GestureDetectorCompat detectorCompat;
    private Scroller mScroller;
    private float flingAngle;
    private boolean flingClockWise;

    public CircleMenu(Context context) {
        super(context);
        initData();
    }

    public CircleMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        initData();
    }

    public CircleMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData();
    }

    public void setChildViewsList(List<View> childViewsList) {
        this.childViewsList = childViewsList;
        for (View view : this.childViewsList) {
            addView(view);
        }

        firstView = getChildAt(0);
        requestLayout();
    }

    private void initData() {
        GestureDetector.SimpleOnGestureListener gestureListener = new FlingListener();
        detectorCompat = new GestureDetectorCompat(getContext(), gestureListener);
        mScroller = new Scroller(getContext());
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        int minHeight = 100;
        int minWidth = 100;

        setMeasuredDimension(resolveSize(minWidth, widthMeasureSpec), resolveSize(minHeight,
                heightMeasureSpec));
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int count = getChildCount();
        float eachAngle = (float) (2 * Math.PI / count);
        for (int i = 0; i < count; i++) {
            View thisView = getChildAt(i);
            float thisAngle = i * eachAngle + offsetAngle + lastAngle + flingAngle;

            int anchor = thisView.getMeasuredWidth() > thisView.getMeasuredHeight() ?
                    thisView.getMeasuredWidth() : thisView.getMeasuredHeight();

            float x = (float) (Math.cos(thisAngle) *
                    ((getMeasuredWidth() - anchor) / 2.0f))
                    + getMeasuredWidth() / 2.0f
                    - thisView.getMeasuredWidth() / 2;
            float y = getMeasuredHeight() / 2.0f
                    - (float) (Math.sin(thisAngle) *
                    ((getMeasuredHeight() - anchor) / 2.0f))
                    - thisView.getMeasuredHeight() / 2;

            thisView.layout((int) x, (int) y, (int) x + thisView.getMeasuredWidth(), (int) y +
                    getMeasuredHeight());
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        mScroller.forceFinished(true);
        int type = MotionEventCompat.getActionMasked(ev);
        float currentX = MotionEventCompat.getX(ev, 0);
        float currentY = MotionEventCompat.getY(ev, 0);

        switch (type) {
            case MotionEvent.ACTION_DOWN:
                downX = currentX;
                downY = currentY;

                float x = firstView.getX() + firstView.getMeasuredWidth() / 2.0f;
                float y = firstView.getY() + firstView.getMeasuredHeight() / 2.0f;

                lastAngle = (float) getRelativeAngle(x, y);
                break;
            case MotionEvent.ACTION_MOVE:
                float distance = getDistance(downX, downY, currentX, currentY);
                if (distance > ViewConfiguration.getTouchSlop()) {
                    return true;
                }
                break;
            case MotionEvent.ACTION_UP:

                break;
        }

        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        flingAngle = 0;

        boolean revl = detectorCompat.onTouchEvent(event);
        if (revl) {
            return revl;
        }

        int type = MotionEventCompat.getActionMasked(event);
        float currentX = MotionEventCompat.getX(event, 0);
        float currentY = MotionEventCompat.getY(event, 0);

        double deltaAngle = getRelativeAngle(currentX, currentY) - getRelativeAngle(downX, downY);
        preOffsetAngle = offsetAngle;
        offsetAngle = (float) deltaAngle;

        switch (type) {
            case MotionEvent.ACTION_MOVE:
                requestLayout();
                break;
        }

        return true;
    }

    private double getRelativeAngle(float x, float y) {
        float mCos = (x - getMeasuredWidth() / 2.0f) / getDistance(x, y, getMeasuredWidth() / 2.0f,
                getMeasuredHeight() / 2.0f);
        double angleR = Math.acos(mCos);
//        double angleD = Math.toDegrees(angleR);
        if (y > getMeasuredHeight() / 2.0f) {
            angleR = 2*Math.PI - angleR;
        }
        return angleR;
    }

    private float getDistance(float x1, float y1, float x2, float y2) {
        double distance = Math.hypot(x1 - x2, y1 - y2);
        return (float) distance;
    }

    class FlingListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            flingClockWise = offsetAngle <= preOffsetAngle;
            mScroller.fling(0, 0, (int) velocityX, (int) velocityY, -10000, 10000, -10000, 10000);
            requestLayout();
            return true;
        }
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            int x = mScroller.getCurrX();
            int y = mScroller.getCurrY();
            float distance = getDistance(x, y, 0, 0);

            float radius = getMeasuredWidth() / 2.0f;
            float radian = distance / radius;
            if (flingClockWise) {
                radian = -radian;
            }
            flingAngle = radian;
            requestLayout();
        }
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);
        ss.stateToSave = lastAngle + offsetAngle;
        return ss;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());

        lastAngle = ss.stateToSave;
    }

    static class SavedState extends BaseSavedState {
        float stateToSave;

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            this.stateToSave = in.readFloat();
        }

        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeFloat(this.stateToSave);
        }

        //required field that makes Parcelables from a Parcel
        public static final Parcelable.Creator<SavedState> CREATOR =
                new Parcelable.Creator<SavedState>() {
                    public SavedState createFromParcel(Parcel in) {
                        return new SavedState(in);
                    }

                    public SavedState[] newArray(int size) {
                        return new SavedState[size];
                    }
                };
    }
}