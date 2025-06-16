# Java_Quiz_Game

This is a desktop-based interactive quiz game built using **Java** and **Swing GUI Framework**. It randomly selects 20 questions from a dataset of over 550 general knowledge questions. Each question is displayed one at a time with four options and a 15-second countdown timer. After answering all questions, it shows your final score and provides an option to retry the quiz.

----------------

## 📌 Project Overview

The **Quiz Game** provides users with a fun way to test their general knowledge. Here's how it works:

- Loads questions from a CSV file that contains 550+ entries.
- Randomly selects **20 questions** for each game session.
- Each question has **four multiple-choice options**.
- Users must answer each question within **15 seconds**.
- Score is calculated based on correct answers.
- At the end of the game, the user sees their score and can **retry** the quiz.

---

## 🧾 Features

- ✅ Simple and user-friendly GUI with Java Swing
- ✅ 20 random questions every time you play
- ✅ Auto submission after 15 seconds per question
- ✅ Displays final score with option to restart
- ✅ Lightweight and easy to run

---

## 🧱 Project File Structure
QuizGameProject/ │
├── QuizGame.java               # Main class with GUI and game logic 
├── Question.java               # Model class representing a quiz question 
├── QuestionLoader.java         # Helper class to load and shuffle questions from the CSV
├── gk_questions_550_final.csv  # Dataset with 550+ general knowledge questions 
└── README.md                   # This documentation file

-----------------

## 🖥️ How the Game Works

### 1. `QuizGame.java` (Main GUI)
- Uses **JFrame** for the main window.
- Displays one question at a time with **JRadioButtons** for options.
- A **"Next" button** moves to the next question.
- A **15-second countdown timer** auto-submits if time runs out.
- At the end of the game, shows the final score and a **"Retry" button** to restart the game.

### 2. `Question.java` (Model Class)
- Represents one quiz question.
- Stores the question text, four options, and the correct answer.
- Includes a method `isCorrect()` to check if the selected option is right.

### 3. `QuestionLoader.java` (Utility Class)
- Reads data from the CSV file.
- Parses each row into a `Question` object.
- Shuffles the list of questions and returns only 20 for the quiz.

### 4. `gk_questions_550_final.csv` (Dataset)
- A simple comma-separated file with 6 columns:
  - `Question`, `Option1`, `Option2`, `Option3`, `Option4`, `CorrectAnswer`

---
You can easily add or update questions in this file to customize the quiz.

---

---

## 🖥️ How to Run the Project

You can run this Java project in **three ways**: via **Command Prompt**, **VS Code**, or **Eclipse**.

---

### 💻 1. Running via Command Prompt (Windows)

#### ✅ Requirements:
- Java JDK installed and added to system PATH

#### 🧪 Steps:
1. **Unzip** the folder `QuizGameProject.zip` to your desktop or any location.
2. Open **Command Prompt** and navigate to the folder:
   ```cmd
   cd Desktop\QuizGameProject
3. Compile the Java files:

javac QuizGame.java Question.java QuestionLoader.java


4. Run the program:

java QuizGame



✅ You should see the quiz game window appear.


---

🧠 2. Running in VS Code

✅ Requirements:

Java Extension Pack installed in VS Code

JDK installed


🧪 Steps:

1. Open VS Code


2. Go to File > Open Folder... and select the QuizGameProject folder


3. Open all .java files in the editor


4. Right-click on QuizGame.java > Click Run Java


5. The GUI game window will appear and the game will start




---

☕ 3. Running in Eclipse IDE

✅ Requirements:

Eclipse IDE for Java Developers

JDK configured in Eclipse


🧪 Steps:

1. Open Eclipse and create a new Java project

File > New > Java Project → Name: QuizGameProject



2. Right-click on src > Import > File System and import:

QuizGame.java

Question.java

QuestionLoader.java



3. Place gk_questions_550_final.csv in the root folder of the project.


4. Make sure the file path in the code matches:

QuestionLoader.loadQuestions("gk_questions_550_final.csv");


5. Right-click on QuizGame.java > Run As > Java Application



✅ GUI will launch and you can play the quiz.


---
🔄 Future Enhancements (Ideas)

Add category-wise quizzes

Maintain high scores

Export results to text or PDF

Add sound effects or animations


---
## 👩‍💻 Author

**Akshaya Bomma**

- Passionate Java developer and aspiring software engineer
- Skilled in Java, SQL, HTML and CSS
- 🔗 GitHub:(https://github.com/Akshayabomma1593)
- 📧 Email: bommaakshaya@gmail.com


---

📜 License

This project is open source and free to use for learning and academic purposes.
