package com.example.bobomap;

import com.example.bobomap.dto.Marker;
import com.example.bobomap.dto.UserLocationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/map")
@RequiredArgsConstructor
public class MapController {

    private final MapService mapService;

    private String getLocation(UserLocationDto dto) {
        return ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/map.html")
                .queryParam("mapId", mapService.createMap(dto))
                .toUriString();
    }

    @PostMapping()
    public ResponseEntity<String> saveNew(@RequestBody UserLocationDto dto) {
        System.out.println(dto);
        var location = getLocation(dto);
        System.out.println(location);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @PostMapping("/{mapId}")
    public void save(@PathVariable String mapId, @RequestBody UserLocationDto dto) {
        Marker marker = new Marker(dto.getName(), dto.getLatitude(), dto.getLongitude());
        mapService.addMarker(mapId, marker);
    }

    @GetMapping("/{mapId}")
    public ResponseEntity<List<Marker>> getMarkersByMapId(@PathVariable String mapId) {
        System.out.println(mapId);
        List<Marker> markers = mapService.getMarkersByMapId(mapId);
        System.out.println(markers);
        return new ResponseEntity<>(markers, HttpStatus.OK);
    }
}
