// Generated code from Butter Knife. Do not modify!
package com.vuforia.samples.VuforiaSamples.ui.FragmentList;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.github.mikephil.charting.charts.PieChart;
import com.vuforia.samples.VuforiaSamples.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FragmentDashboard_ViewBinding implements Unbinder {
  private FragmentDashboard target;

  private View view2131230763;

  private View view2131230765;

  @UiThread
  public FragmentDashboard_ViewBinding(final FragmentDashboard target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btnMark, "field 'btnMark' and method 'markClick'");
    target.btnMark = Utils.castView(view, R.id.btnMark, "field 'btnMark'", Button.class);
    view2131230763 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.markClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.btnStart, "field 'btnStart' and method 'startClick'");
    target.btnStart = Utils.castView(view, R.id.btnStart, "field 'btnStart'", Button.class);
    view2131230765 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.startClick();
      }
    });
    target.pcStats = Utils.findRequiredViewAsType(source, R.id.pcStats, "field 'pcStats'", PieChart.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FragmentDashboard target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnMark = null;
    target.btnStart = null;
    target.pcStats = null;

    view2131230763.setOnClickListener(null);
    view2131230763 = null;
    view2131230765.setOnClickListener(null);
    view2131230765 = null;
  }
}
