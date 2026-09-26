import java.util.*;

abstract class Question {
    int no, marks;

    Question(int no, int marks) {
        this.no = no;
        this.marks = marks;
    }

    abstract boolean check(String ans);
}

class MCQ extends Question {
    String correct;

    MCQ(int no, int marks, String correct) {
        super(no, marks);
        this.correct = correct;
    }

    boolean check(String ans) {
        return correct.equalsIgnoreCase(ans);
    }
}

class TF extends Question {
    boolean correct;

    TF(int no, int marks, boolean correct) {
        super(no, marks);
        this.correct = correct;
    }

    boolean check(String ans) {
        return Boolean.parseBoolean(ans) == correct;
    }
}

class Attempt {
    Map<Question,String> answers = new LinkedHashMap<>();
    boolean submitted = false;

    void answer(Question q, String a) {
        if (submitted)
            System.out.println("Cannot change answers");
        else {
            answers.put(q, a);
            System.out.println("Answer recorded");
        }
    }

    void submit() {
        submitted = true;
        int score = 0, total = 0;

        for (Question q : answers.keySet()) {
            total += q.marks;

            if (q.check(answers.get(q))) {
                score += q.marks;
                System.out.println(
                    "Question " + q.no + ": Correct"
                );
            } else {
                System.out.println(
                    "Question " + q.no + ": Incorrect"
                );
            }
        }

        System.out.println("Score: " + score + "/" + total);
    }
}

public class OnlineExaminationSystem {
    public static void main(String[] args) {
        Question q1 = new MCQ(1, 5, "C");
        Question q2 = new TF(2, 5, false);

        Attempt a = new Attempt();

        System.out.println("Exam started");

        a.answer(q1, "C");
        a.answer(q2, "true");

        a.submit();

        a.answer(q1, "A");
    }
}