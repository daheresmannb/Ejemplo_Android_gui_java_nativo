package com.example.daniel.ejm_reqlo.componentes;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ViewGroup;

public class LinearLayout extends android.widget.LinearLayout {
    private ViewGroup.LayoutParams params;


    public LinearLayout(Context context) {
        super(context);
    }

    public LinearLayout(Context context, int[] dimenciones, int gravedad, int color, int[] separacion, DisplayMetrics met) {
        super(context);

        params = new ViewGroup.LayoutParams(
                dimenciones[0],
                dimenciones[1]
        );



        this.setPadding(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, separacion[0], met),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, separacion[1], met),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, separacion[2], met),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, separacion[3], met)
        );



        this.setGravity(gravedad);
        this.setBackgroundColor(color);
    }

    public LinearLayout(Context context, int[] dimenciones, int orientacion, int gravedad, int color, int[] separacion, DisplayMetrics met) {
        super(context);

        params = new RelativeLayoutM.LayoutParams(
                dimenciones[0],
                dimenciones[1]
        );

        this.setPadding(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, separacion[0], met),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, separacion[1], met),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, separacion[2], met),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, separacion[3], met)
        );

        this.setOrientation(orientacion);
        this.setGravity(gravedad);
        this.setBackgroundColor(color);
        this.setLayoutParams(params);
    }

    public LinearLayout(Context context, int ori, int grav, int col) {
        super(context);
        this.setOrientation(ori);
        this.setGravity(grav);
        this.setBackgroundColor(col);
    }

    public LinearLayout(Context context, int orientacion, int gravedad, int color, int mipmap) { // contenedor
        super(context);

        params = new RelativeLayoutM.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT
        );

        this.setOrientation(orientacion);
        this.setGravity(gravedad);
        this.setBackgroundColor(color);
        this.setBackgroundDrawable(
                getResources().getDrawable(mipmap)
        );
        this.setLayoutParams(params);
    }
}
