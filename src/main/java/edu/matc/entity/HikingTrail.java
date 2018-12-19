package edu.matc.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * A class to represent a hiking trail.
 *
 * @author Dan Miller
 */

@Entity(name = "HikingTrail")
@Table(name = "Hiking_Trail")
@Data
public class HikingTrail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "trail_head_name")
    private String trailHeadName;

    @Column(name = "trail_head_location")
    private String trailHeadLocation;

    @Column(name = "trail_length")
    private int trailLength;

    @Column(name = "trail_difficulty")
    private int trailDifficulty;

    @Column(name = "trail_rating")
    private int trailRating;

    @Column(name = "trail_features")
    private String trailFeatures;

    @Column(name = "trail_details")
    private String trailDetails;

    @Column(name = "trail_description")
    private String trailDescription;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinColumn(name = "hiker_account_id")
    private HikerAccount hikerAccount;


    /**
     * Instantiates a new Hiking trail.
     */
    public HikingTrail() {
    }

    /**
     * Instantiates a new Hiking trails.
     *
     * @param trailHeadName    the trail head name
     * @param trailHeadLocation  the trail head location
     * @param trailLength      the trail length
     * @param trailDifficulty  the trail difficulty
     * @param trailRating      the trail rating
     * @param trailFeatures    the trail features
     * @param trailDetails     the trail details
     * @param trailDescription the trail description
     * @param hikerAccount     the hiker account
     */
    public HikingTrail(String trailHeadName, String trailHeadLocation,
                       int trailLength, int trailDifficulty, int trailRating,
                       String trailFeatures, String trailDetails,
                       String trailDescription, HikerAccount hikerAccount) {
        this.trailHeadName = trailHeadName;
        this.trailHeadLocation = trailHeadLocation;
        this.trailLength = trailLength;
        this.trailDifficulty = trailDifficulty;
        this.trailRating = trailRating;
        this.trailFeatures = trailFeatures;
        this.trailDetails = trailDetails;
        this.trailDescription = trailDescription;
        this.hikerAccount = hikerAccount;
    }

}
