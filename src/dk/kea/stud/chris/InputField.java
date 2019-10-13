package dk.kea.stud.chris;

public class InputField extends View implements Usable {
  private String value;

  public InputField(AbstractController controller, String id) {
    super(controller, id);
    this.value = "";
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public void use() {
    System.out.print("Input: ");
    this.value = SystemInput.getInstance().getLine();
  }

  @Override
  public String toString() {
    String result = "Input field with ID \"" + id + "\", and ";
    if (!value.equals("")) {
      result = result.concat("input \"" + value + "\".");
    } else {
      result = result.concat("no input.");
    }
    return result;
  }
}
