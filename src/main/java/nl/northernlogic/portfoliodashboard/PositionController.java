package nl.northernlogic.portfoliodashboard;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PositionController {

    private final PositionRepository repo;

    public PositionController(PositionRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/positions")
    public Iterable<Position> all() {
        return repo.findAll();
    }
}
