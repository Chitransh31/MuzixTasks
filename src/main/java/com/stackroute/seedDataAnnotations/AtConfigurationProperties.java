package com.stackroute.seedDataAnnotations;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
@ConfigurationProperties
public class AtConfigurationProperties {

    @Autowired
    TrackRepository trackRepository;

    //@Value("${trackId1}")
    private int trackId;

    //@Value("${trackName1}")
    private String trackName;

    //@Value("${comment1}")
    private String comment;

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Bean
    public Track seedTrack2() {
        return trackRepository.save(new Track(trackId, trackName, comment));
    }

}
