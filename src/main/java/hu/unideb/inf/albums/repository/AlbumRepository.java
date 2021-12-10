package hu.unideb.inf.albums.repository;

import hu.unideb.inf.albums.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    void deleteAlbumById(Long id);
    Optional<Album> findAlbumById(Long id);
}
