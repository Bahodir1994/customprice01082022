package uz.customs.customsprice.service;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InitialDecision.Location;
import uz.customs.customsprice.repository.LocationRepo;

@Service
public class LocationService {
    private final LocationRepo locationRepo;

    public LocationService(LocationRepo locationRepo) {
        this.locationRepo = locationRepo;
    }

    public Location getById(String id) {
        if (locationRepo.findById(id).isPresent())
            return locationRepo.findById(id).get();
        else return null;
    }
}
