package dk.kea.stud.chris;

public class Label extends View {
  private String text;

  public Label(AbstractController controller, String id) {
    super(controller, id);
    this.text = "";
  }

  public void setText(String text) {
    this.text = text;
  }

  @Override
  public void draw() {
    System.out.println(this);
  }

  @Override
  public String toString() {
    return "Label with ID \"" + id + "\", and text \"" + text + "\"";
  }
}
