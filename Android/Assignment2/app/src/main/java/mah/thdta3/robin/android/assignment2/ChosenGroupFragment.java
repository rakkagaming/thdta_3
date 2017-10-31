package mah.thdta3.robin.android.assignment2;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChosenGroupFragment extends Fragment {

    private Button registerBtn, unregisterBtn;
    private TextView title;
    private ListView listView;
    private ArrayList<Member> list;
    private MemberAdapter adapter;
    private Controller controller;

    public ChosenGroupFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        controller.updateChosenGroupTitle();
        controller.updateChosenGroupList();
        adapter.clear();
        listView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chosen_group, container, false);
        controller = ((MainActivity )getActivity()).getController();
        initializeComponents(v);
        initializeListeners();
        return v;
    }

    private void initializeListeners() {
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.registerToExistingGroup(title.getText().toString());
            }
        });

        unregisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.unRegisterFromGroup(title.getText().toString());
            }
        });
    }

    private void initializeComponents(View v) {
        registerBtn = (Button) v.findViewById(R.id.chosenGroupRegister);
        unregisterBtn = (Button) v.findViewById(R.id.chosenGroupUnregister);
        title  = (TextView) v.findViewById(R.id.chosenGroupTitle);
        listView = (ListView) v.findViewById(R.id.chosenGroupList);
        list = controller.getChosenMembers();
        adapter = new MemberAdapter(getActivity(),list);
        Log.d("currentGroup","is there anything in this list? " + list.size());
        //Log.d("currentGroup","the first member: " + list.get(0));
    }

    public void setBtnDeRegister(boolean b) {
        unregisterBtn.setClickable(b);
    }

    public void setBtnRegister(boolean b) {
        registerBtn.setClickable(b);
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void updateList(ArrayList<Member> groupList) {
        adapter.clear();
        for (int i = 0; i<groupList.size();i++){
            adapter.add(groupList.get(i));
        }
        adapter.notifyDataSetChanged();
    }
}
