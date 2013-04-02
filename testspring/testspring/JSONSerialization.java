package testspring.testspring;

import com.google.gson.Gson;

//import com.google.gson.*;
public class JSONSerialization implements SerializeTool {
	
	public String doSerialize(Object obj)
	{
		Gson gson = new Gson();
		return gson.toJson(obj);
	}

}
