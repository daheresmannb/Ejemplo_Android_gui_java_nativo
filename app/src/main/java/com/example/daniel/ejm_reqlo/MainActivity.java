package com.example.daniel.ejm_reqlo;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
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

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.widget.LoginButton;

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
            FacebookSdk.sdkInitialize(getApplicationContext());
            AppEventsLogger.activateApp(this);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // bloquea giro de pantalla
            DisplayMetrics met = getResources().getDisplayMetrics(); // obtiene dimenciones de la pantalla

            ///////////////////////// inicializar layouts y elementos /////////////////////////////////////
            contenedor = new LinearLayout(this);
            layout_text = new LinearLayout(this);
            layout_botones = new LinearLayout(this);
            mitexto = new TextView(this);
            miboton = new Button(this);
            LoginButton g ;

            //////////////////////////////////////////////////////////////////////////////////
            //////////////////////////// parametros layout /////////////////////////////////////////////////////
            parametros_Lcontenedor = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, // ancho, MATCH_PARENT se usa para q el layout use todo el ancho de la pantalla
                    ViewGroup.LayoutParams.MATCH_PARENT // alto
            );

            parametros_Layouttext = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, // ancho, MATCH_PARENT se usa para q el layout use todo el ancho de la pantalla
                    (met.heightPixels * 50) / 100 // alto, en este caso utilizara el 50% de la pantalla
            );
            parametros_Layoutboton =  new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, // ancho, MATCH_PARENT se usa para q el layout use todo el ancho de la pantalla
                    (met.heightPixels * 50) / 100 // alto, en este caso utilizara el 50% de la pantalla
            );
            //////////////////////////// fin parametros layout /////////////////////////////////////////////////////
            //////////////////////////// parametros elementos /////////////////////////////////////////////////////

            parametros_boton = new ViewGroup.LayoutParams( // al darle sus propios parametros al botos se adapta a los parametros del layout
                    ViewGroup.LayoutParams.MATCH_PARENT, // ancho, MATCH_PARENT usa todo el ancho hasta las separacion permitida del layout q esta mas abajo
                    ViewGroup.LayoutParams.WRAP_CONTENT  // alto, WRAP_CONTENT utiliza el alto que se le asigne manualmente
            );

            parametros_boton.height = (met.heightPixels * 10) / 100; // ancho de boton al 10% de la pantalla
            miboton.setLayoutParams(parametros_boton);


            //////////////////////////// tamaño y separacion elementos  ///////////////////////////////////////
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
            //  (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 0, met) redimenciona una cierta medida con respecto
            // a las dimenciones de pantalla para cada celular
            //////////////////////////// fin tamaño y separacion elementos  /////////////////////////////////
            //////////////////////////// setiar parametros layouts ////////////////////////////////////
            contenedor.setLayoutParams(parametros_Lcontenedor);
            layout_text.setLayoutParams(parametros_Layouttext);
            layout_botones.setLayoutParams(parametros_Layoutboton);
            layout_botones.setBackgroundColor(Color.TRANSPARENT);
            ////////////////////////////////////////////////////////////////////////////////////////////////
            contenedor.setOrientation(LinearLayout.VERTICAL); // hace q los elementos q se agreguen se ubiquen uno debajo del otro
            contenedor.setGravity(Gravity.CENTER);
            contenedor.setBackgroundColor(Color.TRANSPARENT); // en caso de no poner imagen puedes transparencia o algun color
            //////////////////////////// boton ////////////////////////////////////////////////////
            estados_boton = new StateListDrawable();
            estados_boton.addState(
                    new int[]{
                            android.R.attr.state_pressed
                    },
                    getResources().getDrawable(
                            R.mipmap.botones_inicio_0000_inicio_sesion_on
                    )
            );
            estados_boton.addState(
                    new int[]{},
                    getResources().getDrawable(
                            R.mipmap.botones_inicio_0001_inicio_sesion_off
                    )
            );
            miboton.setBackgroundDrawable(estados_boton);
            miboton.setOnClickListener(this);
            miboton.setId(1); // se le asigna un id para utilizarlo en el metodo onclik()
            mitexto.setText("chupenla los qlos");
            mitexto.setTextSize(40);
            mitexto.setBackgroundColor(Color.GREEN); // subrayo de verde el texto
            layout_text.setGravity(Gravity.CENTER);
            miboton.setGravity(Gravity.CENTER); // gravity sirve para la  ubicacion del elemento dentro del layout
            contenedor.setBackgroundDrawable(getResources().getDrawable(R.mipmap.fondop)); // la asignacion de imagen deber despues de todo xq sino no toma
            //////////////////////////////////////////////////////////////////////////////
            layout_text.addView(mitexto);
            layout_botones.addView(miboton);
            contenedor.addView(layout_text);
            contenedor.addView(layout_botones);
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
