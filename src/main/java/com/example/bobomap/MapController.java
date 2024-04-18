package com.example.bobomap;

import com.example.bobomap.dto.Marker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class MapController {

    private final MapService mapService;

    @GetMapping("/welcome")
    public ResponseEntity<?> createNewMap() {
        return ResponseEntity
                .created(URI.create(mapService.createMap()))
                .build();
    }

    @PostMapping("/{mapId}/save-data")
    public void saveMarkerByMapId(@PathVariable String mapId, @RequestBody Marker marker) {
        mapService.addMarker(mapId, marker);
    }

    @GetMapping("/{mapId}")
    public List<Marker> getMap(@PathVariable String mapId) {
        return mapService.getMarkersByMapId(mapId);
    }
}
