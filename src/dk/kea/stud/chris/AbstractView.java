package dk.kea.stud.chris;

public abstract class AbstractView {
  protected AbstractController controller;
  protected String id;

  protected AbstractView(AbstractController controller, String id) {
    this.controller = controller;
    this.id = id;
  }

  public void draw() {
    System.out.println(this);
  }
}
