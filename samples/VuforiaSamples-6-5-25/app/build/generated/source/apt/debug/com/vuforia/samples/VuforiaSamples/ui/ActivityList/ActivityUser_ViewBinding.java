// Generated code from Butter Knife. Do not modify!
package com.vuforia.samples.VuforiaSamples.ui.ActivityList;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.BottomNavigationView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.vuforia.samples.VuforiaSamples.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ActivityUser_ViewBinding implements Unbinder {
  private ActivityUser target;

  @UiThread
  public ActivityUser_ViewBinding(ActivityUser target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ActivityUser_ViewBinding(ActivityUser target, View source) {
    this.target = target;

    target.navigation = Utils.findRequiredViewAsType(source, R.id.navigation, "field 'navigation'", BottomNavigationView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ActivityUser target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.navigation = null;
  }
}
