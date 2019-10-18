package com.stackroute.trackservice;

import com.stackroute.domain.Track;

import java.util.List;

public interface TrackService {

    public Track saveTrack(Track track) //throws TrackAlreadyExistsException
            ;

    public Track getTrackById(int trackId) //throws TrackNotFoundException
            ;

    public List<Track> getAllTracks() //throws TrackNotFoundException
    ;

    public Track updateTrack(int trackId, String comment) //throws TrackNotFoundException
    ;

    public Track deleteTrack(int trackId) //throws TrackNotFoundException
            ;

    public List<Track> getTrackByName(String trackName) //throws TrackNotFoundException
            ;

}
