package commandLinePart1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class DictionaryManagement {

  private final Dictionary Dic;

  DictionaryManagement() {
    this.Dic = new Dictionary();
  }

  public Dictionary getDic() {
    return Dic;
  }

  public void insertFromCommandline() {
    Scanner sc = new Scanner(System.in);
    String english = sc.nextLine();
    String vietnamese = sc.nextLine();
    Word word = new Word(english, vietnamese);
    Dic.pushWord(word);
  }

  public void insertFromFile() throws FileNotFoundException, UnsupportedEncodingException {
    FileInputStream fileInputStream = new FileInputStream("data/Dictionaries.txt");
    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,
        StandardCharsets.UTF_8);
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    String line = null;
    String[] words;
    try {
      while ((line = bufferedReader.readLine()) != null) {
        words = line.split(" ");
        if (words.length >= 2) {
          Word newWordFromDictionaries = new Word(words[0], words[1]);
          Dic.pushWord(newWordFromDictionaries);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void DictionaryLookup() {
    Scanner sc = new Scanner(System.in);
    String wordForSearch = sc.nextLine();
    for (Word word : Dic.getWordArray()) {
      if (wordForSearch.equals(word.getWord_target())) {
        System.out.print(
            "English:   " + wordForSearch + "VietNamese:  " + word.getWord_explain());
      }
    }
    System.out.println("not found");
  }
  public void addWord(Word word){

  }
}

