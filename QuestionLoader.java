
import java.io.*;
import java.util.*;

public class QuestionLoader {
    public static List<Question> loadQuestions(String filename) {
        List<Question> questions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", -1);
                if (parts.length == 6) {
                    questions.add(new Question(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]));
                }
            }
            Collections.shuffle(questions);
        } catch (Exception e) {
            System.out.println("Error loading CSV: " + e.getMessage());
        }
        return questions.subList(0, Math.min(20, questions.size()));
    }
}
