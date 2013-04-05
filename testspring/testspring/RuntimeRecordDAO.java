package testspring.testspring;

import java.util.List;
import javax.sql.DataSource;

public interface RuntimeRecordDAO {
   
   public void setDataSource(DataSource ds);
   public void store(RuntimeRecord record);
   public RuntimeRecord getRecord(Integer id);
   public List<RuntimeRecord> listRuntimeRecords();
   public void delete(Integer id);
}