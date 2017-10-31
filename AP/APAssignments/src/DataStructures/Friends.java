package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by robin on 26/09/2017.
 */
public class Friends {

    private int rounds,pairs,inhabitants,biggestGroup = 1;
    private String[] input;
    private ArrayList<Inhabitant> list = new ArrayList<>();
    private Inhabitant in;

    public static void main(String[] args) {
        Friends go = new Friends();
        try {
            go.countFriends();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void countFriends() throws IOException {
        BufferedReader instream = new BufferedReader(new InputStreamReader(System.in));

        rounds = Integer.parseInt(instream.readLine().toString());
        for (int i = 0; i < rounds; i++) {
            input = instream.readLine().split(" ");
            inhabitants = Integer.parseInt(input[0]);
            pairs = Integer.parseInt(input[1]);

            //Create the inhabitants
            for (int j = 1; j < inhabitants+1; j++) {
                list.add(new Inhabitant(j));
            }


            //Do a rundown of all the known given pairs and link them together
            for (int j = 0; j < pairs; j++) {
                input = instream.readLine().split(" ");
                list.get(Integer.parseInt(input[0])-1).addFriend(Integer.parseInt(input[1]));
                list.get(Integer.parseInt(input[1])-1).addFriend(Integer.parseInt(input[0]));
            }

            //Go through all the inhabitants and link together their friends
            for (int j = 0; j < inhabitants; j++) {
                if (!list.get(j).isChecked()){
                    linkFriends(j);
                }
                if (biggestGroup<(list.get(j).getFriendGroup())){
                    biggestGroup = list.get(j).getFriendGroup();
                }
            }

            System.out.println(biggestGroup);
            list.clear();
            biggestGroup = 1;
        }
    }

    //Adds the friends of connected friends to the current inhabitant
    private void linkFriends(int j) {
        int x = list.get(j).getFriendGroup();
        list.get(j).setChecked();
        for (int i = 0; i < x; i++) {
            int y = list.get(j).list.get(i);
            if (!list.get(y-1).isChecked()){

                linkFriends(y-1);
                list.get(j).addFriends(list.get(y-1).list);
            }
        }
    }

    private class Inhabitant{
        
        private int id;
        private boolean checked = false;
        private ArrayList<Integer> list = new ArrayList();
        
        public Inhabitant(int id){
            this.id = id;
        }

        private void addFriend(int friend){
            if (!list.contains(friend))list.add(friend);
        }
        private void addFriends(ArrayList<Integer> friend){
            for (int i = 0; i < friend.size(); i++) {
                if(!list.contains(friend.get(i))){
                    list.add(friend.get(i));
                }
            }
        }

        private int getFriendGroup(){
            return list.size();
        }

        private void setChecked(){
            checked = true;
        }
        private boolean isChecked(){
            return checked;
        }
    }
}


