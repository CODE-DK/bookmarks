package home.proj.bookmarks.repositories

import home.proj.bookmarks.domains.Bookmark
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface BookmarkRepo : JpaRepository<Bookmark, UUID> {

}