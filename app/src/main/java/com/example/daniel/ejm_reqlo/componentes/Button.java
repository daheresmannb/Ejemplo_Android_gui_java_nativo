package com.example.daniel.ejm_reqlo.componentes;

/**
 * Created by daniel on 29-04-2016.
 */
import android.content.Context;
import android.graphics.drawable.StateListDrawable;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class Button extends android.widget.Button {
    private StateListDrawable estados_boton;
    private ViewGroup.LayoutParams params;

    public Button(Context context, LinearLayout layout, int draw) {
        super(context);
        this.setBackgroundDrawable(getResources().getDrawable(draw));
        layout.addView(this);
    }



    public Button(Context context, RelativeLayoutM layout, int[] estados_img) {
        super(context);

        estados_boton = new StateListDrawable();
        estados_boton.addState(
                new int[]{
                        android.R.attr.state_pressed
                },
                getResources().getDrawable(
                        estados_img[0]
                )
        );
        estados_boton.addState(
                new int[]{},
                getResources().getDrawable(
                        estados_img[1]
                )
        );
        this.setBackgroundDrawable(estados_boton);
        //this.setBackgroundDrawable(getResources().getDrawable(draw));
        layout.addView(this);
    }

    public Button(Context context, com.example.daniel.ejm_reqlo.componentes.LinearLayout layout, int[] estados_img, int alto, DisplayMetrics met) {
        super(context);


        params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                new Porcentaje().result(met.widthPixels,alto)
        );

        this.setLayoutParams(params);

        estados_boton = new StateListDrawable();
        estados_boton.addState(
                new int[]{
                        android.R.attr.state_pressed
                },
                getResources().getDrawable(
                        estados_img[0]
                )
        );
        estados_boton.addState(
                new int[]{},
                getResources().getDrawable(
                        estados_img[1]
                )
        );
        this.setBackgroundDrawable(estados_boton);
        //this.setBackgroundDrawable(getResources().getDrawable(draw));
        layout.addView(this);
    }
}