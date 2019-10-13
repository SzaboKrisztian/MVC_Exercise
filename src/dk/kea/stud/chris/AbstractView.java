package dk.kea.stud.chris;

public abstract class AbstractView {
  protected AbstractController controller;
  protected String id;

  public abstract void draw();

  protected AbstractView(AbstractController controller, String id) {
    this.controller = controller;
    this.id = id;
  }
}
