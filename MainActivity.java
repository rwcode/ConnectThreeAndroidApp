package ca.rwang.connectthree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //0 is blue
    //1 is purple
    int activePlayer = 0;
    int [] gameState = {2,2,2,2,2,2,2,2,2};
    int [][] winningPositions = {{0,1,2},{3,4,5},{6,7,8} ,{0,3,6},{2,5,8},{0,4,8},{2,4,6}};

    public void dropIn(View view){

        ImageView counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        if (gameState[tappedCounter] == 2){

            counter.setTranslationY(0f);
            gameState[tappedCounter] = activePlayer;
            if (activePlayer == 0){
                counter.setImageResource(R.drawable.blue);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.purple);
                activePlayer = 0;
            }
            counter.animate().translationY(0f).setDuration(300);

            for(int [] winningPosition : winningPositions){

                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]]  == gameState[winningPosition[2]] &&
                            gameState[winningPosition[0]] != 2 ){

                    String winner = "Purple";
                    if(gameState[winningPosition[0]] == 0){
                        winner = "Blue";
                    }

                    Toast.makeText(getApplicationContext(),"The Winner is "+winner , Toast.LENGTH_SHORT).show();

                }
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
