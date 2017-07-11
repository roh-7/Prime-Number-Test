package com.example.myapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
	val ques = Question()
	var score:Long = 0
	
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		loadQuestion()
		// eliminating use of findViewById using synthetic.
		trueButton.setOnClickListener { checkAnswer(true) }
		falseButton.setOnClickListener { checkAnswer(false) }
		nextButton.setOnClickListener { ques.getNextQuestion()
		loadQuestion()
		}
	}
	
	fun loadQuestion()
	{
		scoreView.setText("Your score is: "+score)
		questionTextView.setText("Is "+ques.number+" a prime number ?")
	}
	
	fun checkAnswer (x: Boolean)
	{
		if(x==ques.answer)
		{
			score++
			answer_text.setText("Thats correct")
			ques.getNextQuestion()
			loadQuestion()
		}
		else
		{
			answer_text.setText("Wrong answer")
			ques.getNextQuestion()
			loadQuestion()
		}
	}
	
}
