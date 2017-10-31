package mah.thdta3.robin.android.assignment1;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailedFragment extends Fragment {

    private TextView detailTitle, detailType, detailDate, detailAmount, detailCatergory;
    private Controller controller;

    public DetailedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detailed, container, false);

        initializeComponents(v);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        controller.updateDetailFields();
    }

    private void initializeComponents(View v) {
        detailAmount = (TextView) v.findViewById(R.id.detailAmount);
        detailCatergory = (TextView) v.findViewById(R.id.detailCategory);
        detailDate = (TextView) v.findViewById(R.id.detailDate);
        detailTitle = (TextView) v.findViewById(R.id.detailTitle);
        detailType = (TextView) v.findViewById(R.id.detailType);
    }
    
    
    public void setController(Controller controller){
        this.controller = controller;
    }

    public String getDetailTitle() {
        return detailTitle.getText().toString();
    }

    public void setDetailTitle(String s) {
        detailTitle.setText(s);
    }

    public String getDetailType() {
        return detailType.getText().toString();
    }

    public void setDetailType(String s) {
        detailType.setText(s);
    }

    public String getDetailDate() {
        return detailDate.getText().toString();
    }

    public void setDetailDate(String s) {
        detailDate.setText(s);
    }

    public String getDetailAmount() {
        return detailAmount.getText().toString();
    }

    public void setDetailAmount(String s) {
        detailAmount.setText(s);
    }

    public String getDetailCatergory() {
        return detailCatergory.getText().toString();
    }

    public void setDetailCatergory(String s) {
        detailCatergory.setText(s);
    }
}
