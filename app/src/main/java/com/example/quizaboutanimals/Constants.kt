package com.example.quizaboutanimals

object Constants {
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWER: String = "correct_answer"

    fun getQuestions(): ArrayList<Questions>{
        val questionsList = ArrayList<Questions>()

        val que1 = Questions(
            1,
            "What animal is this?",
            R.drawable.wolf,
            "Dog",
            "Bear",
            "Wolf",
            "Lion",
            3
        )

        questionsList.add(que1)

        val que2 = Questions(
            2,
            "What animal is this?",
            R.drawable.bat,
            "Sheep",
            "Eagle",
            "Macaw",
            "Bat",
            4
        )

        questionsList.add(que2)

        val que3 = Questions(
            3,
            "What animal is this?",
            R.drawable.seal,
            "Snake",
            "Seal",
            "Fox",
            "Echidna",
            2
        )

        questionsList.add(que3)

        val que4 = Questions(
            4,
            "What animal is this?",
            R.drawable.eagle,
            "Magpie",
            "Eagle",
            "Anhinga",
            "Axolotl",
            2
        )

        questionsList.add(que4)

        val que5 = Questions(
            5,
            "What animal is this?",
            R.drawable.black_panther,
            "Cheetah",
            "Jaguar",
            "Panther",
            "Cat",
            3
        )

        questionsList.add(que5)

        val que6 = Questions(
            6,
            "What animal is this?",
            R.drawable.lionking,
            "Lynx",
            "Leopard",
            "Cat",
            "Lion",
            4
        )

        questionsList.add(que6)

        val que7 = Questions(
            7,
            "What animal is this?",
            R.drawable.deer,
            "Vole",
            "Lion",
            "Deer",
            "Bambi",
            3
        )

        questionsList.add(que7)

        val que8 = Questions(
            8,
            "What animal is this?",
            R.drawable.monkey,
            "Monkey",
            "Manatee",
            "Seal",
            "Lyrebird",
            1
        )

        questionsList.add(que8)

        val que9 = Questions(
            9,
            "What animal is this?",
            R.drawable.tiger,
            "Tiger",
            "Lion",
            "Wolf",
            "Tiger Moth",
            1
        )

        questionsList.add(que9)

        val que10 = Questions(
            10,
            "What animal is this?",
            R.drawable.rooster,
            "Eagle",
            "Turkey",
            "Chicken",
            "Rooster",
            4
        )

        questionsList.add(que10)

        return questionsList
    }

}