package com.example.puzzle;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.puzzle.databinding.PuzzleBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    PuzzleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = PuzzleBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setbtn(binding.b1);
        setbtn(binding.b2);
        setbtn(binding.b3);
        setbtn(binding.b4);
        setbtn(binding.b5);
        setbtn(binding.b6);
        setbtn(binding.b7);
        setbtn(binding.b8);
        setbtn(binding.b9);


        binding.restart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ArrayList<String> numberlist = new ArrayList<String>();

                while(numberlist.size() < 9)
                {
                    int a = (int) (Math.random() * 9);
                    if (!numberlist.contains(String.valueOf(a)))
                    {
                        numberlist.add(String.valueOf(a));
                    }
                }
                Log.e("+++", "onCreate: "+numberlist);
                binding.b1.setText(numberlist.get(0).equals("0") ? "" : numberlist.get(0));
                binding.b2.setText(numberlist.get(1).equals("0") ? "" : numberlist.get(1));
                binding.b4.setText(numberlist.get(2).equals("0") ? "" : numberlist.get(2));
                binding.b3.setText(numberlist.get(3).equals("0") ? "" : numberlist.get(3));
                binding.b5.setText(numberlist.get(4).equals("0") ? "" : numberlist.get(4));
                binding.b6.setText(numberlist.get(5).equals("0") ? "" : numberlist.get(5));
                binding.b7.setText(numberlist.get(6).equals("0") ? "" : numberlist.get(6));
                binding.b8.setText(numberlist.get(7).equals("0") ? "" : numberlist.get(7));
                binding.b9.setText(numberlist.get(8).equals("0") ? "" : numberlist.get(8));
                numberlist.clear();
                binding.win.setText("");
            }
        });
        }

    void setbtn(Button btn)
    {
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (binding.win.getText().toString().isEmpty())
                {
                    if (btn == binding.b1)
                    {
                        check(binding.b1, binding.b2);
                        check(binding.b1, binding.b4);
                    } else if (btn == binding.b2)
                    {
                        check(binding.b2, binding.b1);
                        check(binding.b2, binding.b3);
                        check(binding.b2, binding.b5);
                    } else if (btn == binding.b3)
                    {
                        check(binding.b3, binding.b2);
                        check(binding.b3, binding.b6);
                        check(binding.b3, binding.b5);
                    } else if (btn == binding.b4)
                    {
                        check(binding.b4, binding.b1);
                        check(binding.b4, binding.b5);
                        check(binding.b4, binding.b7);
                    } else if (btn == binding.b5)
                    {
                        check(binding.b5, binding.b2);
                        check(binding.b5, binding.b4);
                        check(binding.b5, binding.b6);
                        check(binding.b5, binding.b8);
                    } else if (btn == binding.b6)
                    {
                        check(binding.b6, binding.b3);
                        check(binding.b6, binding.b5);
                        check(binding.b6, binding.b9);
                    } else if (btn == binding.b7)
                    {
                        check(binding.b7, binding.b4);
                        check(binding.b7, binding.b8);
                        check(binding.b7, binding.b5);
                    }
                    else if (btn == binding.b8)
                    {
                        check(binding.b8, binding.b5);
                        check(binding.b8, binding.b7);
                        check(binding.b8, binding.b9);
                    }
                    else if (btn == binding.b9)
                    {
                        check(binding.b9, binding.b6);
                        check(binding.b9, binding.b8);
                    }
                    win();
                }
            }
        });
    }
    void win()
    {
        if (binding.b1.getText().toString().equals("1") && binding.b2.getText().toString().equals("2")  && binding.b3.getText().toString().equals("3") && binding.b4.getText().toString().equals("4") && binding.b5.getText().toString().equals("5") && binding.b6.getText().toString().equals("6") && binding.b7.getText().toString().equals("7") && binding.b8.getText().toString().equals("8"))
        {
            binding.win.setText("Winner");
        }
    }

    private void check(Button b1, Button b2)
    {
        if (b2.getText().toString().isEmpty())
        {
            b2.setText(b1.getText());
            b1.setText("");
        }
    }
}






//method 2
// if (btn == binding.b1) {
//         if (binding.b2.getText().toString().equals(""))
//         {
//         binding.b2.setText(binding.b1.getText().toString());
//         binding.b1.setText("");
//         }
//         else if (binding.b4.getText().toString().equals(""))
//         {
//         binding.b4.setText(binding.b1.toString());
//         binding.b1.setText("");
//         }
//         }




//typ casting double to int
//        for (int i=1; i<10; i++)
//        {
//            Double d = Math.random()*9;
//            Integer temp = Integer.parseInt(d.toString().split("\\.")[0]);
//            numberlist.add(temp);
//        }
//        Log.e("+++", "onCreate: "+numberlist);


//loop throw typ casting
//                for (int i=0; i<=10; i++)
//                {
//                    for(int j=0; j<=10; j++)
//                    {
//                        Integer a = (int) (Math.random()*9);
//                        if (!numberlist.contains(a))
//                        {
//                            numberlist.add(a.toString());
//                        }
//                    }
//                }