package mah.thdta3.robin.android.assignment1;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    private Controller controller;
    private Button incomeMenuBtn, expenditureMenuBtn;
    private TextView menuTitleTxt, menuCBTxt, menuBalanceTxt;

    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_menu, container, false);
        initializeComponents(v);
        initializeListners();
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        controller.updateUserName();
        controller.getTransactions();
        controller.updateBalance();
    }

    private void initializeListners() {
        incomeMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //controller.goToTransactionHistory();
                controller.goToIncome();
                Toast.makeText(getActivity(), "Pressed Income", Toast.LENGTH_SHORT).show();
            }
        });

        expenditureMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //controller.goToTransactionHistory();
                controller.goToExpenditure();
                Toast.makeText(getActivity(), "Pressed Expenditure", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initializeComponents(View v) {
        incomeMenuBtn = (Button) v.findViewById(R.id.menuIncome);
        expenditureMenuBtn = (Button) v.findViewById(R.id.menuExpenditure);
        menuTitleTxt = (TextView) v.findViewById(R.id.menuTitle);
        menuCBTxt = (TextView) v.findViewById(R.id.menuCurrentBalance);
        menuBalanceTxt = (TextView) v.findViewById(R.id.menuBalance);
    }

    public void setMenuTitle(String user){
        menuTitleTxt.setText(user);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setBalance(int balance) {
        menuBalanceTxt.setText("" + balance);
    }
}
