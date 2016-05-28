package com.example.daniel.ejm_reqlo.componentes;

import android.view.ViewGroup;


/**
 * Created by Daniel on 02-05-2016.
 */
public class MibotonFacebook extends LoginButton {
    private ViewGroup.LayoutParams params;
    private StateListDrawable estados_boton;

    public MibotonFacebook(Context context, LinearLayout layout, int alto, DisplayMetrics met) {
        super(context);
        layout.addView(
                this,
                ViewGroup.LayoutParams.MATCH_PARENT,
                new Porcentaje().result(met.widthPixels,alto)
        );


        this.setTextSize(15);
        this.setPadding(100,100,20,20);
    }
}
