package nl.northernlogic.portfoliodashboard;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/positions")
public class PositionController {

    private final PositionRepository repo;

    public PositionController(PositionRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public Iterable<Position> all() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Position getById(@PathVariable Long id) {
        return repo.findById(id)
                   .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Position not found"));
    }

    @PostMapping
    public ResponseEntity<Position> create(@RequestBody NewPosition req) {
        Position toSave = new Position(null, req.getSymbol(), req.getQuantity());
        Position saved = repo.save(toSave);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Position> update(@PathVariable Long id, @RequestBody UpdatePosition req) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Position not found");
        }
        Position saved = repo.save(new Position(id, req.getSymbol(), req.getQuantity()));
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Position not found");
        }
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
