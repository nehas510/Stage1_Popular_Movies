package com.example.neha.p1_popularmovies;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;

/**
 * Created by neha on 7/14/16.
 */
public class SpinnerProgressBar extends Dialog {
    private ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);


    public SpinnerProgressBar(Context context) {
        super(context);
        init(context);
    }


    public static SpinnerProgressBar create(Context context) {
        SpinnerProgressBar spinnerProgressBar = new SpinnerProgressBar(context);
        return spinnerProgressBar;
    }

    public static SpinnerProgressBar show(Context context) {
        SpinnerProgressBar spinnerProgressBar = SpinnerProgressBar.create(context);
        spinnerProgressBar.show();
        return spinnerProgressBar;
    }

    private void init(Context context) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().addFlags(android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        ProgressBar view = new ProgressBar(context);
        addContentView(view, params);
        setCancelable(false);
    }

}
