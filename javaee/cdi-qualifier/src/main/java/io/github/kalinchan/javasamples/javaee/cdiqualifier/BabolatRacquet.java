package io.github.kalinchan.javasamples.javaee.cdiqualifier;

import javax.enterprise.context.Dependent;

@SpinRacquet //This is the qualifier I created
@Dependent
public class BabolatRacquet implements RacquetType {

	@Override
	public String getRacquetType() {
        return ("Babolat AeroPro Drive GT");
	}

}
