package dk.kea.stud.chris;

import java.util.LinkedHashMap;
import java.util.Map;

public class ExchangeModel extends AbstractModel {
  private Map<String, Double> exchangeRates;

  public ExchangeModel(AbstractController controller) {
    super(controller);
    exchangeRates = new LinkedHashMap<>();
    exchangeRates.put("DKK", 1.0);
    exchangeRates.put("USD", 6.76);
    exchangeRates.put("EUR", 7.47);
  }

  public Double getRate(String currency) {
    return exchangeRates.get(currency);
  }

  public String[] getCurrencies() {
    return exchangeRates.keySet().toArray(new String[]{});
  }
}
