package com.yavuzoktay.GithubUser.ui.adapter.adapter.adapter.adapter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.yavuzoktay.GithubUser.R;
import com.yavuzoktay.GithubUser.api.model.GithubRepo;

import java.util.List;

/**
 * Created by Yavuz on 6.7.2017.
 */

public class GithubRepoAdapter extends ArrayAdapter<GithubRepo>{
    private Context context ;
    private List<GithubRepo> values ;

    public  GithubRepoAdapter(Context context, List<GithubRepo> values){
        super(context, R.layout.list_item_pagination,values) ;

        this.context=context ;
        this.values =values ;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView ;
        if(row==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.list_item_pagination,parent,false) ;
        }
        TextView textView = (TextView) row.findViewById(R.id.list_item_pagination_text);
        GithubRepo item = values.get(position) ;
        String message = item.getName() ;
        textView.setText(message);
        return  row;
    }

}