package ITS.BTinside.Controller;

import ITS.BTinside.Entity.Location;
import ITS.BTinside.Service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public List<Location> getAllLocations() {
        return locationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable Long id) {
        Optional<Location> location = locationService.findById(id);
        return location.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Location createLocation(@RequestBody Location location) {
        return locationService.save(location);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable Long id, @RequestBody Location locationDetails) {
        Optional<Location> location = locationService.findById(id);
        if (location.isPresent()) {
            Location updatedLocation = location.get();
            updatedLocation.setLoc_name(locationDetails.getLoc_name());
            updatedLocation.setLoc_lat(locationDetails.getLoc_lat());
            updatedLocation.setLoc_lon(locationDetails.getLoc_lon());
            updatedLocation.setPost(locationDetails.getPost());
            updatedLocation.setProfile(locationDetails.getProfile());
            return ResponseEntity.ok(locationService.save(updatedLocation));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Long id) {
        Optional<Location> location = locationService.findById(id);
        if (location.isPresent()) {
            locationService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
