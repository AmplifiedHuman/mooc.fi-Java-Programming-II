package reader;

import reader.criteria.Both;
import reader.criteria.ContainsWord;
import reader.criteria.Criterion;
import reader.criteria.EndsWithQuestionOrExclamationMark;

public class Main {

    public static void main(String[] args) {
        String address = "https://www.gutenberg.org/files/2554/2554-0.txt";
        GutenbergReader book = new GutenbergReader(address);

        Criterion criterion = new Both(new EndsWithQuestionOrExclamationMark(), new ContainsWord("me"));

        for (String line : book.linesWhichComplyWith(criterion)) {
            System.out.println(line);
        }
    }
}
