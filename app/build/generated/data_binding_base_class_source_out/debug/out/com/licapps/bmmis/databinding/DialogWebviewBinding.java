// Generated by view binder compiler. Do not edit!
package com.licapps.bmmis.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.licapps.bmmis.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DialogWebviewBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final WebView infoTextWV;

  private DialogWebviewBinding(@NonNull ConstraintLayout rootView, @NonNull WebView infoTextWV) {
    this.rootView = rootView;
    this.infoTextWV = infoTextWV;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogWebviewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogWebviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_webview, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogWebviewBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.infoTextWV;
      WebView infoTextWV = ViewBindings.findChildViewById(rootView, id);
      if (infoTextWV == null) {
        break missingId;
      }

      return new DialogWebviewBinding((ConstraintLayout) rootView, infoTextWV);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
