package com.example.bobomap;

import com.example.bobomap.dto.Marker;
import com.example.bobomap.dto.UserLocationDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class MapService {

    private Map<String, List<Marker>> markers = new ConcurrentHashMap<>();

    public String createMap() {
        String mapId = UUID.randomUUID().toString();
        markers.put(mapId, new ArrayList<>());

        return mapId;
    }

    public void addMarker(String mapId, Marker marker) {
        markers.get(mapId).add(marker);
    }

    public List<Marker> getMarkersByMapId(String mapId) {
        return markers.get(mapId);
    }
}
