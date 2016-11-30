//HOla
package itchetumal.edu.mx.examenunidad3;


        import android.content.Context;
        import android.graphics.Canvas;
        import android.graphics.Color;
        import android.graphics.Paint;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MotionEvent;
        import android.view.View;
        import android.widget.RelativeLayout;
        import android.widget.Toast;

        import java.util.Random;

public class MainActivity extends AppCompatActivity{

    float y =1;
    float x =1;
    int puntos =0;
    float x1;
    float y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DownView DV = new DownView(this);
        setContentView(DV);
    }

    class DownView extends View {

        public DownView(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.WHITE);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.RED);
            canvas.drawCircle(x, y, 20, paint);

            //Movimiento aleatorio del tiro al blanco, bueno un intento
            paint.setStyle(Paint.Style.STROKE);
            Circulos();
            paint.setColor((Color.BLACK));
            canvas.drawCircle(500, 500, 200, paint);

            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.BLUE);
            paint.setTextSize(20);

            canvas.drawText("Puntos: " + puntos, 10, 25, paint);
            canvas.drawText("x=" + x + ": " + x1, 80, 50, paint);
            canvas.drawText("y=" + y + " " + y2, 80, 70, paint);
        }

        private void Circulos() {

            Random ran=new Random();
            x1=(ran.nextInt(200-40+1)+40);
            y2=(ran.nextInt(260-30+1)+30);
        }

        public boolean onTouchEvent(MotionEvent evento) {
            if (evento.getAction() == MotionEvent.ACTION_DOWN) {
                x = (int) evento.getX();
                y = (int) evento.getY();

                if (x >= x1 - 5 && x1 <= x1 + 5) {
                    if (y >= y2 - 5 && y2 <= y2 + 5) {
                        mensage();
                    }
                }
                invalidate();
            }

            return false;
        }

        private void mensage() {
            Context context = getApplicationContext();
            CharSequence text = "Ganaste 10 puntos";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}