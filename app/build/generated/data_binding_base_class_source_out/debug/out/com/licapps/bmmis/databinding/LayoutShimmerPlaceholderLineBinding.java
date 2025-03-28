// Generated by view binder compiler. Do not edit!
package com.licapps.bmmis.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.licapps.bmmis.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class LayoutShimmerPlaceholderLineBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  private LayoutShimmerPlaceholderLineBinding(@NonNull CardView rootView) {
    this.rootView = rootView;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutShimmerPlaceholderLineBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutShimmerPlaceholderLineBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_shimmer_placeholder_line, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutShimmerPlaceholderLineBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    return new LayoutShimmerPlaceholderLineBinding((CardView) rootView);
  }
}
