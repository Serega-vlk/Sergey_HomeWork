package BasicJava;

public class Model {
    private StringBuilder sentences;

    public Model(){
        this.sentences = new StringBuilder();
    }

    public void addWord(String word){
        sentences.append(word);
        if (word.equals("Hello")){
            sentences.append(" ");
        }
    }

    public String getSentences() {
        return sentences.toString();
    }

    public boolean check(String word, int index){
        if (index == 1){
            return word.equals("Hello");
        } else if (index == 2){
            return word.equals("world!");
        }
        else return false;
    }
}
