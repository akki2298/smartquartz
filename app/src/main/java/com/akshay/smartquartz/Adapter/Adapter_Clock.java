package com.akshay.smartquartz.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.akshay.smartquartz.Bean.Bean_clock;
import com.akshay.smartquartz.Desgin.FullscreenClockActivity;
import com.akshay.smartquartz.R;

import java.util.ArrayList;

public class Adapter_Clock extends RecyclerView.Adapter<Adapter_Clock.MyOwnHolder> {

        ArrayList<Bean_clock> arrayclock;
        Context ctx;

public Adapter_Clock(Context ct, ArrayList<Bean_clock> arrayclock) {
        ctx = ct;
        this.arrayclock = arrayclock;
        }


@Override
public Adapter_Clock.MyOwnHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater myInflater = LayoutInflater.from(ctx);
        View MyOwnView = myInflater.inflate(R.layout.clock_list, parent, false);
         MyOwnView.setOnClickListener(new Adapter_Clock.MyOnClickListener());
        return new Adapter_Clock.MyOwnHolder(MyOwnView);


        }

@Override
public void onBindViewHolder(Adapter_Clock.MyOwnHolder holder, int position) {

        holder.tvID.setText(arrayclock.get(position).getTID() + "");


        holder.tvModel.setText(arrayclock.get(position).getModel_No());
        holder.tvSize.setText(arrayclock.get(position).getSize_l()+" X "+arrayclock.get(position).getSize_b()+" X "+arrayclock.get(position).getSize_h()+" mm");
       String image=arrayclock.get(position).getImage();
    if(image.isEmpty())
    {
        holder.imgclock.setImageResource(R.drawable.no_image);

    }
    else{

        String uri="@drawable/"+image;
        int imageResource=ctx.getResources().getIdentifier(uri,null,ctx.getPackageName());
        Drawable res=ctx.getResources().getDrawable(imageResource);
        holder.imgclock.setImageDrawable(res);

    }

    // holder.tvAction.setText(arrayclock.get(position).getAction());



       /* if (arrayformlist.get(position).getFormID() % 2 == 0) {
            holder.ll.setBackgroundResource(R.color.light_gray);
        } else {
            holder.ll.setBackgroundResource(R.color.white);     String uri="@drawable/"+image;
        int imageResource=ctx.getResources().getIdentifier(uri,null,ctx.getPackageName());
        Drawable res=ctx.getResources().getDrawable(imageResource);
        holder.imgclock.setImageDrawable(res);
        }
*/

        }

@Override
public int getItemCount() {
        return arrayclock.size();
        }

public class MyOwnHolder extends RecyclerView.ViewHolder {

    public TextView tvID, tvModel, tvSize,tvAction;
    ImageView imgclock;
    LinearLayout ll;

    public MyOwnHolder(View view) {

        super(view);
        tvID = (TextView) view.findViewById(R.id.list_clock_Id);
        tvModel = (TextView) view.findViewById(R.id.model);
        tvSize=(TextView)view.findViewById(R.id.Size);
        imgclock=(ImageView)view.findViewById(R.id.img_clock);
      //  tvAction=(TextView)view.findViewById(R.id.list_comparisons_action);

        //   ll = (LinearLayout) view.findViewById(R.id.list_formlist_ll);
    }

}

    public class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String id = ((TextView)view.findViewById(R.id.list_clock_Id)).getText().toString();

            Intent in = new Intent(ctx, FullscreenClockActivity.class);
            in.putExtra("ID", id);
            for (int j = 0; j < arrayclock.size(); j++) {

                if (arrayclock.get(j).getTID() == Integer.parseInt(id)) {

                    in.putExtra("Title", arrayclock.get(j).getImage());


                }
            }

            // Toast.makeText(ctx, "ID"+id, Toast.LENGTH_SHORT).show();

            ctx.startActivity(in);
        }
    }

}


