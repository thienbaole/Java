package testspring.testspring;

import java.io.Serializable;

public class RuntimeRecord {
	private String startTime;
	private String endTime;
	private String className;
	private String methodName;
	
	public RuntimeRecord(String start, String end, String classname, String method)
	{
		startTime = start;
		end = endTime;
		className = classname;
		methodName = method;
	}
}
