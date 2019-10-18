package com.stackroute.seeddata;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


//Both of them provides the same functionality and the only difference between CommandLineRunner
//        and ApplicationRunner is CommandLineRunner.run() accepts String array[] whereas ApplicationRunner.run()
//        accepts ApplicationArguments as argument.
@Component
public class CommandLineRunnerBean implements CommandLineRunner {

    @Autowired
    TrackRepository trackRepository;

    @Override
    public void run(String... args) {
        System.out.println("Inside runner");
        trackRepository.save(new Track(2, "Wake Me Up", "Avicii"));
    }
}
