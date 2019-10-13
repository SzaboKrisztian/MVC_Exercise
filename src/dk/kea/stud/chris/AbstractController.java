package dk.kea.stud.chris;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractController {
  protected AbstractView view;
  protected List<AbstractModel> models;
  protected boolean terminate = false;

  protected AbstractController() {
    models = new ArrayList<>();
  }

  public abstract void onUse(String id);

  public void run() {
    List<Usable> usables = new ArrayList<>();
    findUsables(usables, view);

    while (!terminate) {
      view.draw();
      System.out.println("Select an option: ");
      System.out.println("r. Redraw");
      for (int i = 0; i < usables.size(); i++) {
        System.out.println("" + (i + 1) + ". " + usables.get(i).toString());
      }
      int choice = -1;
      do {
        String input = SystemInput.getInstance().getLine();
        if (input.equals("r")) {
          choice = 0;
        } else {
          try {
            choice = Integer.parseInt(input);
          } catch (NumberFormatException e) {
            System.out.println("Invalid input; try again.");
            continue;
          }
        }
        if (choice < 0 || choice > usables.size()) {
          System.out.println("Invalid option; try again.");
        }
      } while (choice < 0 || choice > usables.size());

      if (choice != 0) {
        usables.get(choice - 1).use();
      }
    }
  }

  private static void findUsables(List<Usable> target, AbstractView startingElement) {
    if (startingElement instanceof Usable) {
      target.add((Usable) startingElement);
    } else if (startingElement instanceof ContainerView) {
      ContainerView containerElement = (ContainerView) startingElement;
      for (int i = 0; i < containerElement.getNoChildren(); i++) {
        findUsables(target, containerElement.getChild(i));
      }
    }
  }
}
