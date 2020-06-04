package dao;

import java.sql.Connection;

//import com.sdz.connection.SdzConnection;

public abstract class DAO<T> {
  protected Connection connect = null;
   
  public DAO(Connection conn){
    this.connect = conn;
  }
   
  /**
  * M�thode de cr�ation
  * @param obj
  * @return boolean 
  */
  public abstract boolean create(T obj);

  /**
  * M�thode pour effacer
  * @param obj
  * @return boolean 
  */
  public abstract boolean delete(T obj);

  /**
  * M�thode de mise � jour
  * @param obj
  * @return boolean
  */
  public abstract boolean update(T obj);

  /**
  * M�thode de recherche des informations des etudiants/profs/admin
  * @param id
  * @return T
  */
  public abstract T find();
  public abstract T find (String email, String password);

  public Connection getConnect()
  {
      return connect;
  }
}