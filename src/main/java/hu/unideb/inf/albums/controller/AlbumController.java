package hu.unideb.inf.albums.controller;


import hu.unideb.inf.albums.model.Album;
import hu.unideb.inf.albums.service.AlbumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/add")
    public ResponseEntity<Album> addAlbum(@RequestBody Album album) {
        Album newAlbum = albumService.addAlbum(album);
        return new ResponseEntity<>(newAlbum, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Album> updateAlbum(@RequestBody Album album) {
        Album updatedAlbum = albumService.updateAlbum(album);
        return new ResponseEntity<>(updatedAlbum, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {
        albumService.deleteAlbum(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/")
    public String home(){
        return ("<h1>Üdvözöljük</h1>");
    }

    @GetMapping("/user")
    public String user(){
        return ("<h1>Üdvözöljük, felhasználóként lépett be!</h1>");
    }


    @GetMapping("/admin")
    public String admin(){
        return ("<h1>Üdvözöljük, adminként lépett be!</h1>");
    }

}
