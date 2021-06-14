import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            char deliters[] = {'"', '[', ']', '«', '»', ':', ';', '.', ',', '!', '?',
                    '(', ')', '\n', '\t', '\r', '$', '%', '*', '+', '–', '—', '=', '/', '&'};
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input url:");
            String link = scanner.nextLine();
            Document doc = Jsoup.connect(link).get();
            System.out.println("Input new file's name:");
            String fileName = scanner.nextLine();
            File file = new File(fileName + ".html");
            while (file.exists()) {
                System.out.println("Choose another file's name:");
                String newFileName = scanner.nextLine();
                file.renameTo(new File(newFileName + ".html"));
            }
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(doc.toString());
            fileWriter.close();


            String text = doc.body().text();
            WordsStatistic wordsStatistic=new WordsStatistic();
            wordsStatistic=wordsStatistic.getStatistic(text,deliters);
            System.out.println(wordsStatistic.toString());
        }catch (IllegalArgumentException e){
            System.out.println("Wrong url,check it");
        }


    }

}
