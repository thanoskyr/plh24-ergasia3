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
    @NamedQuery(name = "Album.findByTitle", query = "SELECT a FROM Album a WHERE a.title = :title"),
    @NamedQuery(name = "Album.findByReleaseDate", query = "SELECT a FROM Album a WHERE a.releaseDate = :releaseDate"),
    @NamedQuery(name = "Album.findByType", query = "SELECT a FROM Album a WHERE a.type = :type"),
    @NamedQuery(name = "Album.findByDiskNumber", query = "SELECT a FROM Album a WHERE a.diskNumber = :diskNumber")})
public class Album implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
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
    @ManyToMany(mappedBy = "albumList")
    private List<MusicGroup> musicGroupList;
    @JoinTable(name = "ALBUM_ARTIST", joinColumns = {
        @JoinColumn(name = "ALBUMTITLE", referencedColumnName = "TITLE")}, inverseJoinColumns = {
        @JoinColumn(name = "ARTISTARTISTIC_NAME", referencedColumnName = "ARTISTIC_NAME")})
    @ManyToMany
    private List<Artist> artistList;
    @OneToMany(mappedBy = "albumtitle")
    private List<Song> songList;
    @JoinColumn(name = "MUSIC_PRODUCTION_COMPANYNAME", referencedColumnName = "NAME")
    @ManyToOne
    private MusicProductionCompany musicProductionCompanyname;

    public Album() {
    }

    public Album(String title) {
        this.title = title;
    }

    public Album(String title, Date releaseDate, String type, int diskNumber) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.type = type;
        this.diskNumber = diskNumber;
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
    public List<MusicGroup> getMusicGroupList() {
        return musicGroupList;
    }

    public void setMusicGroupList(List<MusicGroup> musicGroupList) {
        this.musicGroupList = musicGroupList;
    }

    @XmlTransient
    public List<Artist> getArtistList() {
        return artistList;
    }

    public void setArtistList(List<Artist> artistList) {
        this.artistList = artistList;
    }

    @XmlTransient
    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
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
        hash += (title != null ? title.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.title == null && other.title != null) || (this.title != null && !this.title.equals(other.title))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.Album[ title=" + title + " ]";
    }
    
}
