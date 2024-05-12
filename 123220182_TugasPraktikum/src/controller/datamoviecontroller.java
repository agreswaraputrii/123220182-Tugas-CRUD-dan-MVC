/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.List;
import DAODataMovie.DataMovieDAO;
import DAOImplement.DataMovieImplement;
import model.*;
import view.MainView;
/**
 *
 * @author DELL
 */
public class datamoviecontroller {
    MainView frame;
    DataMovieImplement impldatamovie;
    List<DataMovie> dm;
    
    public datamoviecontroller (MainView frame){
        this.frame = frame;
        impldatamovie = new DataMovieDAO();
        dm = impldatamovie.getAll();
    }
    public void isiTabel(){
        dm = impldatamovie.getAll();
        ModelTableDataMovie mm = new ModelTableDataMovie(dm);
        frame.getTabelDataMovie().setModel(mm);
    }
    public void insert(){
        DataMovie dm = new DataMovie();
        dm.setJudul(frame.getjTextJudul().getText());
        dm.setAlur(Double.parseDouble(frame.getjTextAlur().getText()));
        dm.setPenokohan(Double.parseDouble(frame.getjTextPenokohan().getText()));
        dm.setAkting(Double.parseDouble(frame.getjTextAkting().getText()));
        impldatamovie.insert(dm);
    }
    public void update(){
        DataMovie dm = new DataMovie();
        dm.setJudul(frame.getjTextJudul().getText());
        dm.setAlur(Double.parseDouble(frame.getjTextAlur().getText()));
        dm.setPenokohan(Double.parseDouble(frame.getjTextPenokohan().getText()));
        dm.setAkting(Double.parseDouble(frame.getjTextAkting().getText()));
        impldatamovie.update(dm);
    }
    public void delete(){
        String judul = (frame.getjTextJudul().getText());
        impldatamovie.delete(judul);
    }
}
