package testspring.testspring;

import com.google.gson.Gson;

//import com.google.gson.*;
public class JSONSerialization implements SerializeTool {
	
	public String doSerialize(Object obj)
	{
		Gson gson = new Gson();
		return gson.toJson(obj);
	}
	public RuntimeRecord doDeserialize(String json)
	{
		Gson gson = new Gson();
		return (RuntimeRecord)gson.fromJson(json, RuntimeRecord.class);
	}

}
