package hu.unideb.inf.albums.service;

import hu.unideb.inf.albums.exception.AlbumNotFoundException;
import hu.unideb.inf.albums.model.Album;
import hu.unideb.inf.albums.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class AlbumService {
    private final AlbumRepository albumRepository;

    @Autowired
    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public Album addAlbum(Album album){
        return albumRepository.save(album);
    }

    public List<Album> findAllAlbums(){
        return albumRepository.findAll();
    }

    public Album updateAlbum(Album album){
        return albumRepository.save(album);
    }

    public void deleteAlbum(Long id){
        albumRepository.deleteAlbumById(id);
    }

    public Album findAlbumById(Long id){
        return albumRepository.findAlbumById(id)
                .orElseThrow(() -> new AlbumNotFoundException("Album by id " + id + "was not found."));
    }
}
