package entity.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import entity.Rates;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LatestRatesResponse extends BaseResponse {

    public String base;
    public Rates rates;
    public String date;
    public String error;
}
