package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.trackservice.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class TrackController {
    private TrackService trackService;
    public ResponseEntity responseEntity = null;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping("/track")
    public ResponseEntity<?> createTrack(@RequestBody Track track)
                                throws TrackAlreadyExistsException, Exception {
//        try
//        {
//            trackService.saveTrack(track);
//            responseEntity=new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
//        }
//        catch(TrackAlreadyExistsException e)
//        {
//            responseEntity= new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        //}
//        ResponseEntity responseEntity;
        if(trackService.saveTrack(track) == null) {
            responseEntity= new ResponseEntity<String>("Track Already Exists!",HttpStatus.CONFLICT);
            throw new TrackAlreadyExistsException("Track Already Exists!");
        }
        else {
//            trackService.saveTrack(track);
            responseEntity=new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
        }

        return responseEntity;
    }

    @GetMapping("/tracks")
    public ResponseEntity<?> getTracks() throws TrackNotFoundException, Exception {

        //return new ResponseEntity<>(trackService.getAllTracks(), HttpStatus.OK);
//        ResponseEntity responseEntity;

        List<Track> tracks = trackService.getAllTracks();
        //System.out.println("Tracks size: " + tracks.size());
        if(tracks == null) {
            //System.out.println("Inside null condition");
            responseEntity = new ResponseEntity<String>("No tracks found!",HttpStatus.NOT_FOUND);
            throw new TrackNotFoundException("Tracks Not Found!");
        }
        else {
            //System.out.println("Inside else condition");
            responseEntity = new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.OK);
        }

        return responseEntity;
    }

    @GetMapping("/track/{trackId}")
    public ResponseEntity<?> getTrackById(@PathVariable(value = "trackId") int trackId)
            throws TrackNotFoundException, Exception {
//        try {
//            return new ResponseEntity<Track>(trackService.getTrackById(trackId), HttpStatus.OK);
//        }
//        catch (TrackNotFoundException e) {
//            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
//        }
//        ResponseEntity responseEntity;


        Track getTrack = trackService.getTrackById(trackId);

        if(getTrack == null) {
            responseEntity = new ResponseEntity<String>("Track Not Found!", HttpStatus.NOT_FOUND);
            throw new TrackNotFoundException("Track Not Found!");
        }
        else {
            responseEntity = new ResponseEntity<Track>(getTrack, HttpStatus.OK);
        }

        return responseEntity;

    }

    @PutMapping("/track/{trackId}/{comment}")
    public ResponseEntity<?> updateTrack(@PathVariable(value = "trackId") int trackId,
                             @PathVariable(value = "comment") String comment)
                            throws TrackNotFoundException, Exception {
//        try {
//            return new ResponseEntity<Track>(trackService.updateTrack(trackId, comment), HttpStatus.OK);
//        }
//        catch(TrackNotFoundException e) {
//            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
//        }
//        ResponseEntity responseEntity;

        Track updatedTrack = trackService.updateTrack(trackId, comment);

        if (updatedTrack == null) {
            responseEntity = new ResponseEntity<String>("Track Not Found!", HttpStatus.NOT_FOUND);
            throw new TrackNotFoundException("Track Not Found!");
        }
        else {
            responseEntity = new ResponseEntity<Track>(updatedTrack, HttpStatus.OK);
        }

        return responseEntity;
    }

    @DeleteMapping("/track/{trackId}")
    public ResponseEntity<?> deleteTrack(@PathVariable(value = "trackId") int trackId)
                                                    throws TrackNotFoundException, Exception {
//        try {
//            boolean result = trackService.deleteTrack(trackId);
//            responseEntity=new ResponseEntity<String>("successfully deleted", HttpStatus.OK);
//        }
//        catch(TrackNotFoundException e) {
//            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
//        }
//        ResponseEntity responseEntity;


        Track deletedTrack = trackService.deleteTrack(trackId);

        if (deletedTrack == null) {
            responseEntity = new ResponseEntity<String>("Track Not Found!", HttpStatus.NOT_FOUND);
            throw new TrackNotFoundException("Track Not Found!");
        }
        else {
            responseEntity = new ResponseEntity<String>("successfully deleted", HttpStatus.OK);
        }

        return responseEntity;

    }

    @GetMapping("/track/name/{trackName}")
    public ResponseEntity<?> getTrackByName(@PathVariable(value = "trackName") String trackName)
                                                        throws TrackNotFoundException, Exception {
//        try {
//            return new ResponseEntity<List<Track>>(trackService.getTrackByName(trackName), HttpStatus.OK);
//        }
//        catch (TrackNotFoundException e) {
//            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
//        }
//        ResponseEntity responseEntity;

        List<Track> getTracks = trackService.getTrackByName(trackName);

        if(getTracks.isEmpty()) {
            responseEntity = new ResponseEntity<String>("Track Not Found!", HttpStatus.NOT_FOUND);
            throw new TrackNotFoundException("Track Not Found!");
        }
        else {
            responseEntity = new ResponseEntity<List<Track>>(getTracks, HttpStatus.OK);
        }

        return responseEntity;


    }

}
