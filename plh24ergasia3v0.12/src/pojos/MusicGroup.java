/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author thanos
 */
@Entity
@Table(name = "MUSIC_GROUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MusicGroup.findAll", query = "SELECT m FROM MusicGroup m"),
    @NamedQuery(name = "MusicGroup.findByMusicGroupId", query = "SELECT m FROM MusicGroup m WHERE m.musicGroupId = :musicGroupId"),
    @NamedQuery(name = "MusicGroup.findByName", query = "SELECT m FROM MusicGroup m WHERE m.name = :name"),
    @NamedQuery(name = "MusicGroup.findByFormationDate", query = "SELECT m FROM MusicGroup m WHERE m.formationDate = :formationDate")})
public class MusicGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MUSIC_GROUP_ID")
    private Integer musicGroupId;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "FORMATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date formationDate;
    @ManyToMany(mappedBy = "musicGroupList")
    private List<Artist> artistList;
    @OneToMany(mappedBy = "musicGroupmusicGroupId")
    private List<Album> albumList;

    public MusicGroup() {
    }

    public MusicGroup(Integer musicGroupId) {
        this.musicGroupId = musicGroupId;
    }

    public MusicGroup(Integer musicGroupId, String name) {
        this.musicGroupId = musicGroupId;
        this.name = name;
    }

    public Integer getMusicGroupId() {
        return musicGroupId;
    }

    public void setMusicGroupId(Integer musicGroupId) {
        this.musicGroupId = musicGroupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFormationDate() {
        return formationDate;
    }

    public void setFormationDate(Date formationDate) {
        this.formationDate = formationDate;
    }

    @XmlTransient
    public List<Artist> getArtistList() {
        return artistList;
    }

    public void setArtistList(List<Artist> artistList) {
        this.artistList = artistList;
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
        hash += (musicGroupId != null ? musicGroupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MusicGroup)) {
            return false;
        }
        MusicGroup other = (MusicGroup) object;
        if ((this.musicGroupId == null && other.musicGroupId != null) || (this.musicGroupId != null && !this.musicGroupId.equals(other.musicGroupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.MusicGroup[ musicGroupId=" + musicGroupId + " ]";
    }
    
}
