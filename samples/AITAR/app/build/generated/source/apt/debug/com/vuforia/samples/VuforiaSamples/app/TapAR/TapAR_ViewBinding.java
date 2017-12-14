// Generated code from Butter Knife. Do not modify!
package com.vuforia.samples.VuforiaSamples.app.TapAR;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.vuforia.samples.VuforiaSamples.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TapAR_ViewBinding implements Unbinder {
  private TapAR target;

  private View view2131230763;

  @UiThread
  public TapAR_ViewBinding(TapAR target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TapAR_ViewBinding(final TapAR target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btnAttack, "method 'attackClick'");
    view2131230763 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.attackClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view2131230763.setOnClickListener(null);
    view2131230763 = null;
  }
}
