package dk.kea.stud.chris;

public class Button extends View implements Usable {
  private String text;

  protected Button(AbstractController controller, String id) {
    super(controller, id);
    this.text = "";
  }

  public void setText(String text) {
    this.text = text;
  }

  @Override
  public void use() {
    controller.onUse(id);
  }

  @Override
  public String toString() {
    return "Button with ID \"" + id + "\", and text \"" + text + "\"";
  }
}
