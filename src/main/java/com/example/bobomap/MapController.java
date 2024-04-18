package com.example.bobomap;

import com.example.bobomap.dto.Marker;
import com.example.bobomap.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/map")
@RequiredArgsConstructor
public class MapController {

    private final MapService mapService;

    @PostMapping("/save-name")
    public ResponseEntity<?> createNewMap(@RequestBody UserDto userDto) {
        String location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(mapService.createMap())
                .toString();
        System.out.println(location);

        return ResponseEntity
                .created(URI.create(location))
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
