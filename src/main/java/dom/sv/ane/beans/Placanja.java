/*
 * Copyright 2018 JoinFaces.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dom.sv.ane.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.scene.control.TableColumn.CellEditEvent;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.foi.nwtis.zorhrncic.web.podaci.Dnevnik;
import org.foi.nwtis.zorhrncic.web.podaci.Placanja3mjeseca;
import org.foi.nwtis.zorhrncic.web.podaci.PlacanjeUJednomMjesecu;
import org.foi.nwtis.zorhrncic.web.podaci.User;
import org.primefaces.event.RowEditEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author Zoran
 */
@ManagedBean(name = "placanja")
@SessionScoped
public class Placanja implements Serializable {

    //private List<Car> cars1;
    //   private List<Car> cars2;
    //  @ManagedProperty("#{carService}")
    //   private CarService service;
    private List<User> users;

    private List<Placanja3mjeseca> placanja3mjeseca;

    @PostConstruct
    public void init() {
        placanja3mjeseca = new ArrayList<Placanja3mjeseca>();
        Placanja3mjeseca p;
        PlacanjeUJednomMjesecu placanje;
        List<PlacanjeUJednomMjesecu> listaPlacanja;
        for (int i = 0; i < 100; i++) {
            p = new Placanja3mjeseca();
            listaPlacanja = new ArrayList<PlacanjeUJednomMjesecu>();
            p.setIme("korisnik_" + i);
            p.setPrezime("Prezime_" + i + 2);
            p.setNapomena("REDOVAN");
            for (int j = 0; j < 3; j++) {
                placanje = new PlacanjeUJednomMjesecu();
              //  Double d = new Double(Math.random() * 4500);
               
                placanje.setCijena(4500);
                placanje.setDatumPlacanja(new Date());
                placanje.setPlacenoZaMjesec(j + "/2018");
                placanje.setPlaceniIznos(3400);
                listaPlacanja.add(placanje);
            }
            p.setListaMejseciPlacanja(listaPlacanja);
            placanja3mjeseca.add(p);
        }

    }

    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Car Edited", ((Placanja3mjeseca) event.getObject()).getIme());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Placanja3mjeseca) event.getObject()).getIme());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }


    public void refresh() {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: ");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Placanja3mjeseca> getPlacanja3mjeseca() {
        return placanja3mjeseca;
    }

    public void setPlacanja3mjeseca(List<Placanja3mjeseca> placanja3mjeseca) {
        this.placanja3mjeseca = placanja3mjeseca;
    }

}
