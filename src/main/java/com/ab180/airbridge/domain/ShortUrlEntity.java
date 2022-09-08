package com.ab180.airbridge.domain;

import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
@Table(name="tb_short_url")
public class ShortUrlEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "url_id")
    private long urlId;

    @Column(name = "short_url")
    private String shortUrl;

    @Column(name = "origin_url")
    private String originUrl;

}
