package ProgrammingChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by robin on 26/10/2017.
 */
public class WordPuzzle {
    private BufferedReader instream;
    private String[] input,wordsToFind;
    int row, column, pizzas, wordLength, t;
    private String[][] wordField;
    public static void main(String[] args) throws IOException {
        WordPuzzle go = new WordPuzzle();
        go.start();
    }

    private void start() throws IOException {
        instream = new BufferedReader(new InputStreamReader(System.in));
        int rounds = Integer.parseInt(instream.readLine());
        for (int i = 0; i < rounds; i++) {
            instream.readLine();
            input = instream.readLine().toString().split(" ");
            row = Integer.parseInt(input[0]);
            column = Integer.parseInt(input[1]);
            pizzas = Integer.parseInt(input[2]);
            wordField = new String[row][column];
            wordsToFind = new String[row];
            for (int j = 0; j < row; j++) {
                wordField[j] = instream.readLine().toString().split("");
            }
            for (int j = 0; j < pizzas; j++) {
                String s = instream.readLine().toString();
                wordFinder(s);
            }
        }
    }

    private void wordFinder(String s) {
        int startRow,startColumn;
        wordLength = t=1;
        char direction;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (s.charAt(0)==wordField[i][j].charAt(0)){
                    startRow = i;
                    startColumn = j;
                    if ( (i-(s.length()-1))>=0 && s.charAt(wordLength)==wordField[i-wordLength][j].charAt(0)){
                        wordLength = t;
                        direction = 'A';
                        if (findNext(s, direction,i,j)){
                            System.out.println(startRow + " " + startColumn + " " + direction);
                            return;
                        }
                    }if ( (i-(s.length()-1))>=0 && (j+(s.length()-1))<column && s.charAt(wordLength)==wordField[i-wordLength][j+wordLength].charAt(0)){
                        wordLength = t;
                        direction = 'B';
                        if (findNext(s, direction,i,j)){
                            System.out.println(startRow + " " + startColumn + " " + direction);
                            return;
                        }
                    }
                    if ( (j+(s.length()-1))<column && s.charAt(wordLength)==wordField[i][j+wordLength].charAt(0)){
                        wordLength = t;
                        direction = 'C';
                        if (findNext(s, direction,i,j)){
                            System.out.println(startRow + " " + startColumn + " " + direction);
                            return;
                        }
                    }
                    if ( (i+(s.length()-1))<row && (j+(s.length()-1))<column && s.charAt(wordLength)==wordField[i+wordLength][j+wordLength].charAt(0)){
                        wordLength = t;
                        direction = 'D';
                        if (findNext(s, direction,i,j)){
                            System.out.println(startRow + " " + startColumn + " " + direction);
                            return;
                        }
                    }
                    if ( (i+(s.length()-1))<row  && s.charAt(wordLength)==wordField[i+wordLength][j].charAt(0)){
                        wordLength = t;
                        direction = 'E';
                        if (findNext(s, direction,i,j)){
                            System.out.println(startRow + " " + startColumn + " " + direction);
                            return;
                        }
                    }
                    if ( (i+(s.length()-1))<row && (j-(s.length()-1))>=0 && s.charAt(wordLength)==wordField[i+wordLength][j-wordLength].charAt(0)){
                        wordLength = t;
                        direction = 'F';
                        if (findNext(s, direction,i,j)){
                            System.out.println(i + " " + j + " " + direction);
                            return;
                        }
                    }
                    if ( (j-(s.length()-1))>=0 && s.charAt(wordLength)==wordField[i][j-wordLength].charAt(0)){
                        wordLength = t;
                        direction = 'G';
                        if (findNext(s, direction,i,j)){
                            System.out.println(i + " " + j + " " + direction);
                            return;
                        }
                    }
                    if ( (i-(s.length()-1))>0 && (j-(s.length()-1))>=0 && s.charAt(wordLength)==wordField[i-wordLength][j-wordLength].charAt(0)){
                        wordLength = t;
                        direction = 'H';
                        if (findNext(s, direction,i,j)){
                            System.out.println(i + " " + j + " " + direction);
                            return;
                        }
                    }
                }
            }
        }
    }

    private boolean findNext(String s, char direction, int i, int j) {
        if (s.length()==wordLength){
            return true;}
        switch (direction){
            case 'A':
                if ((i-wordLength)>=0 && s.charAt(wordLength)==wordField[i-wordLength][j].charAt(0)){
                    wordLength++;
                    if (findNext(s,direction,i,j)) return true;
                }
                break;
            case 'B':
                if ((i-wordLength)>=0 && (j+wordLength)<column && s.charAt(wordLength)==wordField[i-wordLength][j+wordLength].charAt(0)){
                    wordLength++;
                    if (findNext(s,direction,i,j)) return true;
                }
                break;
            case 'C':
                if ((j+wordLength)<column && s.charAt(wordLength)==wordField[i][j+wordLength].charAt(0)){
                    wordLength++;
                    if (findNext(s,direction,i,j)) return true;
                }
                break;
            case 'D':
                if ((i+wordLength)<row && (j+wordLength)<column && s.charAt(wordLength)==wordField[i+wordLength][j+wordLength].charAt(0)){
                    wordLength++;
                    if (findNext(s,direction,i,j)) return true;
                }
                break;
            case 'E':
                if ((i+wordLength)<row && s.charAt(wordLength)==wordField[i+wordLength][j].charAt(0)){
                    wordLength++;
                    if (findNext(s,direction,i,j)) return true;
                }
                break;
            case 'F':
                if ((i+wordLength)<row && (j-wordLength)>=0 && s.charAt(wordLength)==wordField[i+wordLength][j-wordLength].charAt(0)){
                    wordLength++;
                    if (findNext(s,direction,i,j)) return true;
                }
                break;
            case 'G':
                if ((j-wordLength)>=0 && s.charAt(wordLength)==wordField[i][j-wordLength].charAt(0)){
                    wordLength++;
                    if (findNext(s,direction,i,j)) return true;
                }
                break;
            case 'H':
                if ((i-wordLength)>=0 && (j-wordLength)>=0 && s.charAt(wordLength)==wordField[i-wordLength][j-wordLength].charAt(0)){
                    wordLength++;
                    if (findNext(s,direction,i,j)) return true;
                }
                break;
        }
        return false;
    }
}
