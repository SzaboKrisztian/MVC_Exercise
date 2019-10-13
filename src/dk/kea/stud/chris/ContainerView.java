package dk.kea.stud.chris;

import java.util.ArrayList;
import java.util.List;

public abstract class ContainerView extends AbstractView {
  protected List<AbstractView> children;

  protected ContainerView(AbstractController controller, String id) {
    super(controller, id);
    children = new ArrayList<>();
  }

  public void addChild(AbstractView view) {
    children.add(view);
  }

  public AbstractView getChild(int index) {
    return children.get(index);
  }

  public int getNoChildren() {
    return children.size();
  }
}
