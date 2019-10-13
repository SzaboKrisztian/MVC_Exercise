package dk.kea.stud.chris;

public class Window extends ContainerView {
  private String title;

  public Window(AbstractController controller, String id) {
    super(controller, id);
    this.title = "";
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Window with ID \"");
    stringBuilder.append(id);
    stringBuilder.append("\", titled \"");
    stringBuilder.append(title);
    stringBuilder.append("\" with the following children: ");
    stringBuilder.append(System.lineSeparator());
    for (AbstractView element: children) {
      stringBuilder.append("  - ");
      stringBuilder.append(element.toString());
      stringBuilder.append(System.lineSeparator());
    }
    return stringBuilder.toString();
  }
}
