package homework.controller;

import homework.dto.PositionFormDto;
import homework.model.Position;
import homework.sevice.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/positions")
public class PositionController {
    private PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Position> getPosition(@PathVariable("id") int id) {
        Position position = positionService.getPosition(id);
        return new ResponseEntity<>(position, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Position> createPosition(@RequestBody PositionFormDto positionDto) {
        Position position = new Position();
        position.setPositionName(positionDto.getPositionName());
        position.setEmployees(positionDto.getEmployees());

        positionService.createPosition(position);

        return new ResponseEntity<>(position, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Position> updatePosition(@PathVariable("id") int id,
                                                   @RequestBody PositionFormDto positionDto) {
        Position position = positionService.getPosition(id);
        position.setPositionName(positionDto.getPositionName());
        position.setEmployees(positionDto.getEmployees());

        positionService.updatePosition(position);
        return new ResponseEntity<>(position, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePosition(@PathVariable("id") int id) {
        positionService.deletePosition(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
