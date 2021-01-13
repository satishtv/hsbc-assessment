package entity.response;

import entity.Rates;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LatestRatesResponse extends BaseResponse {

    public String base;
    public Rates rates;
    public String date;
}
