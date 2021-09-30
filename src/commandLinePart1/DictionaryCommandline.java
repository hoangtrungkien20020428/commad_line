package commandLinePart1;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryCommandline {

  private final DictionaryManagement manage1;

  public DictionaryCommandline() {
    manage1 = new DictionaryManagement();
  }

  public static void main(String[] args)
      throws FileNotFoundException, UnsupportedEncodingException {
    DictionaryCommandline dc = new DictionaryCommandline();
    dc.getManage1().insertFromFile();
    dc.showAllWords();
    dc.dictionarySearcher();
  }

  public DictionaryManagement getManage1() {
    return manage1;
  }

  public void showAllWords() {
    System.out.println("No   |English     |Vietnamese");
    int i = 1;
    String showWord;
    for (Word word : manage1.getDic().getWordArray()) {
      showWord = MessageFormat.format("{0}{1}|{2}{3}|{4}", i,"      ", word.getWord_target(),"    ",
          word.getWord_explain());
      System.out.println(showWord);
      i++;
    }
    System.out.println("");
  }

  public void dictionaryBasic() {
    // manage1.insertFromCommandline();
    try {
      manage1.insertFromFile();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    showAllWords();
  }

  public void dictionaryAdvanced() {
    try {
      manage1.insertFromFile();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    showAllWords();
    manage1.DictionaryLookup();
  }
  public void  dictionarySearcher() {
    System.out.println("Tu ban can tim la :");
    Scanner sc = new Scanner(System.in);
    String wordForSearch = sc.nextLine();
    ArrayList<Word> result = new ArrayList<Word>();
    for (Word word : manage1.getDic().getWordArray()) {
      if (word.getWord_target().contains(wordForSearch)) {
        result.add(word);
      }
    }
    for (Word word:result) {
      System.out.println(word.getWord_target()+"   "+word.getWord_explain());
    }
  }
}
