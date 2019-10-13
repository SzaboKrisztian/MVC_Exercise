package dk.kea.stud.chris;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DropDownSelection extends View implements Usable {
  private List<String> options;
  private int selection;

  protected DropDownSelection(AbstractController controller, String id) {
    super(controller, id);
    this.options = new ArrayList<>();
    selection = -1;
  }

  public String[] getOptions() {
    return options.toArray(new String[]{});
  }

  public void setOptions(String[] options) {
    this.options = new ArrayList<>(Arrays.asList(options));
    selection = -1;
  }

  public String getSelection() {
    if (selection == -1) {
      return null;
    } else {
      return options.get(selection);
    }
  }

  @Override
  public void use() {
    if (!options.isEmpty()) {
      int selection;
      do {
        System.out.println("Select an option:");
        for (int i = 0; i < options.size(); i++) {
          System.out.println("" + (i + 1) + ". " + options.get(i));
        }
        selection = SystemInput.getInstance().getInt();
        if (selection < 1 || selection > options.size()) {
          System.out.println("Invalid option; try again.");
          selection = -1;
        }
      } while (selection == -1);

      this.selection = selection - 1;
    }
  }

  @Override
  public String toString() {
    String result = "Drop-down with ID \"" + id + "\", and ";
    if (selection == -1) {
      result = result.concat("nothing selected.");
    } else {
      result = result.concat("option \"" + options.get(selection) + "\" selected.");
    }
    return result;
  }
}