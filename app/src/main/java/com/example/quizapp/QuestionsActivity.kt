package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionsActivity : AppCompatActivity() {
    private val qsList = Constants.getQuestions()
    private var currentPosition:Int = 0
    private var checkedAnswer:Int? = null
    private var checkedTv:TextView? = null
    private var score:Int = 0
    private var isSubmit:Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        //First Setting
        val question:Question = qsList[currentPosition]
        change(question)
    }
    fun submit(view: View){
        if(currentPosition<qsList.size-1) {
            if(isSubmit) {
                btn_submit.text="SUBMIT"
                var question: Question = qsList[currentPosition]
                if (checkedAnswer == question.answer) score++
                currentPosition++
                question = qsList[currentPosition]
                checkedAnswer = null
                checkedTv=null
                change(question)
            }else{
                defaultOptionsView()
                btn_submit.text="GO TO NEXT QUESTION"
                var question: Question = qsList[currentPosition]
                setWrong(checkedTv)
                when(question.answer){
                    0->{setCorrect(tv_option0)}
                    1->{setCorrect(tv_option1)}
                    2->{setCorrect(tv_option2)}
                    3->{setCorrect(tv_option3)}
                }
            }
            isSubmit=!isSubmit
        }else{
            if(!isSubmit){
                defaultOptionsView()
                btn_submit.text="SEE RESULT"
                var question: Question = qsList[currentPosition]
                setWrong(checkedTv)
                when(question.answer){
                    0->{setCorrect(tv_option0)}
                    1->{setCorrect(tv_option1)}
                    2->{setCorrect(tv_option2)}
                    3->{setCorrect(tv_option3)}
                }
            }else {
                val result = Intent(this, ResultActivity::class.java)
                result.putExtra("username", intent.getStringExtra("username"))
                result.putExtra("score",score)
                startActivity(result)
                finish()
            }
            isSubmit=!isSubmit
        }
    }
    fun check0(view:View){
        if(!isSubmit) {
            checkedTv=(view as TextView)
            checkedAnswer = 0
            selectOptionView(view)
        }
    }
    fun check1(view:View){
        if(!isSubmit) {
            checkedTv=(view as TextView)
            checkedAnswer = 1
            selectOptionView(view)
        }
    }
    fun check2(view:View){
        if(!isSubmit) {
            checkedTv=(view as TextView)
            checkedAnswer = 2
            selectOptionView(view)
        }
    }
    fun check3(view:View){
        if(!isSubmit) {
            checkedTv=(view as TextView)
            checkedAnswer = 3
            selectOptionView(view)
        }
    }
    private fun change(question: Question){
        defaultOptionsView()
        iv_flag.setImageResource(question.img)
        tv_option0.text=question.opt0
        tv_option1.text=question.opt1
        tv_option2.text=question.opt2
        tv_option3.text=question.opt3
        tv_progress.text="${question.id+1}/12"
        progress_bar.progress=question.id+1
    }
    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0, tv_option0)
        options.add(1, tv_option1)
        options.add(2, tv_option2)
        options.add(3, tv_option3)

        for(option in options){
            option.setTextColor(Color.parseColor("#727070"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                    this, R.drawable.default_option_border_bg
            )
        }
    }
    private fun selectOptionView(view:View){
        defaultOptionsView()
        (view as TextView).setTextColor(Color.parseColor("#CA0505"))
        view.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
        view.setTypeface(view.typeface, Typeface.BOLD_ITALIC)
    }
    private fun setWrong(tv:TextView?){
        tv?.background = ContextCompat.getDrawable(this, R.drawable.btn_wrong)
        tv?.setTextColor(Color.BLACK)
    }
    private fun setCorrect(tv:TextView?){
        tv?.background = ContextCompat.getDrawable(this, R.drawable.btn_correct)
        tv?.setTextColor(Color.BLACK)
    }
}