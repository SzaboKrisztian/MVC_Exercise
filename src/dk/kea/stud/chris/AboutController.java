package dk.kea.stud.chris;

public class AboutController extends AbstractController {
  public AboutController() {
    Window aboutWindow = new Window(this, "winAbout");
    aboutWindow.setTitle("About the application");
    Label lbl = new Label(this, "labelAbout");
    lbl.setText("MVC Currency exchange calculator by Krisztian Szabo");
    aboutWindow.addChild(lbl);
    Button btn = new Button(this, "buttonClose");
    btn.setText("Close");
    aboutWindow.addChild(btn);
    view = aboutWindow;
  }

  @Override
  public void onUse(String id) {
    terminate = true;
  }
}
