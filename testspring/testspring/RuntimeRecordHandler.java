package testspring.testspring;

import org.springframework.beans.factory.annotation.Autowired;

public class RuntimeRecordHandler {
	@Autowired
	RuntimeRecordJDBCTemplate runtimeRecordJDBCTemplate;
	@Autowired
	SerializeTool tool;
	public RuntimeRecordJDBCTemplate getRuntimeRecordJDBCTemplate() {
		return runtimeRecordJDBCTemplate;
	}
	public void setRuntimeRecordJDBCTemplate(
			RuntimeRecordJDBCTemplate runtimeRecordJDBCTemplate) {
		this.runtimeRecordJDBCTemplate = runtimeRecordJDBCTemplate;
	}
	public SerializeTool getTool() {
		return tool;
	}
	public void setTool(SerializeTool tool) {
		this.tool = tool;
	}
	public void processRuntimeRecord(String record)
	{
		System.out.println("Getting from Topic...");
		System.out.println(record);
		//store to DB
		RuntimeRecord runtime = (RuntimeRecord)tool.doDeserialize(record);
		System.out.println("Storing to persistent...:" +runtime);
		runtimeRecordJDBCTemplate.store(runtime);
	}
}
