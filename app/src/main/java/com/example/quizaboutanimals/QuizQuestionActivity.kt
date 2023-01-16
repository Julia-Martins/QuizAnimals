package com.example.quizaboutanimals

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

// region Global Variables
    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Questions>? = null
    private var mSelectOptionPosition: Int = 0

    private var myUserName: String? = null
    private var mCorrectAnswer: Int = 0

    private var progressBar: ProgressBar? = null
    private var txtProgressNumber: TextView? = null

    private var txtQuestion: TextView? = null
    private var imgQuestion: ImageView? = null

    private var btnOptionOne: TextView? = null
    private var btnOptionTwo: TextView? = null
    private var btnOptionThree: TextView? = null
    private var btnOptionFour: TextView? = null

    private var btnSubmit: Button? = null
// endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        myUserName = intent.getStringExtra(Constants.USER_NAME)

        progressBar = findViewById(R.id.progressBar)
        txtProgressNumber = findViewById(R.id.txtProgressNumber)

        txtQuestion = findViewById(R.id.txtQuestion)
        imgQuestion = findViewById(R.id.imgQuestion)

        btnOptionOne = findViewById(R.id.btnOptionOne)
        btnOptionTwo = findViewById(R.id.btnOptionTwo)
        btnOptionThree = findViewById(R.id.btnOptionThree)
        btnOptionFour  = findViewById(R.id.btnOptionFour)

        btnOptionOne?.setOnClickListener(this)
        btnOptionTwo?.setOnClickListener(this)
        btnOptionThree?.setOnClickListener(this)
        btnOptionFour?.setOnClickListener(this)

        btnSubmit = findViewById(R.id.btnSend)

        btnSubmit?.setOnClickListener(this)

        mQuestionsList = Constants.getQuestions()

        setQuestion()
    }

// region Function setQuestion
    private fun setQuestion() {
        val question: Questions = mQuestionsList!![mCurrentPosition - 1]

        defaultOptionsView()
        progressBar?.progress = mCurrentPosition
        txtProgressNumber?.text = "$mCurrentPosition/${progressBar?.max}"

        txtQuestion?.text = question.questions

        imgQuestion?.setImageResource(question.image)

        btnOptionOne?.text = question.optionOne
        btnOptionTwo?.text = question.optionTwo
        btnOptionThree?.text = question.optionThree
        btnOptionFour?.text = question.optionFour

        if(mCurrentPosition == mQuestionsList!!.size){
            btnSubmit?.text = "FINISH"
        }else{
            btnSubmit?.text = "SUBMIT"
        }

        btnSubmit?.isEnabled = false

        btnOptionOne?.isEnabled = true
        btnOptionTwo?.isEnabled = true
        btnOptionThree?.isEnabled = true
        btnOptionFour?.isEnabled = true
    }
// endregion

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btnOptionOne -> {
                btnOptionOne?.let {
                    selectedOptionView(it, 1)
                    btnSubmit?.isEnabled = true
                }
            }

            R.id.btnOptionTwo -> {
                btnOptionTwo?.let {
                    selectedOptionView(it, 2)
                    btnSubmit?.isEnabled = true
                }
            }

            R.id.btnOptionThree -> {
                btnOptionThree?.let {
                    selectedOptionView(it, 3)
                    btnSubmit?.isEnabled = true
                }
            }

            R.id.btnOptionFour -> {
                btnOptionFour?.let {
                    selectedOptionView(it, 4)
                    btnSubmit?.isEnabled = true
                }
            }

            R.id.btnSend ->{
                    if (mSelectOptionPosition == 0) {
                        mCurrentPosition++

                        when {
                            mCurrentPosition <= mQuestionsList!!.size -> {
                                setQuestion()
                            }
                            else -> {
                                val intent = Intent(this, FinalResult::class.java)

                                intent.putExtra(Constants.USER_NAME, myUserName)
                                intent.putExtra(Constants.CORRECT_ANSWER, mCorrectAnswer)
                                intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList?.size)
                                startActivity(intent)
                                finish()
                            }
                        }
                    } else {
                        val question = mQuestionsList?.get(mCurrentPosition - 1)
                        if (question!!.correctAnswer != mSelectOptionPosition) {
                            answerView(mSelectOptionPosition, R.drawable.wrong_selected_option)
                        } else {
                            mCorrectAnswer++
                        }
                        answerView(question.correctAnswer, R.drawable.correctly_selected_option)

                        if (mCurrentPosition == mQuestionsList!!.size) {
                            btnSubmit?.text = "FINISH"
                        } else {
                            btnSubmit?.text = "NEXT QUESTION"
                        }

                        btnOptionOne?.isEnabled = false
                        btnOptionTwo?.isEnabled = false
                        btnOptionThree?.isEnabled = false
                        btnOptionFour?.isEnabled = false

                        mSelectOptionPosition = 0
                    }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 -> {
                btnOptionOne?.background = ContextCompat.getDrawable(this@QuizQuestionActivity, drawableView)
            }
            2 -> {
                btnOptionTwo?.background = ContextCompat.getDrawable(this@QuizQuestionActivity, drawableView)
            }
            3 -> {
                btnOptionThree?.background = ContextCompat.getDrawable(this@QuizQuestionActivity, drawableView)
            }
            4 -> {
                btnOptionFour?.background = ContextCompat.getDrawable(this@QuizQuestionActivity, drawableView)
            }
        }
    }

    // region Function defaultOptionsView
    @SuppressLint("Range")
    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()

        btnOptionOne?.let {
            options.add(0, it)
        }

        btnOptionTwo?.let {
            options.add(1, it)
        }

        btnOptionThree?.let {
            options.add(2, it)
        }

        btnOptionFour?.let {
            options.add(3, it)
        }

        for(option in options){
            option.setTextColor(Color.parseColor("#0000BB"))
            option.typeface = Typeface.DEFAULT

            option.background = ContextCompat.getDrawable(this@QuizQuestionActivity, R.drawable.border_style)

        }
    }
// endregion

    // region Function selectedOptionView
    private fun selectedOptionView(txt: TextView, selectedOptionNum: Int){
        defaultOptionsView()

        mSelectOptionPosition = selectedOptionNum

        txt.setTextColor(Color.parseColor("#FFFFFF"))
        txt.setTypeface(txt.typeface, Typeface.BOLD)
        txt.background = ContextCompat.getDrawable(this@QuizQuestionActivity, R.drawable.border_selected_option)
    }
    // endregion


}