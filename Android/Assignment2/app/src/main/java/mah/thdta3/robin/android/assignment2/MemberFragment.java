package mah.thdta3.robin.android.assignment2;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MemberFragment extends Fragment {

    private ListView listView;
    private TextView currentGroup;
    private Controller controller;
    private ArrayList<Member> list;
    private MemberAdapter adapter;

    public MemberFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_member, container, false);
        controller = ((MainActivity )getActivity()).getController();
        initializeComponents(v);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        controller.updateMFTitle();
        controller.updateGroupMemberList();
        adapter.clear();
        listView.setAdapter(adapter);
    }

    private void initializeComponents(View v) {
        listView = (ListView) v.findViewById(R.id.memberList);
        currentGroup = (TextView) v.findViewById(R.id.membersCurrentGroup);

        list = controller.getCurrentGroupMembers();
        adapter = new MemberAdapter(getActivity(),list);
    }

    public void setController(Controller controller){
        this.controller = controller;
    }

    public void setTitle(String s){
        currentGroup.setText(s);
    }

    public void updateList(ArrayList<Member> list) {
        adapter.clear();
        for (int i = 0; i<list.size();i++){
            Log.d("tracking","adding to list: " + list.get(i).getName());
            Log.d("tracking","adding to list: " + list.get(i).getGroup());
            adapter.add(list.get(i));
        }
        adapter.notifyDataSetChanged();
        Log.d("tracking","list updated");
    }
}
