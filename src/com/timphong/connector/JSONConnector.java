package com.timphong.connector;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.timphong.models.Account;
import com.timphong.models.Room;

public class JSONConnector {
	
	private static JSONConnector instance;
	private Gson gson;
	
	public static JSONConnector getInstance() {
		if (instance == null)
			instance = new JSONConnector();
		return instance;
	}
	
	private JSONConnector() {
		gson = new Gson();
	}

	public ArrayList<Room> getRoomList() throws JsonIOException, JsonSyntaxException, IOException {
		Type listType = new TypeToken<List<Room>>(){}.getType();
		return gson.fromJson(new FileReader(this.getFilePath("room.json")), listType);
	}
	
	public void writeToJSONFile(ArrayList<Room> roomList) throws JsonIOException, IOException {
		try (Writer writer = new FileWriter(this.getFilePath("rooms.json"))) {
			gson = new GsonBuilder().setPrettyPrinting().create();
			gson.toJson(roomList, writer);
		}
	}
	
	public void checkRoom(int roomID) throws JsonIOException, JsonSyntaxException, IOException {
		ArrayList<Room> roomList = this.getRoomList();
		for (Room item : roomList) {
			if (item.getId() == roomID) {
				item.setCheck(true);
				break;
			}
		}
		this.writeToJSONFile(roomList);
	}
	
	public boolean checkLogin(Account account) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		Account storedAccount = gson.fromJson(new FileReader(this.getFilePath("account.json")), Account.class);
		
		if (account.getUsername().equals(storedAccount.getUsername()) &&
				account.getPassword().equals(storedAccount.getPassword())) {
			return true;
		}
		return false;
	}
	
	private File getFilePath(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		return new File(classLoader.getResource(fileName).getFile());
	}
}