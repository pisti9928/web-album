package hu.unideb.inf.albums.controller;


import hu.unideb.inf.albums.model.Album;
import hu.unideb.inf.albums.service.AlbumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/album")
public class AlbumController {
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Album>> getAllAlbums() {
        List<Album> albums = albumService.findAllAlbums();
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable("id") Long id) {
        Album album = albumService.findAlbumById(id);
        return new ResponseEntity<>(album, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping("/add")
    public ResponseEntity<Album> addAlbum(@RequestBody Album album) {
        Album newAlbum = albumService.addAlbum(album);
        return new ResponseEntity<>(newAlbum, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('admin')")
    @PutMapping("/update")
    public ResponseEntity<Album> updateAlbum(@RequestBody Album album) {
        Album updatedAlbum = albumService.updateAlbum(album);
        return new ResponseEntity<>(updatedAlbum, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('admin')")
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {
        albumService.deleteAlbum(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
