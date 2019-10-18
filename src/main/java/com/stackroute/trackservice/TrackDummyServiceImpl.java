package com.stackroute.trackservice;

import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Primary
@Qualifier("trackService")
@Profile("prod")
public class TrackDummyServiceImpl extends TrackServiceImpl implements TrackService {

    public TrackDummyServiceImpl(TrackRepository trackRepository) {
        super(trackRepository);
    }

    @PostConstruct
    public void initIt() throws Exception {
        System.out.println("Dummy Service Init!");
    }

    @PreDestroy
    public void cleanUp() throws Exception {
        System.out.println("Dummy Service CleanUp!");
    }

}
