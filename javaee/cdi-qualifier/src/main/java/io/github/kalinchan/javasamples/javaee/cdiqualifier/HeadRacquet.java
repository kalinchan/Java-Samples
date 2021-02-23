package io.github.kalinchan.javasamples.javaee.cdiqualifier;

import javax.enterprise.context.Dependent;

@PowerRacquet // This is the qualifier I created
@Dependent
public class HeadRacquet implements RacquetType {

	@Override
	public String getRacquetType() {
        return("Head YouTek Speed Pro");
	}

}
