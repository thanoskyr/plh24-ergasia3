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
@Table(name = "ARTIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artist.findAll", query = "SELECT a FROM Artist a"),
    @NamedQuery(name = "Artist.findByFirstName", query = "SELECT a FROM Artist a WHERE a.firstName = :firstName"),
    @NamedQuery(name = "Artist.findByLastName", query = "SELECT a FROM Artist a WHERE a.lastName = :lastName"),
    @NamedQuery(name = "Artist.findByArtisticName", query = "SELECT a FROM Artist a WHERE a.artisticName = :artisticName"),
    @NamedQuery(name = "Artist.findBySex", query = "SELECT a FROM Artist a WHERE a.sex = :sex"),
    @NamedQuery(name = "Artist.findByBirthDate", query = "SELECT a FROM Artist a WHERE a.birthDate = :birthDate"),
    @NamedQuery(name = "Artist.findByBirthPlace", query = "SELECT a FROM Artist a WHERE a.birthPlace = :birthPlace")})
public class Artist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Id
    @Basic(optional = false)
    @Column(name = "ARTISTIC_NAME")
    private String artisticName;
    @Column(name = "SEX")
    private String sex;
    @Column(name = "BIRTH_DATE")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Column(name = "BIRTH_PLACE")
    private String birthPlace;
    @JoinTable(name = "ARTIST_MUSIC_GROUP", joinColumns = {
        @JoinColumn(name = "ARTISTARTISTIC_NAME", referencedColumnName = "ARTISTIC_NAME")}, inverseJoinColumns = {
        @JoinColumn(name = "MUSIC_GROUPNAME", referencedColumnName = "NAME")})
    @ManyToMany
    private List<MusicGroup> musicGroupList;
    @JoinColumn(name = "MUSIC_GENRENAME", referencedColumnName = "NAME")
    @ManyToOne(optional = false)
    private MusicGenre musicGenrename;
    @OneToMany(mappedBy = "artistartisticName")
    private List<Album> albumList;

    public Artist() {
    }

    public Artist(String artisticName) {
        this.artisticName = artisticName;
    }

    public Artist(String artisticName, String firstName, String lastName) {
        this.artisticName = artisticName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getArtisticName() {
        return artisticName;
    }

    public void setArtisticName(String artisticName) {
        this.artisticName = artisticName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    @XmlTransient
    public List<MusicGroup> getMusicGroupList() {
        return musicGroupList;
    }

    public void setMusicGroupList(List<MusicGroup> musicGroupList) {
        this.musicGroupList = musicGroupList;
    }

    public MusicGenre getMusicGenrename() {
        return musicGenrename;
    }

    public void setMusicGenrename(MusicGenre musicGenrename) {
        this.musicGenrename = musicGenrename;
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
        hash += (artisticName != null ? artisticName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artist)) {
            return false;
        }
        Artist other = (Artist) object;
        if ((this.artisticName == null && other.artisticName != null) || (this.artisticName != null && !this.artisticName.equals(other.artisticName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.Artist[ artisticName=" + artisticName + " ]";
    }
    
}
