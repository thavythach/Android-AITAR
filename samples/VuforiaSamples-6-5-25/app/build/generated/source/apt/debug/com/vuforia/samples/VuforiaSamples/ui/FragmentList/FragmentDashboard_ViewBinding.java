// Generated code from Butter Knife. Do not modify!
package com.vuforia.samples.VuforiaSamples.ui.FragmentList;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.vuforia.samples.VuforiaSamples.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FragmentDashboard_ViewBinding implements Unbinder {
  private FragmentDashboard target;

  private View view2131230768;

  private View view2131230766;

  @UiThread
  public FragmentDashboard_ViewBinding(final FragmentDashboard target, View source) {
    this.target = target;

    View view;
    target.tvName = Utils.findRequiredViewAsType(source, R.id.tvName, "field 'tvName'", TextView.class);
    target.tvKills = Utils.findRequiredViewAsType(source, R.id.tvKills, "field 'tvKills'", TextView.class);
    target.tvDeaths = Utils.findRequiredViewAsType(source, R.id.tvDeaths, "field 'tvDeaths'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btnStart, "field 'btnStart' and method 'startClick'");
    target.btnStart = Utils.castView(view, R.id.btnStart, "field 'btnStart'", Button.class);
    view2131230768 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.startClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.btnMark, "method 'markClick'");
    view2131230766 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.markClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    FragmentDashboard target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvName = null;
    target.tvKills = null;
    target.tvDeaths = null;
    target.btnStart = null;

    view2131230768.setOnClickListener(null);
    view2131230768 = null;
    view2131230766.setOnClickListener(null);
    view2131230766 = null;
  }
}
