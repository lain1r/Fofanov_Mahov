package com.example.quiz;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView question;
    private TextView score;
    private Button buttonAnswer1;
    private Button buttonAnswer2;
    private Button buttonAnswer3;
    private Button buttonAnswer4;
    private Button buttonNext;
    private ArrayList<Question> questionBank = new ArrayList<>();
    private int questionIndex = 0;
    private int scoreCorrect = 0;
    private void addQ(String text, String a, String b, String c, String d, int correct) {
        questionBank.add(new Question(text, new String[]{a, b, c,d }, correct));
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        question = findViewById(R.id.textQuestion);
        score = findViewById(R.id.score);

        buttonAnswer1 = findViewById(R.id.btn1);
        buttonAnswer1.setOnClickListener(v -> checkAnswer(0));
        buttonAnswer2 = findViewById(R.id.btn2);
        buttonAnswer2.setOnClickListener(v -> checkAnswer(1));
        buttonAnswer3 = findViewById(R.id.btn3);
        buttonAnswer3.setOnClickListener(v -> checkAnswer(2));
        buttonAnswer4 = findViewById(R.id.btn4);
        buttonAnswer4.setOnClickListener(v -> checkAnswer(3));

        buttonNext = findViewById(R.id.btnNext);
        buttonNext.setOnClickListener(v -> {
            questionIndex++;
            if (questionIndex < questionBank.size()) {
                displayQuestion();
            } else {
                score.setText("правильных ответов " + scoreCorrect);
                question.setText("Конец!!!!!");
                buttonNext.setVisibility(TextView.GONE);
                buttonAnswer1.setVisibility(TextView.GONE);
                buttonAnswer2.setVisibility(TextView.GONE);
                buttonAnswer3.setVisibility(TextView.GONE);
                buttonAnswer4.setVisibility(TextView.GONE);
            }
        });

        initQuestions();
        Collections.shuffle(questionBank);
        displayQuestion();
    }

    private void initQuestions() {
        //                 текст,              вариант 1, вариант 2,    вариант 3, вариант 4, какой правильный (0-3)
        addQ("Какой моб боится кошек?", "Крипер", "Зомби", "Скелет", "Паук", 0);
        addQ("Как приручить волка?", "Мясом", "Костью", "Рыбой", "Яблоком", 1);
        addQ("Моб, нейтральный, если не смотреть в глаза?", "Слайм", "Гаст", "Эндермен", "Чешуйница", 2);
        addQ("Что выпадает из Гаста?", "Слизь", "Порох", "Слеза Гаста", "Стержень", 2);
        addQ("Какой моб сгорает на солнце?", "Паук", "Зомби", "Крипер", "Эндермен", 1);
        addQ("Кто босс Нижнего мира?", "Дракон Края", "Иссушитель", "Разоритель", "Варден", 1);
        addQ("Из чего крафтятся палки?", "Доски", "Уголь", "Железо", "Булыжник", 0);
        addQ("Кирка для добычи обсидиана?", "Железная", "Золотая", "Алмазная", "Каменная", 2);
        addQ("Смесь лавы и воды дает:", "Бедрок", "Булыжник", "Железо", "Песок", 1);
        addQ("Предмет для портала в Ад?", "Око Края", "Огниво", "Рычаг", "Редстоун", 1);
        addQ("Сколько золота для яблока?", "4", "8", "9", "1", 1);
        addQ("Самое долгое топливо?", "Дерево", "Уголь", "Лава", "Палка", 2);
        addQ("Основное измерение игры?", "Энд", "Незер", "Обычный мир", "Рай", 2);
        addQ("Блок рамки портала в Незер?", "Алмаз", "Обсидиан", "Бедрок", "Глина", 1);
        addQ("В каком биоме живут панды?", "Тайга", "Джунгли", "Пустыня", "Саванна", 1);
        addQ("Где находится Варден?", "Крепость", "Глубины", "Древний город", "Шахта", 2);
        addQ("Еда для ночного зрения?", "Стейк", "Золотая морковь", "Хлеб", "Печенье", 1);
        addQ("Ингредиент для зелья силы?", "Сахар", "Огненный порошок", "Слеза", "Лапка", 1);
        addQ("Из чего делают хлеб?", "Тростник", "Пшеница", "Картофель", "Тыква", 1);
        addQ("Кто дает грибной суп?", "Корова", "Грибная корова", "Овца", "Свинья", 1);
        addQ("Кто создал Minecraft?", "Нотч", "Стив", "Джеб", "Билл Гейтс", 0);
        addQ("Имя героя по умолчанию?", "Алекс", "Стив", "Питер", "Джон", 1);
        addQ("Неразрушимый блок?", "Обсидиан", "Бедрок", "Руда", "Железо", 1);
        addQ("Кровать в Аду при попытке сна:", "Спишь", "Взрывается", "Ничего", "Горит", 1);
        addQ("Макс. предметов в стаке?", "16", "32", "64", "100", 2);
        addQ("Камень для механизмов?", "Лазурит", "Сапфир", "Редстоун", "Алмаз", 2);
        addQ("Инструмент для сбора листвы?", "Топор", "Ножницы", "Лопата", "Меч", 1);
        addQ("Что выпадает из Эндермена?", "Блок", "Жемчуг Края", "Вода", "Око", 1);
        addQ("Высота алмазов (1.18+)?", "Выше 60", "Ниже 0", "Только 12", "В горах", 1);
        addQ("Мир, где живет Дракон?", "Незер", "Край", "Рай", "Лес", 1);

    }
    private void checkAnswer(int answer){
        Question q = questionBank.get(questionIndex);

        if (q.getCorrect() == answer){
            Toast.makeText(this, "правильно", Toast.LENGTH_SHORT).show();
            scoreCorrect++;
        } else {
            Toast.makeText(this, "не правильно, правильный ответ" + q.getAnswer()[q.getCorrect()], Toast.LENGTH_SHORT).show();
        }
        buttonAnswer1.setEnabled(false);
        buttonAnswer2.setEnabled(false);
        buttonAnswer3.setEnabled(false);
        buttonAnswer4.setEnabled(false);
        buttonNext.setEnabled(true);
    }
    private void displayQuestion(){
        Question q = questionBank.get(questionIndex);

        buttonNext.setEnabled(false);
        question.setText(q.getQuest());
        buttonAnswer1.setText(q.getAnswer()[0]);
        buttonAnswer1.setEnabled(true);
        buttonAnswer2.setText(q.getAnswer()[1]);
        buttonAnswer2.setEnabled(true);
        buttonAnswer3.setText(q.getAnswer()[2]);
        buttonAnswer3.setEnabled(true);
        buttonAnswer4.setText(q.getAnswer()[3]);
        buttonAnswer4.setEnabled(true);

        score.setText(scoreCorrect + "/30 " + "вопрос " + (questionIndex+1));
    }

}