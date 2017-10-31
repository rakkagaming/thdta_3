package mah.thdta3.robin.android.lab3c;

/**
 * Created by robin on 17/09/2017.
 */

public class Instructions {
    private String whatToDo;
    private String content;

    public Instructions(String whatToDo, String content){
        this.content = content;
        this.whatToDo = whatToDo;
    }


    public String getWhatToDO() {
        return whatToDo;
    }

    public String getContent() {
        return content;
    }
}
