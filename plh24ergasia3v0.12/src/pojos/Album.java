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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ALBUM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Album.findAll", query = "SELECT a FROM Album a"),
    @NamedQuery(name = "Album.findByAlbumId", query = "SELECT a FROM Album a WHERE a.albumId = :albumId"),
    @NamedQuery(name = "Album.findByTitle", query = "SELECT a FROM Album a WHERE a.title = :title"),
    @NamedQuery(name = "Album.findByReleaseDate", query = "SELECT a FROM Album a WHERE a.releaseDate = :releaseDate"),
    @NamedQuery(name = "Album.findByType", query = "SELECT a FROM Album a WHERE a.type = :type"),
    @NamedQuery(name = "Album.findByDiskNumber", query = "SELECT a FROM Album a WHERE a.diskNumber = :diskNumber")})
public class Album implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ALBUM_ID")
    private Integer albumId;
    @Basic(optional = false)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @Column(name = "RELEASE_DATE")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;
    @Basic(optional = false)
    @Column(name = "TYPE")
    private String type;
    @Basic(optional = false)
    @Column(name = "DISK_NUMBER")
    private int diskNumber;
    @OneToMany(mappedBy = "albumalbumId")
    private List<Song> songList;
    @JoinColumn(name = "ARTISTARTIST_ID", referencedColumnName = "ARTIST_ID")
    @ManyToOne
    private Artist artistartistId;
    @JoinColumn(name = "MUSIC_GROUPMUSIC_GROUP_ID", referencedColumnName = "MUSIC_GROUP_ID")
    @ManyToOne
    private MusicGroup musicGroupmusicGroupId;
    @JoinColumn(name = "MUSIC_PRODUCTION_COMPANYNAME", referencedColumnName = "NAME")
    @ManyToOne
    private MusicProductionCompany musicProductionCompanyname;

    public Album() {
    }

    public Album(Integer albumId) {
        this.albumId = albumId;
    }

    public Album(Integer albumId, String title, Date releaseDate, String type, int diskNumber) {
        this.albumId = albumId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.type = type;
        this.diskNumber = diskNumber;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDiskNumber() {
        return diskNumber;
    }

    public void setDiskNumber(int diskNumber) {
        this.diskNumber = diskNumber;
    }

    @XmlTransient
    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    public Artist getArtistartistId() {
        return artistartistId;
    }

    public void setArtistartistId(Artist artistartistId) {
        this.artistartistId = artistartistId;
    }

    public MusicGroup getMusicGroupmusicGroupId() {
        return musicGroupmusicGroupId;
    }

    public void setMusicGroupmusicGroupId(MusicGroup musicGroupmusicGroupId) {
        this.musicGroupmusicGroupId = musicGroupmusicGroupId;
    }

    public MusicProductionCompany getMusicProductionCompanyname() {
        return musicProductionCompanyname;
    }

    public void setMusicProductionCompanyname(MusicProductionCompany musicProductionCompanyname) {
        this.musicProductionCompanyname = musicProductionCompanyname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (albumId != null ? albumId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.albumId == null && other.albumId != null) || (this.albumId != null && !this.albumId.equals(other.albumId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.Album[ albumId=" + albumId + " ]";
    }
    
}
