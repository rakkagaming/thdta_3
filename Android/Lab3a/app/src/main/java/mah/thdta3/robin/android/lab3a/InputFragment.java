package mah.thdta3.robin.android.lab3a;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class InputFragment extends Fragment {

    public static final String TAG = "Input Fragment";
    private Button btnCount;
    private Controller cont;
    private ListView lv;
    private ArrayAdapter<String> aaLV;
    private String[] content;
    private int i = 0;

    public InputFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_input, container, false);
        initializeComponents(v);
        initializeListener();
        return v;
    }

    public void setController(Controller controller){
        cont = controller;
    }

    private void initializeListener() {
        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont.btnClick(i);
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                i = position;
                cont.lvClick(content[position]);
            }
        });
    }

    public void setText(String txt){
        btnCount.setText(txt);
    }

    private void initializeComponents(View v) {
        btnCount = (Button)v.findViewById(R.id.button);
        lv = (ListView) v.findViewById(R.id.lwColours);
        content = new String[]{getString(R.string.red),getString(R.string.blue),getString(R.string.yellow),getString(R.string.green)};
        aaLV = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,content);
        lv.setAdapter(aaLV);
    }

}
