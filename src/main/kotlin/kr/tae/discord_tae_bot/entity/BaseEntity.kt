package kr.tae.discord_tae_bot.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(value = [AuditingEntityListener::class])
open class ImmutableEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED", nullable = false)
    open var id: Int = 0,

    @CreatedDate
    @Column(columnDefinition = "DATETIME", nullable = false)
    open var createdAt: LocalDateTime = LocalDateTime.now()
): Serializable

@MappedSuperclass
@EntityListeners(value = [AuditingEntityListener::class])
open class MutableEntity(

    @LastModifiedDate
    @Column(columnDefinition = "DATETIME", nullable = false)
    open var updatedAt: LocalDateTime = LocalDateTime.now()

) : ImmutableEntity(), Serializable

@MappedSuperclass
open class DeletableEntity(

    @Column(columnDefinition = "DATETIME")
    open var deletedAt: LocalDateTime? = null

) : MutableEntity(), Serializable {
    fun setDeleteStatus() {
        deletedAt = LocalDateTime.now()
    }
}