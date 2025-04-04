// Generated by view binder compiler. Do not edit!
package com.licapps.bmmis.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.licapps.bmmis.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class LayoutShimmerResoBinding implements ViewBinding {
  @NonNull
  private final ShimmerFrameLayout rootView;

  @NonNull
  public final ShimmerFrameLayout shimmerLayout;

  private LayoutShimmerResoBinding(@NonNull ShimmerFrameLayout rootView,
      @NonNull ShimmerFrameLayout shimmerLayout) {
    this.rootView = rootView;
    this.shimmerLayout = shimmerLayout;
  }

  @Override
  @NonNull
  public ShimmerFrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutShimmerResoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutShimmerResoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_shimmer_reso, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutShimmerResoBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    ShimmerFrameLayout shimmerLayout = (ShimmerFrameLayout) rootView;

    return new LayoutShimmerResoBinding((ShimmerFrameLayout) rootView, shimmerLayout);
  }
}
