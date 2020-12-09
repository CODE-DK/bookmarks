package home.proj.bookmarks.domains

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue
    var userId: UUID? = null,
    private var username: String? = null,
    private var password: String? = null,
    var isActive: Boolean? = null,

    @ElementCollection(targetClass = Role::class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = [JoinColumn(name = "user_id")])
    @Enumerated(EnumType.STRING)
    var roles: MutableSet<Role> = mutableSetOf()
) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = roles

    override fun getPassword(): String = password!!

    override fun getUsername(): String = username!!

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = isActive!!

    fun setPassword(password: String) {
        this.password = password
    }

    fun setUsername(username: String) {
        this.username = username
    }
}