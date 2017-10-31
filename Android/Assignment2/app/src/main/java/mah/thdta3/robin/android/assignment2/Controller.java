package mah.thdta3.robin.android.assignment2;

import android.app.FragmentManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Timer;

/**
 * Created by robin on 03/10/2017.
 */

public class Controller {
    private LocationListener locationListener;
    private MainActivity mainActivity;
    private MapFragment mapFragment;
    private LocationManager locationManager;
    private double longitude,latitude;
    private ServiceConnection serviceConnection;
    private Listener listener;
    private CommunicationService communicationService;
    private DataFragment dataFragment;
    private ServerCommands serverCommands;
    private MemberFragment memberFragment;
    private GroupsFragment groupsFragment;
    private RegisterFragment registerFragment;
    private ChosenGroupFragment chosenGroupFragment;
    private Timer timer;


    private boolean connected = false, bound = false;
    private int currentFragment=0;
    private ArrayList<String> myGroups;
    private ArrayList<Member> currentGroupMembers, chosenGroup;
    private Member currentUser;

    public Controller(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.locationListener = new LocList();

        locationManager = (LocationManager) mainActivity.getSystemService(Context.LOCATION_SERVICE);


        initializeDataFragment();
        initializeCommunication();

        this.mapFragment =  new MapFragment();
        this.memberFragment = new MemberFragment();
        this.groupsFragment = new GroupsFragment();
        //this.dataFragment = new DataFragment();
        this.serverCommands = new ServerCommands();
        this.registerFragment = new RegisterFragment();
        this.chosenGroupFragment = new ChosenGroupFragment();

        currentUser = new Member("","","","");
        currentGroupMembers = new ArrayList<>();
        currentGroupMembers.add(currentUser);

        mapFragment.setController(this);
        memberFragment.setController(this);
        groupsFragment.setController(this);
        registerFragment.setController(this);

        mainActivity.setFragment(mapFragment,true);


    }

    private void initializeCommunication() {
        Intent intent = new Intent(mainActivity,CommunicationService.class);

        if(!dataFragment.getServiceExist()) {
            mainActivity.startService(intent);
            dataFragment.setServiceExist(true);
        }else {
            connected = dataFragment.getConnected();
        }
        serviceConnection = new ServiceConnection();
        boolean status = mainActivity.bindService(intent, serviceConnection, 0);
        Log.d("Connected", ""+status);
    }

    public void initializeDataFragment(){
        FragmentManager fm = mainActivity.getFragmentManager();
        dataFragment = (DataFragment) fm.findFragmentByTag("data");
        if(dataFragment == null){
            dataFragment = new DataFragment();
            fm.beginTransaction().add(dataFragment, "data").commit();
        }
    }

    public void onResume(){
        if(timer == null){
            timer = new Timer();
            timer.schedule(new TimerTask(),0, 30000);
        }

    }

    public void onPause() {
        if(mainActivity.isFinishing()){
            mainActivity.getFragmentManager().beginTransaction().remove(dataFragment).commit();
        }
    }

    public void onDestroy(){

        if(bound){

            if(mainActivity.isFinishing()){
                communicationService.disconnect();
                communicationService.stopService(new Intent(mainActivity, CommunicationService.class));
            }
            mainActivity.unbindService(serviceConnection);
            listener.stopListener();
            bound = false;

            timer.cancel();
            timer.purge();
            timer = null;

        }

    }

    public void setStartPosition(double startLong, double startLat) {
        this.latitude = startLong;
        this.longitude = startLat;
        dataFragment.setCurrentLat(startLat);
        dataFragment.setCurrentLong(startLong);
    }

    public void switchFragment(int fragment){
        switch (fragment){
            case R.id.map:
                currentFragment = 0;
                break;
            case R.id.members:
                currentFragment = 1;
                break;
            case R.id.groups:
                currentFragment = 2;
                break;
            case R.id.register:
                currentFragment = 3;
                break;
        }
        dataFragment.setCurrentFragment(currentFragment);
        setFragment(currentFragment);
    }

    public void setFragment(int fragment) {
        switch (fragment){
            case 0:
                mapFragment.updateMapPosition(currentUser);
                mainActivity.setFragment(mapFragment,true);
                break;
            case 1:
                mainActivity.setFragment(memberFragment,true);
                break;
            case 2:
                mainActivity.setFragment(groupsFragment, true);
                break;
            case 3:
                mainActivity.setFragment(registerFragment, true);
                break;
        }
    }

