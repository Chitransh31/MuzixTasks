package com.stackroute.trackservice;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service
@Profile("dev")
public class TrackServiceImpl implements TrackService {

    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) {
        Track savedTrack = null;
        if(!trackRepository.existsById(track.getTrackId())) {
            savedTrack = trackRepository.save(track);
        }
//        if(savedTrack == null) {
//            throw new TrackAlreadyExistsException("Track Already Exists!");
//        }

        return savedTrack;
    }

    @Override
    public Track getTrackById(int trackId) {
        Track track = null;
//        if(!trackRepository.existsById(trackId)) {
//            throw new TrackNotFoundException("Track Not Found!");
//        }
        track = trackRepository.findById(trackId).orElse(null);
        return track;
    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public Track updateTrack(int trackId, String comment) {
        Track updatedTrack = null;
//        if(!trackRepository.existsById(trackId))  {
//            throw new TrackNotFoundException("Track Not Found!");
//        }
        updatedTrack = getTrackById(trackId);
         if(updatedTrack != null) {
             updatedTrack.setComment(comment);
             updatedTrack = trackRepository.save(updatedTrack);
         }

        return updatedTrack;
    }

    @Override
    public Track deleteTrack(int trackId) {
        Track deletedTrack = null;
//        if(!trackRepository.existsById(trackId)) {
//            throw new TrackNotFoundException("Track Not Found!");
//        }

        boolean doesExist = trackRepository.existsById(trackId);
        if(doesExist) {
            deletedTrack = getTrackById(trackId);
            trackRepository.delete(deletedTrack);
        }

        return deletedTrack;
    }

    @Override
    public List<Track> getTrackByName(String trackName) {
        List<Track> trackList = trackRepository.findByName(trackName);
        return trackList;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Normal Track Service post-construct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Normal Track Service pre-destroy");
    }

}
