// Generated by view binder compiler. Do not edit!
package com.licapps.bmmis.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.licapps.bmmis.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemQuestionUtilBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final MaterialButton detailBTN;

  @NonNull
  public final SwitchCompat quesOptionSwitch;

  @NonNull
  public final TextInputEditText quesResponseET;

  @NonNull
  public final TextInputLayout quesResponseTIL;

  @NonNull
  public final TextView questionTV;

  private ItemQuestionUtilBinding(@NonNull LinearLayout rootView, @NonNull MaterialButton detailBTN,
      @NonNull SwitchCompat quesOptionSwitch, @NonNull TextInputEditText quesResponseET,
      @NonNull TextInputLayout quesResponseTIL, @NonNull TextView questionTV) {
    this.rootView = rootView;
    this.detailBTN = detailBTN;
    this.quesOptionSwitch = quesOptionSwitch;
    this.quesResponseET = quesResponseET;
    this.quesResponseTIL = quesResponseTIL;
    this.questionTV = questionTV;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemQuestionUtilBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemQuestionUtilBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_question_util, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemQuestionUtilBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.detailBTN;
      MaterialButton detailBTN = ViewBindings.findChildViewById(rootView, id);
      if (detailBTN == null) {
        break missingId;
      }

      id = R.id.quesOptionSwitch;
      SwitchCompat quesOptionSwitch = ViewBindings.findChildViewById(rootView, id);
      if (quesOptionSwitch == null) {
        break missingId;
      }

      id = R.id.quesResponseET;
      TextInputEditText quesResponseET = ViewBindings.findChildViewById(rootView, id);
      if (quesResponseET == null) {
        break missingId;
      }

      id = R.id.quesResponseTIL;
      TextInputLayout quesResponseTIL = ViewBindings.findChildViewById(rootView, id);
      if (quesResponseTIL == null) {
        break missingId;
      }

      id = R.id.questionTV;
      TextView questionTV = ViewBindings.findChildViewById(rootView, id);
      if (questionTV == null) {
        break missingId;
      }

      return new ItemQuestionUtilBinding((LinearLayout) rootView, detailBTN, quesOptionSwitch,
          quesResponseET, quesResponseTIL, questionTV);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