    public void updateMFTitle() {
        memberFragment.setTitle(dataFragment.getCurrentGroup());
    }


    public boolean checkPermission() {
        if (ContextCompat.checkSelfPermission(mainActivity, android.Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(mainActivity, android.Manifest.permission.ACCESS_COARSE_LOCATION) ==
                        PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            ActivityCompat.requestPermissions(mainActivity, new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 0);
        }
        return false;
    }

    public DataFragment getDataFragment() {
        return dataFragment;
    }

    public ArrayList<Member> getChosenMembers() {
        JSONObject membersObject = serverCommands.groupMembers(dataFragment.getClickedGroup());
        Log.d("currentGroup", "in getCurrentGroupMembers, group chosen: " + dataFragment.getClickedGroup());
        if(communicationService != null){
            communicationService.sendInformation(membersObject);
        }

        ArrayList<String> myGroups = dataFragment.getMyGroups();
        chosenGroup = new ArrayList<>();
        for(int i = 0; i < myGroups.size(); i++){
            Log.v("CONTROLLER FIRST GROUP", myGroups.get(i));
            ArrayList<Member> tempList = dataFragment.getFromMap(myGroups.get(i));

            for(int j = 0; j < tempList.size(); j++){
                chosenGroup.add(tempList.get(j));
            }
        }
        return dataFragment.getClickedGroupList();
    }

    public void updateChosenGroupList() {
        JSONObject memberList = serverCommands.groupMembers(dataFragment.getClickedGroup());

        if(communicationService != null) {
            communicationService.sendInformation(memberList);
        }else{
            memberFragment.updateList(dataFragment.getClickedGroupList());
        }
    }

    public void setGroupFragment(String groupName) {
        JSONObject groupObject = serverCommands.groupMembers(groupName);
        dataFragment.setClickedGroup(groupName);
        communicationService.sendInformation(groupObject);
        Log.d("currentGroup","group clicked: " + groupName);

        mainActivity.setFragment(chosenGroupFragment, true);
        currentFragment = 4;
    }

    public void updateChosenGroupTitle() {
        chosenGroupFragment.setTitle(dataFragment.getClickedGroup());
    }

    private class TimerTask extends java.util.TimerTask{

        @Override
        public void run() {
            setPosition();
        }
    }

    public void setPosition(){
        if(connected != false && !dataFragment.getCurrentUsername().equals("") && communicationService != null){
            ArrayList<String> temp = dataFragment.getMyGroups();
            for(int i = 0; i < temp.size(); i++) {
                JSONObject sendObject = serverCommands.setPosition(dataFragment.getFromIdMap(temp.get(i)),
                        String.valueOf(dataFragment.getCurrentLong()), String.valueOf(dataFragment.getCurrentLat()));
                communicationService.sendInformation(sendObject);
                // TODO: 05/10/2017 when do I go here now again?
                Log.d("markers","in SetPosition(), updaterar pos för: " + temp.get(i));
                Log.d("markers","in SetPosition(), lat+long " + dataFragment.getCurrentLat() + " " + dataFragment.getCurrentLong());
            }
        }
    }

    public void connect(){
        Log.d("tracking", "in controller.connect(), Starting connection" );
        connected = true;
        dataFragment.setConnected(connected);
        communicationService.connect();

    }

    public ArrayList<String> getGroups() {
        JSONObject groupsObject = serverCommands.currentGroups();
        if(communicationService != null){
            //Har en Log.d som skriver ut text. Men denna log visas efter nedanstående Log
            communicationService.sendInformation(groupsObject);
        }

        myGroups = dataFragment.getGroupList();

        //Denna skrivs ut först
        Log.d("tracking", "in getGroups(), size of getMyGroups: " + myGroups.size());

        return myGroups;
    }

    public void groupMarkers(ArrayList<Member> positionList){
        // TODO: 05/10/2017 this returns null on the lat and long! fix that 
        mapFragment.updateMapMarkers(positionList);
    }

    public ArrayList<Member> getCurrentGroupMembers() {
        JSONObject membersObject = serverCommands.groupMembers(dataFragment.getCurrentGroup());
        Log.d("CONTROLLER", "in getCurrentGroupMembers, CALLING" + communicationService);
        if(communicationService != null){
            communicationService.sendInformation(membersObject);
        }

        ArrayList<String> myGroups = dataFragment.getMyGroups();
        currentGroupMembers = new ArrayList<>();
        for(int i = 0; i < myGroups.size(); i++){
            Log.v("CONTROLLER FIRST GROUP", myGroups.get(i));
            ArrayList<Member> tempList = dataFragment.getFromMap(myGroups.get(i));

            for(int j = 0; j < tempList.size(); j++){
                currentGroupMembers.add(tempList.get(j));
            }
        }
        return currentGroupMembers;
    }

    public String register(String name, String group) {
        if (name.equals("") || group.equals("")){
            return "One or more fields missing";
        }

        dataFragment.setCurrentUsername(name);
        dataFragment.setCurrentGroup(group);
        currentUser = new Member(name,""+dataFragment.getCurrentLong(),""+dataFragment.getCurrentLat(),group);

        JSONObject registrationObject = serverCommands.register(group, name);
        communicationService.sendInformation(registrationObject);
        mainActivity.setCurrentUser(name);

        return "Registration successful";
    }

    public String deRegister(String id){

        dataFragment.setCurrentGroup("");
        dataFragment.setCurrentUsername("");

        JSONObject deregisterObject = serverCommands.deRegistration(id);
        communicationService.sendInformation(deregisterObject);

        return "Unregistered";
    }

    public void updateGroupList() {
        JSONObject group = serverCommands.currentGroups();

        if(communicationService != null) {
            communicationService.sendInformation(group);
        }else{
            groupsFragment.updateList(dataFragment.getGroupList());
        }

    }

    public void updateGroupMemberList() {
        JSONObject memberList = serverCommands.groupMembers(dataFragment.getCurrentGroup());

        if(communicationService != null) {
            communicationService.sendInformation(memberList);
        }else{
            memberFragment.updateList(dataFragment.getClickedGroupList());
        }

    }

    public String registerToExistingGroup(String group){
        if(currentUser.getName().equals("")){
            Toast.makeText(mainActivity, "You need to register before joining a group", Toast.LENGTH_SHORT).show();
            return "";
        }
        JSONObject registerObject = serverCommands.register(group, dataFragment.getCurrentUsername());
        communicationService.sendInformation(registerObject);

        JSONObject updatedGroup = serverCommands.groupMembers(dataFragment.getClickedGroup());
        communicationService.sendInformation(updatedGroup);
        chosenGroupFragment.setBtnRegister(false);
        chosenGroupFragment.setBtnDeRegister(true);
        Toast.makeText(chosenGroupFragment.getActivity(), "Registration Successfull!", Toast.LENGTH_SHORT).show();
        return "";
    }

    public void unRegisterFromGroup(String s) {
        String id = dataFragment.getFromIdMap(s);
        if(id == null){
            return;
        }
        JSONObject deRegistration = serverCommands.deRegistration(id);
        //ataFragment.removeFromIdMap(s);
        //dataFragment.removeGroup(s);
        communicationService.sendInformation(deRegistration);
        chosenGroupFragment.setBtnDeRegister(false);
        chosenGroupFragment.setBtnRegister(true);
        JSONObject updatedGroup = serverCommands.groupMembers(dataFragment.getClickedGroup());
        communicationService.sendInformation(updatedGroup);
        Toast.makeText(chosenGroupFragment.getActivity(), "Deregistration succesfull", Toast.LENGTH_SHORT).show();
    }

    private class LocList implements LocationListener{

        @Override
        public void onLocationChanged(Location location) {
            latitude = location.getLatitude();
            longitude = location.getLongitude();
            dataFragment.setCurrentLat(latitude);
            dataFragment.setCurrentLong(longitude);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }

    private class ServiceConnection implements android.content.ServiceConnection{
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            CommunicationService.LocalService ls = (CommunicationService.LocalService) service;
            communicationService = ls.getService();
            bound = true;
            listener = new Listener();
            listener.start();

            if(connected == false){
                connect();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            bound = false;
        }
    }

    private class Listener extends Thread{
        public void stopListener(){
            interrupt();
            listener = null;
        }

        @Override
        public void run() {
            String message;
            Exception exception;
            while(listener != null){
                try{
                    message = communicationService.receiveInformation();
                    mainActivity.runOnUiThread(new UpdateUI(message));
                }catch(InterruptedException e){
                    e.printStackTrace();
                    listener = null;
                }

            }
        }
    }
    private class UpdateUI implements Runnable{
        private String message;

        public UpdateUI(String message){
            this.message = message;
        }

        @Override
        public void run() {
            recievedData(message);
            Exception exception = communicationService.getException();
            if("CONNECTED".equals(message)){
                connected = true;
            }else if("CLOSED".equals(message)){
                connected = false;
            }else if("EXCEPTION".equals(message) && exception != null){
                message = exception.toString();
            }
        }
    }

    public void recievedData(String message){
        JSONObject recievedObject;
        String type, id, group;
        JSONArray arr;
        ArrayList<Member> memberList;
        ArrayList<String> groupList;
        ArrayList<Member> positionList;
        try{
            recievedObject = new JSONObject(message);
            type = recievedObject.getString(ServerCommands._TYPE);
            checkPermission();


            switch(type){
                case ServerCommands._REGISTER:
                    group = recievedObject.getString(ServerCommands._GROUP);
                    id = recievedObject.getString(ServerCommands._ID);
                    Log.d("RECIEVED ID : ", id);
                    dataFragment.addToIdMap(group, id);
                    dataFragment.addGroup(group);
                    dataFragment.addToMap(group, new ArrayList<Member>());
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 15000, 0, locationListener);
                    break;

                case ServerCommands._MEMBERS:
                    arr = recievedObject.getJSONArray(ServerCommands._MEMBERS);
                    group = recievedObject.getString(ServerCommands._GROUP);
                    memberList = new ArrayList<>();
                    JSONObject member;
                    for(int i = 0; i < arr.length(); i++){
                        member = arr.getJSONObject(i);
                        memberList.add(new Member(member.getString(ServerCommands._MEMBER)));
                        //Log.d("marking","in _MEMBERS, lat of currently added: " + dataFragment.getClickedGroupList().get(i).getLatitude());
                    }
                    dataFragment.setClickedGroup(recievedObject.getString(ServerCommands._GROUP));
                    dataFragment.setClickedGroupList(memberList);
                    Log.d("tracking","in recievedData-_Members, amount of members: " + dataFragment.getClickedGroupList().size());

                    if (currentFragment==1) {
                        memberFragment.updateList(dataFragment.getClickedGroupList());
                    }else if(currentFragment == 4){
                        chosenGroupFragment.updateList(dataFragment.getClickedGroupList());
                    }
                    break;

                case ServerCommands._GROUPS:
                    arr = recievedObject.getJSONArray(ServerCommands._GROUPS);
                    groupList = new ArrayList<>();
                    JSONObject group1;
                    for(int i = 0; i < arr.length(); i++){
                        group1 = arr.getJSONObject(i);
                        groupList.add(group1.getString(ServerCommands._GROUP));
                    }

                    dataFragment.setGroupList(groupList);
                    groupsFragment.updateList(dataFragment.getGroupList());
                    break;

                case ServerCommands._UNREGISTER:

                    break;

                case ServerCommands._LOCATIONS:
                    arr = recievedObject.getJSONArray(ServerCommands._LOCATION);
                    group = recievedObject.getString(ServerCommands._GROUP);
                    positionList = new ArrayList<>();
                    JSONObject member1;
                    for(int i = 0; i < arr.length(); i++){
                        member1 = arr.getJSONObject(i);
                        positionList.add(new Member(member1.getString(ServerCommands._MEMBER), member1.getString(ServerCommands._LONGITUDE), member1.getString(ServerCommands._LATITUDE), group));
                    }

                    Log.d("markers","in recievedData-_LOCATIONS, current group: " + group);
                    ArrayList<Member> tempList = dataFragment.getFromMap(group);
                    Log.d("markers","in recievedData-_LOCATIONS, getFromMap" + dataFragment.getFromMap(group).size());
                    if(tempList.size() != 0){
                        for(Member m: tempList){

                            for(Member m1: positionList){
                                if(m1.getName().equals(m.getName())){
                                    m1.setShowOnMap(m.isShowOnMap());
                                }
                            }
                        }
                    }
                    dataFragment.addToMap(group, positionList);
                    groupMarkers(positionList);

                    break;

                case ServerCommands._EXCEPTION:
                    JSONObject json = serverCommands.register(dataFragment.getCurrentUsername(), dataFragment.getCurrentGroup());
                    communicationService.sendInformation(json);

                    break;

            }

        }catch(JSONException e){

        }

    }

}
