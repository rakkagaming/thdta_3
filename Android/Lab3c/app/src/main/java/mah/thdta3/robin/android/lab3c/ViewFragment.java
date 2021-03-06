package mah.thdta3.robin.android.lab3c;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewFragment extends Fragment {

    private TextView tvWhatToDo;
    private TextView tvContent;
    private Controller controller;

    public ViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_view, container, false);
        initComp(view);
        return view;
    }

    @Override
    public void onResume(){
        super.onResume();
        controller.updateView();

    }

    private void initComp(View view) {
        tvWhatToDo = (TextView) view.findViewById(R.id.txtWTD);
        tvContent = (TextView) view.findViewById(R.id.txtContent);
    }

    public void updateText(String whatToDo,String content) {
        tvWhatToDo.setText(whatToDo);
        tvContent.setText(content);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

}
