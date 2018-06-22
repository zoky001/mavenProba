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
package org.foi.nwtis.zorhrncic.web.podaci;

import java.util.List;

/**
 *
 * @author Zoran
 */
public class Placanja3mjeseca {

    private String ime;
    private String prezime;
    private String napomena;
    private List<PlacanjeUJednomMjesecu> listaMejseciPlacanja;

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public List<PlacanjeUJednomMjesecu> getListaMejseciPlacanja() {
        return listaMejseciPlacanja;
    }

    public void setListaMejseciPlacanja(List<PlacanjeUJednomMjesecu> listaMejseciPlacanja) {
        this.listaMejseciPlacanja = listaMejseciPlacanja;
    }
    
    


}
