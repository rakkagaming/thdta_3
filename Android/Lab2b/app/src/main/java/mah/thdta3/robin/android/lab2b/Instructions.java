package mah.thdta3.robin.android.lab2b;

/**
 * Created by robin on 16/09/2017.
 */

public class Instructions {
    private String wtd;
    private String content;

    public Instructions(String whatToDo, String content) {
        wtd = whatToDo;
        this.content = content;
    }

    public String getWhatToDo() {
        return wtd;
    }

    public String getContent() {
        return content;
    }
}
