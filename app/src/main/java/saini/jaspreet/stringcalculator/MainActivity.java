package saini.jaspreet.stringcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editString;
    String numberString;
    TextView numResult;
    ArrayList<String> default_delimiters = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editString = (EditText)findViewById(R.id.editString);
        numResult = (TextView)findViewById(R.id.numResult);
        default_delimiters.add("\n");
        default_delimiters.add(",");
    }

    public void computeResult(View view) {
        numberString = editString.getText().toString();
        numResult.setText(String.valueOf(add(numberString)));
    }
    public static int add(final String numbers) {
        String delimiters = ",|\\n";
        String numbersWithoutDelimiter = numbers;
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("//") + 2;
            delimiters = numbers.substring(delimiterIndex, delimiterIndex + 1);
            numbersWithoutDelimiter = numbers.substring(numbers.indexOf("n") + 1);
        }
        return add(numbersWithoutDelimiter, delimiters);
    }
    private static int add(final String numbers, final String delimiter) {
        int sum = 0;
        String[] numbersArray = numbers.split(delimiter);
        List<Integer> negativeNumbers = new ArrayList<Integer>();
        for (String number : numbersArray) {
            if (!number.trim().isEmpty()) {
                number = number.replaceAll("[\\\\n]", "");
                int numberInt = Integer.parseInt(number.trim());
                if (numberInt < 0) {
                    negativeNumbers.add(numberInt);
                }else if (numberInt <= 1000) {
                    sum += numberInt;
                }
            }
        }
        if (negativeNumbers.size() > 0) {
            throw new RuntimeException("Negatives not allowed: " + negativeNumbers.toString());
        }
        return sum;
    }

}
