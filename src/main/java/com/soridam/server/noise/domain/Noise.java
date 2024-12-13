package com.soridam.server.noise.domain;

import static jakarta.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

import org.locationtech.jts.geom.Point;

import com.soridam.server.common.domain.BaseTimeEntity;
import com.soridam.server.common.domain.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public class Noise extends BaseTimeEntity {
	@Id
	private Long id;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Column(nullable = false, columnDefinition = "geometry(Point,4326)")
	private Point point;

	@Column(nullable = false)
	private int measurementTime;

	@Column(nullable = false)
	private int minDecibel;

	@Column(nullable = false)
	private int maxDecibel;

	@Column(nullable = false)
	private int avgDecibel;

	@Column(nullable = false)
	private String review;

	public static Noise create(User user, Point point, int measurementTime, int minDecibel, int maxDecibel,
		int avgDecibel, String review) {
		return Noise.builder()
			.user(user)
			.point(point)
			.measurementTime(measurementTime)
			.minDecibel(minDecibel)
			.maxDecibel(maxDecibel)
			.avgDecibel(avgDecibel)
			.review(review)
			.build();
	}
}