package home.proj.bookmarks.domains

import java.net.URI
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "bookmarks")
data class Bookmark(
    @Id
    @GeneratedValue
    var bookmarkId: UUID? = null,
    var uri: URI? = null,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    var author: User? = null
)