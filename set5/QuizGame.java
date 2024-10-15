import java.util.*;

public class QuizGame {

    private static final Map<String, Quiz> quizzes = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Quiz Game ---");
            System.out.println("1. Create Quiz");
            System.out.println("2. Take Quiz");
            System.out.println("3. View Quiz");
            System.out.println("4. List Quizzes");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    createQuiz();
                    break;
                case 2:
                    takeQuiz();
                    break;
                case 3:
                    viewQuiz();
                    break;
                case 4:
                    listQuizzes();
                    break;
                case 5:
                    System.out.println("Exiting the quiz game. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private static void createQuiz() {
        System.out.print("Enter quiz name: ");
        String quizName = scanner.nextLine();

        if (quizzes.containsKey(quizName)) {
            System.out.println("Quiz with this name already exists.");
            return;
        }

        Quiz quiz = new Quiz(quizName);
        System.out.print("Enter number of questions: ");
        int numQuestions = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numQuestions; i++) {
            System.out.print("Enter question " + (i + 1) + ": ");
            String questionText = scanner.nextLine();

            System.out.print("Enter number of choices: ");
            int numChoices = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            List<String> choices = new ArrayList<>();
            for (int j = 0; j < numChoices; j++) {
                System.out.print("Enter choice " + (j + 1) + ": ");
                choices.add(scanner.nextLine());
            }

            System.out.print("Enter the number of the correct choice: ");
            int correctChoice = scanner.nextInt() - 1; // Adjust for zero-indexing
            scanner.nextLine(); // Consume newline

            quiz.addQuestion(new Question(questionText, choices, correctChoice));
        }

        quizzes.put(quizName, quiz);
        System.out.println("Quiz created successfully!");
    }

    private static void takeQuiz() {
        System.out.print("Enter the name of the quiz you want to take: ");
        String quizName = scanner.nextLine();

        Quiz quiz = quizzes.get(quizName);
        if (quiz == null) {
            System.out.println("Quiz not found.");
            return;
        }

        int score = 0;
        for (int i = 0; i < quiz.getNumQuestions(); i++) {
            Question question = quiz.getQuestion(i);
            System.out.println("Question " + (i + 1) + ": " + question.getQuestion());
            List<String> choices = question.getChoices();
            for (int j = 0; j < choices.size(); j++) {
                System.out.println((j + 1) + ": " + choices.get(j));
            }

            System.out.print("Your answer (number): ");
            int answer = scanner.nextInt() - 1; // Adjust for zero-indexing
            scanner.nextLine(); // Consume newline

            if (answer == question.getCorrectChoice()) {
                score++;
            }
        }

        System.out.println("Your score: " + score + " out of " + quiz.getNumQuestions());
    }

    private static void viewQuiz() {
        System.out.print("Enter the name of the quiz you want to view: ");
        String quizName = scanner.nextLine();

        Quiz quiz = quizzes.get(quizName);
        if (quiz == null) {
            System.out.println("Quiz not found.");
            return;
        }

        System.out.println("Quiz: " + quiz.getName());
        for (int i = 0; i < quiz.getNumQuestions(); i++) {
            Question question = quiz.getQuestion(i);
            System.out.println("Question " + (i + 1) + ": " + question.getQuestion());
            List<String> choices = question.getChoices();
            for (int j = 0; j < choices.size(); j++) {
                System.out.println("  " + (j + 1) + ": " + choices.get(j));
            }
            System.out.println("Correct Answer: " + (question.getCorrectChoice() + 1));
        }
    }

    private static void listQuizzes() {
        if (quizzes.isEmpty()) {
            System.out.println("No quizzes available.");
        } else {
            System.out.println("Available Quizzes:");
            for (String quizName : quizzes.keySet()) {
                System.out.println("- " + quizName);
            }
        }
    }
}

class Quiz {
    private final String name;
    private final List<Question> questions = new ArrayList<>();

    public Quiz(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public Question getQuestion(int index) {
        return questions.get(index);
    }

    public int getNumQuestions() {
        return questions.size();
    }
}

class Question {
    private final String question;
    private final List<String> choices;
    private final int correctChoice;

    public Question(String question, List<String> choices, int correctChoice) {
        this.question = question;
        this.choices = choices;
        this.correctChoice = correctChoice;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getChoices() {
        return choices;
    }

    public int getCorrectChoice() {
        return correctChoice;
    }
}
