// Generated code from Butter Knife. Do not modify!
package com.vuforia.samples.VuforiaSamples.ui.FragmentList;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.vuforia.samples.VuforiaSamples.R;
import de.codecrafters.tableview.SortableTableView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FragmentRanking_ViewBinding implements Unbinder {
  private FragmentRanking target;

  @UiThread
  public FragmentRanking_ViewBinding(FragmentRanking target, View source) {
    this.target = target;

    target.stvRanking = Utils.findRequiredViewAsType(source, R.id.stvRanking, "field 'stvRanking'", SortableTableView.class);
    target.tvNoRanking = Utils.findRequiredViewAsType(source, R.id.tvNoRanking, "field 'tvNoRanking'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FragmentRanking target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.stvRanking = null;
    target.tvNoRanking = null;
  }
}
