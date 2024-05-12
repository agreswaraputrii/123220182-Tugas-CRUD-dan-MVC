/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImplement;
import java.util.List;
import model .*;
/**
 *
 * @author DELL
 */
public interface DataMovieImplement {
    public void insert(DataMovie m);
    public void update(DataMovie m);
    public void delete(String judul);
    public List<DataMovie> getAll();
}
