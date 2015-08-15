package pe.egcc.app.mybatis.espec;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.egcc.app.model.EmpleadoBean;


public interface EmpleadoMapper {

  List<EmpleadoBean> getTodosEmpleados();
  
}
