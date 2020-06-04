package dao;

import java.sql.Connection;
import modele.*;

public class SeanceDAO extends DAO<Seance>{

    public SeanceDAO(Connection conn) {
        super(conn);
    }
    

    @Override
    public boolean create(Seance obj) {
        return false;
    }

    @Override
    public boolean delete(Seance obj) {
        return false;
    }

    @Override
    public boolean update(Seance obj) {
        return false;
    }

    @Override
    public Seance find() {
        Seance seance=new Seance();
        return seance;
    }

    @Override
    public Seance find(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
