package mah.thdta3.robin.android.lab7e;

/**
 * Created by robin on 25/09/2017.
 */

public class Controller{
    private MainActivity ui;
    private Poop view1,view2,view3,view4,view5,view6,view7,view8,view9,view10,view11,view12,view13,view14,view15;

    public Controller(MainActivity ui){
        this.ui = ui;
        view1 = (Poop)ui.findViewById(R.id.t1);
        view2 = (Poop)ui.findViewById(R.id.t2);
        view3 = (Poop)ui.findViewById(R.id.t3);
        view4 = (Poop)ui.findViewById(R.id.t4);
        view5 = (Poop)ui.findViewById(R.id.t5);
        view6 = (Poop)ui.findViewById(R.id.t6);
        view7 = (Poop)ui.findViewById(R.id.t7);
        view8 = (Poop)ui.findViewById(R.id.t8);
        view9 = (Poop)ui.findViewById(R.id.t9);
        view10 = (Poop)ui.findViewById(R.id.t10);
        view11 = (Poop)ui.findViewById(R.id.t11);
        view12 = (Poop)ui.findViewById(R.id.t12);
        view13 = (Poop)ui.findViewById(R.id.t13);
        view14 = (Poop)ui.findViewById(R.id.t14);
        view15 = (Poop)ui.findViewById(R.id.t15);

    }

    public void startATask1() {
        view1.party(ui);

        view6.party(ui);

        view11.party(ui);

    }

    public void startATask2() {

        view2.party(ui);

        view7.party(ui);

        view12.party(ui);

    }

    public void startATask3() {

        view3.party(ui);

        view8.party(ui);

        view13.party(ui);

    }

    public void startATask4() {

        view4.party(ui);

        view9.party(ui);

        view14.party(ui);
    }

    public void startATask5() {

        view5.party(ui);

        view10.party(ui);

        view15.party(ui);
    }

}
