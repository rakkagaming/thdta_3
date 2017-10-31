package mah.thdta3.robin.android.assignment2;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class GroupsFragment extends Fragment {


    private ListView listView;
    private Controller controller;
    private ArrayList<String> list;
    private GroupAdapter adapter;

    public GroupsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_groups, container, false);
        controller = ((MainActivity)getActivity()).getController();
        initializeComponents(v);
        initializeListeners();
        return v;
    }

    private void initializeListeners() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                controller.setGroupFragment(list.get(position));
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        controller.updateGroupList();
        adapter.clear();
        listView.setAdapter(adapter);
    }

    private void initializeComponents(View v) {
        listView = (ListView) v.findViewById(R.id.groupList);
        list = controller.getGroups();
        adapter = new GroupAdapter(getActivity(), list);
    }

    public void setController(Controller controller){
        this.controller = controller;
    }

    public void updateList(ArrayList<String> groupList) {
        adapter.clear();
        for (int i = 0; i<groupList.size();i++){
            adapter.add(groupList.get(i));
        }
        adapter.notifyDataSetChanged();
    }
}
