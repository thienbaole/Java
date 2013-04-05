package testspring.testspring;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RuntimeRecordMapper implements RowMapper {

	@Override
	public RuntimeRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		 RuntimeRecord record = new RuntimeRecord();
		 record.setStartTime(rs.getString("startTime"));
		 record.setEndTime(rs.getString("endTime"));
		 record.setClassName(rs.getString("className"));
		 record.setMethodName(rs.getString("methodName"));
	     return record;
	}

}
