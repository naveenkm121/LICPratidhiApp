// Generated by view binder compiler. Do not edit!
package com.licapps.bmmis.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textview.MaterialTextView;
import com.licapps.bmmis.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentPlanPerfBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final MaterialTextView agentHeadingMTV;

  @NonNull
  public final RecyclerView casesRV;

  @NonNull
  public final CardView headerCV;

  @NonNull
  public final ImageView noResultIV;

  @NonNull
  public final MaterialTextView nopHeadingMTV;

  @NonNull
  public final MaterialTextView nspHeadingMTV;

  @NonNull
  public final MaterialTextView planIdMTV;

  @NonNull
  public final LayoutInvisibleProgressBarBinding progressBar;

  @NonNull
  public final LayoutShimmerLineBinding progressBarShim;

  @NonNull
  public final MaterialTextView spHeadingTV;

  @NonNull
  public final MaterialTextView tfpHeadingMTV;

  private FragmentPlanPerfBinding(@NonNull RelativeLayout rootView,
      @NonNull MaterialTextView agentHeadingMTV, @NonNull RecyclerView casesRV,
      @NonNull CardView headerCV, @NonNull ImageView noResultIV,
      @NonNull MaterialTextView nopHeadingMTV, @NonNull MaterialTextView nspHeadingMTV,
      @NonNull MaterialTextView planIdMTV, @NonNull LayoutInvisibleProgressBarBinding progressBar,
      @NonNull LayoutShimmerLineBinding progressBarShim, @NonNull MaterialTextView spHeadingTV,
      @NonNull MaterialTextView tfpHeadingMTV) {
    this.rootView = rootView;
    this.agentHeadingMTV = agentHeadingMTV;
    this.casesRV = casesRV;
    this.headerCV = headerCV;
    this.noResultIV = noResultIV;
    this.nopHeadingMTV = nopHeadingMTV;
    this.nspHeadingMTV = nspHeadingMTV;
    this.planIdMTV = planIdMTV;
    this.progressBar = progressBar;
    this.progressBarShim = progressBarShim;
    this.spHeadingTV = spHeadingTV;
    this.tfpHeadingMTV = tfpHeadingMTV;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentPlanPerfBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentPlanPerfBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_plan_perf, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentPlanPerfBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.agentHeadingMTV;
      MaterialTextView agentHeadingMTV = ViewBindings.findChildViewById(rootView, id);
      if (agentHeadingMTV == null) {
        break missingId;
      }

      id = R.id.casesRV;
      RecyclerView casesRV = ViewBindings.findChildViewById(rootView, id);
      if (casesRV == null) {
        break missingId;
      }

      id = R.id.headerCV;
      CardView headerCV = ViewBindings.findChildViewById(rootView, id);
      if (headerCV == null) {
        break missingId;
      }

      id = R.id.noResultIV;
      ImageView noResultIV = ViewBindings.findChildViewById(rootView, id);
      if (noResultIV == null) {
        break missingId;
      }

      id = R.id.nopHeadingMTV;
      MaterialTextView nopHeadingMTV = ViewBindings.findChildViewById(rootView, id);
      if (nopHeadingMTV == null) {
        break missingId;
      }

      id = R.id.nspHeadingMTV;
      MaterialTextView nspHeadingMTV = ViewBindings.findChildViewById(rootView, id);
      if (nspHeadingMTV == null) {
        break missingId;
      }

      id = R.id.planIdMTV;
      MaterialTextView planIdMTV = ViewBindings.findChildViewById(rootView, id);
      if (planIdMTV == null) {
        break missingId;
      }

      id = R.id.progress_bar;
      View progressBar = ViewBindings.findChildViewById(rootView, id);
      if (progressBar == null) {
        break missingId;
      }
      LayoutInvisibleProgressBarBinding binding_progressBar = LayoutInvisibleProgressBarBinding.bind(progressBar);

      id = R.id.progress_bar_shim;
      View progressBarShim = ViewBindings.findChildViewById(rootView, id);
      if (progressBarShim == null) {
        break missingId;
      }
      LayoutShimmerLineBinding binding_progressBarShim = LayoutShimmerLineBinding.bind(progressBarShim);

      id = R.id.spHeadingTV;
      MaterialTextView spHeadingTV = ViewBindings.findChildViewById(rootView, id);
      if (spHeadingTV == null) {
        break missingId;
      }

      id = R.id.tfpHeadingMTV;
      MaterialTextView tfpHeadingMTV = ViewBindings.findChildViewById(rootView, id);
      if (tfpHeadingMTV == null) {
        break missingId;
      }

      return new FragmentPlanPerfBinding((RelativeLayout) rootView, agentHeadingMTV, casesRV,
          headerCV, noResultIV, nopHeadingMTV, nspHeadingMTV, planIdMTV, binding_progressBar,
          binding_progressBarShim, spHeadingTV, tfpHeadingMTV);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
