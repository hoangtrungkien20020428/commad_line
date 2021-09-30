package commandLinePart1;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {

  private List<Word> wordArray;

  Dictionary() {
    this.wordArray = new ArrayList<Word>();
  }

  public List<Word> pushWord(Word word) {
    wordArray.add(word);
    return wordArray;
  }

  public List<Word> removeWord(Word word) {
    wordArray.remove(word);
    return wordArray;
  }

  public List<Word> getWordArray() {
    return wordArray;
  }

  public void setWordArray(List<Word> wordArray) {
    this.wordArray = wordArray;
  }
}
