package com.susiha.flowdev;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * author:  sunshihai
 * createTime:  2018/11/20
 * desc:
 */

public class RecyclerItemDecoration extends RecyclerView.ItemDecoration {

     Drawable mDrawable;

     int mOrientation;

     public RecyclerItemDecoration(Context context,int orientation){

         mDrawable = context.getResources().getDrawable(R.drawable.recycledived);
         mOrientation = orientation;
     }



    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        if (mOrientation == LinearLayoutManager.HORIZONTAL) {
            drawVertical(c, parent, state);
        } else {
            drawHorizontal(c, parent, state);
        }
    }




    /**
     *  画出垂直线 表示布局是水平的布局
     * @param c
     * @param parent
     * @param state
     */
    private void drawVertical(Canvas c, RecyclerView parent, RecyclerView.State state) {


        for(int i = 0;i< parent.getChildCount();i++){


            View view =  parent.getChildAt(i);


            int left = 0 ;

            int top = 0;

            int right =0;

            int  bottom = 0;

            mDrawable.setBounds(left,top,right,bottom);
            mDrawable.draw(c);

        }
    }

    /**
     *  画出水平线 表示布局是垂直的布局
     * @param c
     * @param parent
     * @param state
     */
    private void drawHorizontal(Canvas c, RecyclerView parent, RecyclerView.State state) {

        int left =0 ;

        int top = 0;

        int right =0;

        int  bottom = 0;

        mDrawable.setBounds(left,top,right,bottom);
        mDrawable.draw(c);
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {



        if(mOrientation == LinearLayoutManager.HORIZONTAL){
            outRect.set(0,0,mDrawable.getIntrinsicWidth(),0);

        }else{
            outRect.set(0,0,0,mDrawable.getIntrinsicHeight());
        }


        super.getItemOffsets(outRect, view, parent, state);

    }
}
