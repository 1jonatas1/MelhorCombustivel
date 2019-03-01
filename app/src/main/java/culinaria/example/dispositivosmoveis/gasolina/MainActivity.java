package culinaria.example.dispositivosmoveis.gasolina;

import android.graphics.drawable.Drawable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private double percent1 = 5.0;
    private double percent2 = 3.0;
    private SeekBar percentSeekBar1;
    private SeekBar percentSeekBar2;
    private TextInputEditText amountInputText;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        percentSeekBar1 = findViewById(R.id.percentSeekBar1);
        percentSeekBar2 = findViewById(R.id.percentSeekBar2);
        imageView = findViewById(R.id.imageView);
        amountInputText = findViewById(R.id.amountTextInputEditLayout);
        percentSeekBar1.setOnSeekBarChangeListener(seekBarChangeListener1);
        percentSeekBar2.setOnSeekBarChangeListener(seekBarChangeListener2);
    }
    private SeekBar.OnSeekBarChangeListener seekBarChangeListener1 =
            new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    percent1 = progress / 10.0;
                    bestFuel();
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            };

    private SeekBar.OnSeekBarChangeListener seekBarChangeListener2 =
            new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    percent2 = progress / 10.0;
                    bestFuel();
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            };

    private void bestFuel(){
        if (percent2/percent1 >= 0.7){
            amountInputText.setHint(getString(R.string.nome_gaso));
            imageView.setImageDrawable((ContextCompat.getDrawable(this,R.drawable.gasolina)));
        }
        else{
            amountInputText.setHint(getString(R.string.nome_etn));
            imageView.setImageDrawable((ContextCompat.getDrawable(this,R.drawable.etanol)));
        }

    }
}
