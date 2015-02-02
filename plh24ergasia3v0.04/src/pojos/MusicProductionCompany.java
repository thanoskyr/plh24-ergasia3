/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author thanos
 */
@Entity
@Table(name = "MUSIC_PRODUCTION_COMPANY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MusicProductionCompany.findAll", query = "SELECT m FROM MusicProductionCompany m"),
    @NamedQuery(name = "MusicProductionCompany.findByName", query = "SELECT m FROM MusicProductionCompany m WHERE m.name = :name"),
    @NamedQuery(name = "MusicProductionCompany.findByAddress", query = "SELECT m FROM MusicProductionCompany m WHERE m.address = :address"),
    @NamedQuery(name = "MusicProductionCompany.findByTelephone", query = "SELECT m FROM MusicProductionCompany m WHERE m.telephone = :telephone")})
public class MusicProductionCompany implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "ADDRESS")
    private String address;
    @Basic(optional = false)
    @Column(name = "TELEPHONE")
    private int telephone;
    @OneToMany(mappedBy = "musicProductionCompanyname")
    private List<Album> albumList;

    public MusicProductionCompany() {
    }

    public MusicProductionCompany(String name) {
        this.name = name;
    }

    public MusicProductionCompany(String name, String address, int telephone) {
        this.name = name;
        this.address = address;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    @XmlTransient
    public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MusicProductionCompany)) {
            return false;
        }
        MusicProductionCompany other = (MusicProductionCompany) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.MusicProductionCompany[ name=" + name + " ]";
    }
    
}
