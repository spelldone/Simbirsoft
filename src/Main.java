import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        char deliters[] = {'"', '[', ']', '«', '»', ':', ';', '.', ',', '!', '?',
                '(', ')', '\n', '\t', '\r', '$', '%', '*', '+', '–', '—', '=', '/', '&'};
        System.out.println("Input url:");
        String link = scanner.nextLine();
        System.out.println("Input new file's name:");
        String fileName = scanner.nextLine();
        File file = new File(fileName + ".html");
        while (file.exists()) {
            System.out.println("Choose another file's name:");
            String newFileName = scanner.nextLine();
            file.renameTo(new File(newFileName + ".html"));
        }
        Document doc = Jsoup.connect(link).get();
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(doc.toString());
        fileWriter.close();


        String text = doc.body().text();
        WordsStatistic wordsStatistic=new WordsStatistic();
        wordsStatistic=wordsStatistic.getStatistic(text,deliters);
        System.out.println(wordsStatistic.toString());
    }

}
