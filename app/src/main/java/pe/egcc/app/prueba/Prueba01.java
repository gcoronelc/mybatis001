package pe.egcc.app.prueba;

import java.io.Reader;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pe.egcc.app.model.EmpleadoBean;
import pe.egcc.app.mybatis.espec.EmpleadoMapper;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 */
public class Prueba01 {

  public static void main(String[] args) {
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sqlSession = null;
    EmpleadoMapper empleadoMapper;
    List<EmpleadoBean> lista;
    try {
      String resource = "pe/egcc/app/mybatis/db/mybatis-config.xml";
      Reader reader = Resources.getResourceAsReader(resource);
      // Instanciación del Factory
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
      // Crear el Objeto Session
      sqlSession = sqlSessionFactory.openSession();
      // Obteniendo el Mapper
      empleadoMapper = sqlSession.getMapper(EmpleadoMapper.class);
      // Obtener la lista de empleados
      lista = empleadoMapper.getTodosEmpleados();
      // Mostrar datos
      for (EmpleadoBean empleadoBean : lista) {
        System.out.println(empleadoBean.getCodigo() + 
                " - " + empleadoBean.getNombre());
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if(sqlSession != null) sqlSession.close();
      } catch (Exception e) {
      }
    }
  }
}
