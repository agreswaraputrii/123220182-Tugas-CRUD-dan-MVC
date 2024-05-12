/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAODataMovie;
import java.sql.*;
import java.util.*;
import koneksi.Connector;
import model.*;
import DAOImplement.DataMovieImplement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class DataMovieDAO implements DataMovieImplement{
    Connection connection;
    
    final String select = "SELECT * FROM movie";
    final String insert = "INSERT INTO movie (judul, alur, penokohan, akting, nilai) VALUES (?, ?, ?, ?, ?);";
    final String update = "UPDATE movie SET alur=?, penokohan=?, akting=? where judul=?;";
    final String delete = "DELETE FROM movie WHERE judul=?;";
    
    public DataMovieDAO(){
        connection = Connector.connection();
    }

    @Override
    public void insert(DataMovie m) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, m.getJudul());
            statement.setDouble(2, m.getAlur());
            statement.setDouble(3, m.getPenokohan());
            statement.setDouble(4, m.getAkting());
            statement.setDouble(5, m.getRating());
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex ){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(DataMovie m) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setDouble(1, m.getAlur());
            statement.setDouble(2, m.getPenokohan());
            statement.setDouble(3, m.getAkting());
            statement.setString(4, m.getJudul());
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex ){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String judul) {
       PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setString(1, judul);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex ){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<DataMovie> getAll() {
        List<DataMovie> dm = null;
        try{
            dm = new ArrayList<DataMovie>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                DataMovie mv = new DataMovie();
                mv.setJudul(rs.getString("judul"));
                mv.setAlur(rs.getDouble("alur"));
                mv.setPenokohan(rs.getDouble("penokohan"));
                mv.setAkting(rs.getDouble("akting"));
                dm.add(mv);
            }
        }catch(SQLException ex){
            Logger.getLogger(DataMovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dm;
    }
}
