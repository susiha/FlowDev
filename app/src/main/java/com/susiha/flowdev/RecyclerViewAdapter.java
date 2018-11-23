package com.susiha.flowdev;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * author:  sunshihai
 * createTime:  2018/11/20
 * desc:
 */

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHoder>{


    private ArrayList<String> mData;
    private Context mContext;

    private OnRecycleViewItemClickListener onRecycleViewItemClickListener;
    public RecyclerViewAdapter(ArrayList<String> list,Context context){
        this.mContext = context;
        this.mData = list;
    }

    public void addOnItemClickLinstener(OnRecycleViewItemClickListener listener){
        this.onRecycleViewItemClickListener  = listener;
    }



    @Override
    public ViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_item,parent,false);

        ViewHoder viewHoder = new ViewHoder(view);

        return viewHoder;
    }
    @Override
    public void onBindViewHolder(ViewHoder holder, final int position) {
      final   ViewHoder mViewHolder = holder;

        if(mViewHolder!=null){
            mViewHolder.text.setText(mData.get(position));
        }
        mViewHolder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onRecycleViewItemClickListener!= null){
                    onRecycleViewItemClickListener.onItemClick(v,mViewHolder.text.getText().toString(),position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder{


        TextView text;

        public ViewHoder(View itemView) {
            super(itemView);
            text= itemView.findViewById(R.id.item);
        }
    }
}
