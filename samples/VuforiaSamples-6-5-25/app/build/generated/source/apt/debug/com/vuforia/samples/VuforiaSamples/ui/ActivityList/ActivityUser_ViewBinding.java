// Generated code from Butter Knife. Do not modify!
package com.vuforia.samples.VuforiaSamples.ui.ActivityList;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.BottomNavigationView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.vuforia.samples.VuforiaSamples.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ActivityUser_ViewBinding implements Unbinder {
  private ActivityUser target;

  private View view2131230765;

  private View view2131230767;

  @UiThread
  public ActivityUser_ViewBinding(ActivityUser target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ActivityUser_ViewBinding(final ActivityUser target, View source) {
    this.target = target;

    View view;
    target.navigation = Utils.findRequiredViewAsType(source, R.id.navigation, "field 'navigation'", BottomNavigationView.class);
    target.tvMark = Utils.findRequiredViewAsType(source, R.id.tvMark, "field 'tvMark'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btnMark, "method 'markClick'");
    view2131230765 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.markClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.btnStart, "method 'startClick'");
    view2131230767 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.startClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ActivityUser target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.navigation = null;
    target.tvMark = null;

    view2131230765.setOnClickListener(null);
    view2131230765 = null;
    view2131230767.setOnClickListener(null);
    view2131230767 = null;
  }
}
