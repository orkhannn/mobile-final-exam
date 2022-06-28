package com.example.quizapp

object Constants{

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val q1 = Question(
            1,
            "What is Baby Yoda’s real name?",
            R.drawable.grogu,
            "Yaddle",
            "Aayla",
            "Grogu",
            "Kanan",
            3);
        questionsList.add(q1);

        val q2 = Question(
            1,
            "Who was Anakin Skywalker’s Padawan?",
            R.drawable.ahsoka,
            "Ahsoka Tano",
            "Ezra Bridger",
            "Sabine Wren",
            "Bariss Offee",
            1);
        questionsList.add(q2)

        val q3 = Question(
            1,
            "Who is Luke and Leia’s father?",
            R.drawable.luke_leia,
            "Jar Jar",
            "Obi Wan Kenobi",
            "Palpatine",
            "Darth Vader",
            4);
        questionsList.add(q3)

        val q4 = Question(
            1,
            "Bo-Katan wanted what from Moff Gideon?",
            R.drawable.bo_katan,
            "The Darksaber",
            "R2-D2",
            "Jetpack",
            "The Millennium Falcon",
            1);
        questionsList.add(q4)

        val q5 = Question(
            1,
            "What is the name of Hera Sindula’s ship?",
            R.drawable.ghost,
            "The Ghost",
            "Slave 1",
            "Millennium Falcon",
            "Death Star",
            1);
        questionsList.add(q5)

        val q6 = Question(
            1,
            "What is the name of the Death Star’s original commander?",
            R.drawable.tarkin,
            "Grand Admiral Thrawn",
            "Orson Krennic",
            "General Hux",
            "Grand Moff Tarkin",
            4);
        questionsList.add(q6)

        val q7 = Question(
            1,
            "What species is Jabba?",
            R.drawable.jabba,
            "Wookiee",
            "Hutt",
            "Togruta",
            "Trandoshan",
            2);
        questionsList.add(q7)

        val q8 = Question(
            1,
            "What is the name of the planet where Anakin Skywalker loses the duel against Obi-Wan?",
            R.drawable.mustafar,
            "Tatooine",
            "Naboo",
            "Hoth",
            "Mustafar",
            4);
        questionsList.add(q8)

        val q9 = Question(
            1,
            "What is Omega?",
            R.drawable.omega,
            "Jedi",
            "Clone",
            "Padawan",
            "Sith",
            2);
        questionsList.add(q9)

        val q10 = Question(
            1,
            "Who is this person?",
            R.drawable.cal,
            "Kanan Jarrus",
            "Ezra Bridger",
            "Cal Kestis",
            "Caleb Dume",
            3);
        questionsList.add(q10)

        return questionsList;
    }

}