package com.stackroute.seedDataAnnotations;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class AtValue {

    @Autowired
    TrackRepository trackRepository;

    @Value("${trackId2}")
    private int trackId;

    @Value("${trackName2}")
    private String trackName;

    @Value("${comment2}")
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
    public Track seedTrack1() {
        return trackRepository.save(new Track(trackId, trackName, comment));
    }


}
