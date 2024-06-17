package ITS.BTinside.Service;

import ITS.BTinside.Entity.Schedule;
import ITS.BTinside.Repository.ScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepo scheduleRepo;

    public List<Schedule> findAll() {
        return scheduleRepo.findAll();
    }

    public Optional<Schedule> findById(Long id) {
        return scheduleRepo.findById(id);
    }

    public Schedule save(Schedule schedule) {
        return scheduleRepo.save(schedule);
    }

    public void deleteById(Long id) {
        scheduleRepo.deleteById(id);
    }
}
