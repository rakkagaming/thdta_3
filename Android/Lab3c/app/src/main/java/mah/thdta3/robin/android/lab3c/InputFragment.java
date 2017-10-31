package mah.thdta3.robin.android.lab3c;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class InputFragment extends Fragment {

    private Controller controller;
    private ListView listView;
    private String[] content = new String[3];

    public InputFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_input, container, false);
        initComp(view);
        return view;
    }

    private void initComp(View view) {
        listView = (ListView) view.findViewById(R.id.lvWTD);
        content[0] = view.getContext().getString(R.string.what_to_do);
        content[1] = view.getContext().getString(R.string.what_to_do2);
        content[2] = view.getContext().getString(R.string.what_to_do3);
        listView.setAdapter(new InputAdapter(view.getContext(),content));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                controller.changeView(position);
            }
        });
    }

    public void setController(Controller controller){
        this.controller = controller;
    }

}
