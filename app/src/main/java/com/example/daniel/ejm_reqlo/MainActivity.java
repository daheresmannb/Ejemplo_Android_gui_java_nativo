package com.example.daniel.ejm_reqlo;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Daniel on 01-04-2016.
 */
public class MainActivity extends Activity implements View.OnClickListener{

        private LinearLayout contenedor;
        private LinearLayout layout_text;
        private LinearLayout layout_botones;
        private ViewGroup.LayoutParams parametros_Lcontenedor;
        private ViewGroup.LayoutParams parametros_Layouttext;
        private ViewGroup.LayoutParams parametros_Layoutboton;
        private ViewGroup.LayoutParams parametros_boton;
        private StateListDrawable estados_boton;
        private Button miboton;
        private TextView mitexto;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // bloquea giro de pantalla
            DisplayMetrics met = getResources().getDisplayMetrics(); // obtiene dimenciones de la pantalla
            ///////////////////////// inicializar layouts y elementos /////////////////////////////////////
            contenedor = new LinearLayout(this);
            layout_text = new LinearLayout(this);
            layout_botones = new LinearLayout(this);
            mitexto = new TextView(this);
            miboton = new Button(this);
            //////////////////////////////////////////////////////////////////////////////////
            layout_text.setPadding( // setpadding se utiliza para la separacion de los elementos q estan dentro del layout, los los extremos del layout
                    // esto permite modificar el tamaño de los elementos q se encuentran dentro
                    (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 0, met), // izquierda
                    (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 0, met), // al final
                    (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 0, met), // derecha
                    (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 0, met)  // al principio
            );

            layout_botones.setPadding( // setpadding se utiliza para la separacion de los elementos q estan dentro del layout, los los extremos del layout
                    // esto permite modificar el tamaño de los elementos q se encuentran dentro
                    (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 25, met), // izquierda
                    (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 100, met), // al final
                    (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 25, met), // derecha
                    (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 0, met)  // al principio
            );




            /**
              si no funciona  eso hacer lo siguiente

            layout_botones.setPadding(
                    met.widthPixels * 10 / 100,  // izquierda // esto dara el 10% del ancho de la pantalla
                    met.heightPixels * 25, // al final
                    met.widthPixels * 10 / 100, // derecha
                    met.heightPixels * 1 / 100  // al principio
             );

             **/

            //  (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 0, met) redimenciona una cierta medida con respecto
            // a las dimenciones de pantalla para cada celular
            //////////////////////////// fin tamaño y separacion elementos  /////////////////////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////////
            contenedor.setOrientation(LinearLayout.VERTICAL); // hace q los elementos q se agreguen se ubiquen uno debajo del otro
            contenedor.setGravity(Gravity.CENTER);
            contenedor.setBackgroundColor(Color.TRANSPARENT); // en caso de no poner imagen puedes transparencia o algun color
            //////////////////////////// boton ////////////////////////////////////////////////////
            estados_boton = new StateListDrawable(); // se crea un objeto StateListDrawable para agregar dos estados al boton // estado presionado y estado normal
            estados_boton.addState(
                    new int[]{
                            android.R.attr.state_pressed
                    },
                    getResources().getDrawable(
                            R.mipmap.botones_inicio_0000_inicio_sesion_on  /// imagen para el estado presionado
                    )
            );
            estados_boton.addState(
                    new int[]{},
                    getResources().getDrawable(
                            R.mipmap.botones_inicio_0001_inicio_sesion_off /// imagen para el estado NO presionado
                    )
            );

            miboton.setBackgroundDrawable(estados_boton); // y se agregan los estados al boton
            miboton.setOnClickListener(this);
            miboton.setId(1); // se le asigna un id para utilizarlo en el metodo onclik()
            ///////////////////////////////////////////////////////////////////////////////////
            mitexto.setText("chupenla los qlos");
            mitexto.setTextSize(40);
            mitexto.setBackgroundColor(Color.TRANSPARENT); // subrayo de verde el textoo

            layout_text.setGravity(Gravity.CENTER_HORIZONTAL);
            miboton.setGravity(Gravity.CENTER); // gravity sirve para la  ubicacion del elemento dentro del layout
            contenedor.setBackgroundDrawable(getResources().getDrawable(R.mipmap.fondop)); // la asignacion de imagen

            ////////////// AQUIIII SE AGREGAN LOS COMPONENTEEEEEEEEEEEEEEEEEEES!!!!!!!!!!!!!!!!!!!!!!!!! ////////////////////////////////////////////////////////////////
            layout_text.addView(
                    mitexto,
                    ViewGroup.LayoutParams.MATCH_PARENT, // ancho, MATCH_PARENT se usa para q el layout use todo el ancho de la pantalla
                    (met.heightPixels * 50) / 100 // alto, en este caso utilizara el 50% de la pantalla
            );
            layout_text.setGravity(Gravity.CENTER);
            layout_botones.addView(
                    miboton,
                    ViewGroup.LayoutParams.MATCH_PARENT, // ancho, MATCH_PARENT usa todo el ancho hasta las separacion permitida del layout q esta mas abajo //AQUI SE DEFINE EL ANCHO DEL COMPONENTE
                    ViewGroup.LayoutParams.WRAP_CONTENT  // alto, WRAP_CONTENT utiliza el alto que se le asigne manualmente    /// AQUI SE DEFINE EL ALTO DEL COMPONENTE
            );
            contenedor.addView(
                    layout_text,
                    ViewGroup.LayoutParams.MATCH_PARENT, // ancho, MATCH_PARENT se usa para q el layout use todo el ancho de la pantalla
                    (met.heightPixels * 50) / 100 // alto, en este caso utilizara el 50% de la pantalla
            );
            contenedor.addView(
                    layout_botones,
                    ViewGroup.LayoutParams.MATCH_PARENT, // ancho, MATCH_PARENT se usa para q el layout use todo el ancho de la pantalla
                    (met.heightPixels * 50) / 100 // alto, en este caso utilizara el 50% de la pantalla
            );
            setContentView(contenedor);
        }

        @Override
        public void onBackPressed(){ // el metodo onBackPressed() sirve para cuando se preciona el boton para ir atras en el celu
            // en caso de q ocurra se direcciona de la actividad actual a la q se indica en la  linea de abajo
            Intent i = new Intent(this, MainActivity.class); //
            startActivity(i);
            finish();
        }

        @Override
        public void onClick(View v) {
            Intent i;
            switch (v.getId()) {
                case 1:
                    mitexto.setText(mitexto.getText()+" con moco!!!!");
                    Toast.makeText(
                            this,
                            "con mocoo !!!!!!!!!!!!",
                            Toast.LENGTH_LONG
                    ).show();
                    break;
            }
        }
    }
