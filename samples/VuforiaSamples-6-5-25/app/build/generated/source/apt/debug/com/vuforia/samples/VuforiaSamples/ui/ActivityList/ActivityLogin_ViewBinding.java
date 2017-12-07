// Generated code from Butter Knife. Do not modify!
package com.vuforia.samples.VuforiaSamples.ui.ActivityList;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.vuforia.samples.VuforiaSamples.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ActivityLogin_ViewBinding implements Unbinder {
  private ActivityLogin target;

  private View view2131230766;

  private View view2131230764;

  @UiThread
  public ActivityLogin_ViewBinding(ActivityLogin target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ActivityLogin_ViewBinding(final ActivityLogin target, View source) {
    this.target = target;

    View view;
    target.etEmail = Utils.findRequiredViewAsType(source, R.id.etEmail, "field 'etEmail'", EditText.class);
    target.etPassword = Utils.findRequiredViewAsType(source, R.id.etPassword, "field 'etPassword'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btnRegister, "method 'registerClick'");
    view2131230766 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.registerClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.btnLogin, "method 'loginClick'");
    view2131230764 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.loginClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ActivityLogin target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.etEmail = null;
    target.etPassword = null;

    view2131230766.setOnClickListener(null);
    view2131230766 = null;
    view2131230764.setOnClickListener(null);
    view2131230764 = null;
  }
}
