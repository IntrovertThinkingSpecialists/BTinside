package ITS.BTinside.Service;

import ITS.BTinside.Entity.Location;
import ITS.BTinside.Repository.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepo locationRepo;

    public List<Location> findAll() {
        return locationRepo.findAll();
    }

    public Optional<Location> findById(Long id) {
        return locationRepo.findById(id);
    }

    public Location save(Location location) {
        return locationRepo.save(location);
    }

    public void deleteById(Long id) {
        locationRepo.deleteById(id);
    }
}
