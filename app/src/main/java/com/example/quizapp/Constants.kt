package com.example.quizapp

object Constants{
    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val q0 = Question(0,"What country does this flag belong to?"
                ,R.drawable.flag_south_korea,"South Korea","Nicaragua","Eritrea","Finland",0
        )
        questionList.add(q0)

        val q1 = Question(1,"What country does this flag belong to?"
                ,R.drawable.flag_italy,"Bolivia","Greece","italy","Brazil",2
        )
        questionList.add(q1)

        val q2 = Question(2,"What country does this flag belong to?"
                ,R.drawable.flag_australia,"France","Australia","Guinea","Austria",1
        )
        questionList.add(q2)

        val q3 = Question(3,"What country does this flag belong to?"
                ,R.drawable.flag_russia,"Malawi","Liechtenstein","Norway","Russia",3
        )
        questionList.add(q3)

        val q4 = Question(4,"What country does this flag belong to?"
                ,R.drawable.flag_netherlands,"Tanzania","Netherlands","Switzerland","Zambia",1
        )
        questionList.add(q4)

        val q5 = Question(5,"What country does this flag belong to?"
                ,R.drawable.flag_uk,"Peru","Rwanda","Serbia","U.K.",3
        )
        questionList.add(q5)

        val q6 = Question(6,"What country does this flag belong to?"
                ,R.drawable.flag_sweden,"Ukraine","Turkey","Sweden","Uruguay",2
        )
        questionList.add(q6)

        val q7 = Question(7,"What country does this flag belong to?"
                ,R.drawable.flag_estonia,"Estonia","Syria","Spain","Singapore",0
        )
        questionList.add(q7)

        val q8 = Question(8,"What country does this flag belong to?"
                ,R.drawable.flag_canada,"Poland","Nepal","Monaco","Canada",3
        )
        questionList.add(q8)

        val q9 = Question(9,"What country does this flag belong to?"
                ,R.drawable.flag_germany,"Germany","Libya","Malta","Israel",0
        )
        questionList.add(q9)

        val q10 = Question(10,"What country does this flag belong to?"
                ,R.drawable.flag_us,"Kuwait","Dominica","U.S.","Cuba",2
        )
        questionList.add(q10)

        val q11 = Question(11,"What country does this flag belong to?"
                ,R.drawable.flag_france,"Benin","Fiji","Belgium","France",3
        )
        questionList.add(q11)

        return questionList
    }
}