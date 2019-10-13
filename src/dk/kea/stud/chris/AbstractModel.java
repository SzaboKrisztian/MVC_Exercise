package dk.kea.stud.chris;

public abstract class AbstractModel {
  protected AbstractController controller;

  protected AbstractModel(AbstractController controller) {
    this.controller = controller;
  }
}
