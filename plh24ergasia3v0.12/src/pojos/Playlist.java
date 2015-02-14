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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
    @NamedQuery(name = "Playlist.findByPlaylistId", query = "SELECT p FROM Playlist p WHERE p.playlistId = :playlistId"),
    @NamedQuery(name = "Playlist.findByName", query = "SELECT p FROM Playlist p WHERE p.name = :name")})
public class Playlist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PLAYLIST_ID")
    private Integer playlistId;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @JoinTable(name = "SONG_PLAYLIST", joinColumns = {
        @JoinColumn(name = "PLAYLISTPLAYLIST_ID", referencedColumnName = "PLAYLIST_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "SONGSONG_ID", referencedColumnName = "SONG_ID")})
    @ManyToMany
    private List<Song> songList;

    public Playlist() {
    }

    public Playlist(Integer playlistId) {
        this.playlistId = playlistId;
    }

    public Playlist(Integer playlistId, String name) {
        this.playlistId = playlistId;
        this.name = name;
    }

    public Integer getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(Integer playlistId) {
        this.playlistId = playlistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        hash += (playlistId != null ? playlistId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Playlist)) {
            return false;
        }
        Playlist other = (Playlist) object;
        if ((this.playlistId == null && other.playlistId != null) || (this.playlistId != null && !this.playlistId.equals(other.playlistId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.Playlist[ playlistId=" + playlistId + " ]";
    }
    
}
