package io.github.kalinchan.javasamples.javaee.cdiqualifier;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class RacquetBean {
	private String racquetSpin;
	private String racquetPower;
	private RacquetType racquetSpinType;
	private RacquetType racquetPowerType;

	// An empty constructor is needed for the CDI container
	public RacquetBean() {
	}

	/*
	 * You add the qualifier annotations to the injected values for the container to identify what to inject
	 */
	@Inject
	public RacquetBean(@SpinRacquet RacquetType racquetSpinType, @PowerRacquet RacquetType racquetPowerType) {
		this.racquetSpinType = racquetSpinType;
		this.racquetPowerType = racquetPowerType;
	}

	public String getRacquetPower() {
		racquetPower = racquetPowerType.getRacquetType();
		return racquetPower;
	}

	public String getRacquetSpin() {
		racquetSpin = racquetSpinType.getRacquetType();
		return racquetSpin;
	}
}
