#include <iostream>
#include <string>
#include <vector>
#include <cstdlib>
#include <ctime>

using namespace std;

class MCQuestion
{
private:
    string questionText;
    vector<string> choices;
    int correctChoiceIndex;

public:
    MCQuestion(string text, vector<string> options, int correctIndex)
        : questionText(text), choices(options), correctChoiceIndex(correctIndex) {}

    string getQuestionText() const
    {
        return questionText;
    }

    const vector<string> &getChoices() const
    {
        return choices;
    }

    int getCorrectChoiceIndex() const
    {
        return correctChoiceIndex;
    }
};

class MCQuiz
{
private:
    vector<MCQuestion> questions;
    int score;

public:
    MCQuiz() : score(0) {}

    void addQuestion(MCQuestion question)
    {
        questions.push_back(question);
    }

    void startQuiz()
    {
        score = 0;

        cout << "Welcome to the Multiple-Choice Quiz!" << endl;

        for (size_t i = 0; i < questions.size(); ++i)
        {
            const MCQuestion &q = questions[i];
            cout << "Question " << (i + 1) << ": " << q.getQuestionText() << endl;

            const vector<string> &choices = q.getChoices();
            for (size_t j = 0; j < choices.size(); ++j)
            {
                cout << "  " << (j + 1) << ". " << choices[j] << endl;
            }

            int userChoice;
            cout << "Your choice (1-" << choices.size() << "): ";
            cin >> userChoice;

            if (userChoice - 1 == q.getCorrectChoiceIndex())
            {
                cout << "Correct!" << endl;
                score++;
            }
            else
            {
                cout << "Incorrect. The correct answer is: " << q.getChoices()[q.getCorrectChoiceIndex()] << endl;
            }
        }

        cout << "Quiz completed. Your score is: " << score << " out of " << questions.size() << endl;
    }
};

int main()
{
    MCQuiz quiz;

    vector<string> choices1 = {"London", "Berlin", "Paris", "Madrid"};
    MCQuestion question1("What is the capital of France?", choices1, 2);

    vector<string> choices2 = {"Venus", "Mars", "Saturn", "Jupiter"};
    MCQuestion question2("Which planet is known as the 'Red Planet'?", choices2, 1);

    vector<string> choices3 = {"5", "6", "7", "8"};
    MCQuestion question3("How many continents are there on Earth?", choices3, 2);

    vector<string> choices4 = {"Cheetah", "Lion", "Giraffe", "Elephant"};
    MCQuestion question4("Which animal is known as the 'King of the Jungle'?", choices4, 1);

    vector<string> choices5 = {"Red", "Green", "Blue", "Yellow"};
    MCQuestion question5("What is the primary color that represents 'stop' in traffic lights?", choices5, 0);

    quiz.addQuestion(question1);
    quiz.addQuestion(question2);
    quiz.addQuestion(question3);
    quiz.addQuestion(question4);
    quiz.addQuestion(question5);

    bool retry = false;
    char answer;
    do
    {
        quiz.startQuiz();
        cout << "Do you want to retry the quiz? (Y/N): ";
        cin >> answer;
        if (answer == 'Y' || answer == 'y')
        {
            retry = true;
        }
        else
        {
            retry = false;
        }
    } while (retry);

    return 0;
}
