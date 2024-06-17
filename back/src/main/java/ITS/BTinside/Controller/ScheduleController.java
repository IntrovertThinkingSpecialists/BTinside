package ITS.BTinside.Controller;

import ITS.BTinside.Entity.Schedule;
import ITS.BTinside.Service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping
    public List<Schedule> getAllSchedules() {
        return scheduleService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable Long id) {
        Optional<Schedule> schedule = scheduleService.findById(id);
        return schedule.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        return scheduleService.save(schedule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schedule> updateSchedule(@PathVariable Long id, @RequestBody Schedule scheduleDetails) {
        Optional<Schedule> schedule = scheduleService.findById(id);
        if (schedule.isPresent()) {
            Schedule updatedSchedule = schedule.get();
            updatedSchedule.setSche_title(scheduleDetails.getSche_title());
            updatedSchedule.setSche_loc(scheduleDetails.getSche_loc());
            updatedSchedule.setSche_start_time(scheduleDetails.getSche_start_time());
            updatedSchedule.setSche_end_time(scheduleDetails.getSche_end_time());
            updatedSchedule.setSche_person(scheduleDetails.getSche_person());
            updatedSchedule.setUser(scheduleDetails.getUser());
            return ResponseEntity.ok(scheduleService.save(updatedSchedule));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        Optional<Schedule> schedule = scheduleService.findById(id);
        if (schedule.isPresent()) {
            scheduleService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
