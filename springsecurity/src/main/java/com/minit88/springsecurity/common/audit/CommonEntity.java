package com.minit88.springsecurity.common.audit;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@MappedSuperclass // 다른 엔티티 클래스가 상속받을 수 있는 슈퍼클래스로 지정
@EntityListeners(AuditingEntityListener.class) // 특정 엔티티 클래스에 대해 이벤트를 리스닝하는 리스너 클래스를 지정할 때 사용
public abstract class CommonEntity {
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column
    private LocalDateTime updatedAt;
}
