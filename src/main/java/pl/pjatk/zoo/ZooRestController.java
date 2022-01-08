package pl.pjatk.zoo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zoo")
public class ZooRestController {

    private final ZooService zooService;

    public ZooRestController(ZooService zooService) {
        this.zooService = zooService;
    }

    @GetMapping("/example")
    public ResponseEntity<Zoo> getExampleZoo() {
        return ResponseEntity.ok(zooService.getExampleZoo());
    }

    @GetMapping("/empty")
    public ResponseEntity<Zoo> getEmptyZoo() {
        return ResponseEntity.ok(zooService.getEmptyZoo());
    }

    @GetMapping("/emptyWithName")
    public ResponseEntity<Zoo> getZooForName(@RequestParam String name) {
        return ResponseEntity.ok(zooService.getEmptyZooForName(name));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Zoo>> getAllZoos() {
        return ResponseEntity.ok(zooService.getAllZoos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Zoo> getByID(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(zooService.findById(id));
    }

}
