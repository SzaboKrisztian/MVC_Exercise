package dk.kea.stud.chris;

public class MainController extends AbstractController {
  private InputField amount = new InputField(this, "inputAmount");
  private DropDownSelection currency = new DropDownSelection(this, "selectCurrency");
  private Label result = new Label(this, "labelResult");
  private ExchangeModel exchangeModel = new ExchangeModel(this);

  public MainController() {
    models.add(exchangeModel);
    Window mainWindow = new Window(this, "winMain");
    mainWindow.setTitle("Currency exchange calculator");
    mainWindow.addChild(amount);
    currency.setOptions(exchangeModel.getCurrencies());
    mainWindow.addChild(currency);
    mainWindow.addChild(result);
    Button btn = new Button(this, "buttonCalculate");
    btn.setText("Calculate");
    mainWindow.addChild(btn);
    btn = new Button(this, "buttonAbout");
    btn.setText("About");
    mainWindow.addChild(btn);
    btn = new Button(this, "buttonQuit");
    btn.setText("Quit");
    mainWindow.addChild(btn);
    view = mainWindow;
  }

  @Override
  public void onUse(String id) {
    switch (id) {
      case "buttonCalculate":
        int amt;
        if (currency.getSelection() == null) {
          result.setText("Error: no currency selected");
          break;
        }
        try {
          amt = Integer.parseInt(amount.getValue());
          result.setText("" + (amt * exchangeModel.getRate(currency.getSelection())) + " DKK");
        } catch (NumberFormatException e) {
          result.setText("Error: invalid amount entered");
        }
        break;
      case "buttonAbout":
        new AboutController().run();
        break;
      case "buttonQuit":
        terminate = true;
      default:
    }
  }
}