package com.nonexistentware.igor.demoquiz.Common;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class Decoration extends RecyclerView.ItemDecoration {
    private int space;

    public Decoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.left = outRect.right = outRect.bottom = outRect.top = space;
    }
}
