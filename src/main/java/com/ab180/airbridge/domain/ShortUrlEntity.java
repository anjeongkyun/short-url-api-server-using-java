package com.ab180.airbridge.domain;

import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
@Table(name="tb_short_url")
public class ShortUrlEntity extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "url_id")
    private long urlId;

    @Column(name = "short_id")
    private String shortId;

    @Column(name = "origin_url")
    private String originUrl;

}
