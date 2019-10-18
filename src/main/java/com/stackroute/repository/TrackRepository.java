package com.stackroute.repository;

import com.stackroute.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track, Integer> {

    @Query(value = "from Track where trackName=?1")
    public List<Track> findByName(String trackName);

}
