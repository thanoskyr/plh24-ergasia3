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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "PLAYLIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Playlist.findAll", query = "SELECT p FROM Playlist p"),
    @NamedQuery(name = "Playlist.findByName", query = "SELECT p FROM Playlist p WHERE p.name = :name"),
    @NamedQuery(name = "Playlist.findByDescription", query = "SELECT p FROM Playlist p WHERE p.description = :description"),
    @NamedQuery(name = "Playlist.findByCreationDate", query = "SELECT p FROM Playlist p WHERE p.creationDate = :creationDate")})
public class Playlist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @JoinTable(name = "SONG_PLAYLIST", joinColumns = {
        @JoinColumn(name = "PLAYLISTNAME", referencedColumnName = "NAME")}, inverseJoinColumns = {
        @JoinColumn(name = "SONGSONG_ID", referencedColumnName = "SONG_ID")})
    @ManyToMany
    private List<Song> songList;

    public Playlist() {
    }

    public Playlist(String name) {
        this.name = name;
    }

    public Playlist(String name, String description, Date creationDate) {
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @XmlTransient
    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
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
        if (!(object instanceof Playlist)) {
            return false;
        }
        Playlist other = (Playlist) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.Playlist[ name=" + name + " ]";
    }
    
}
