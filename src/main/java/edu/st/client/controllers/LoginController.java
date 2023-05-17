package edu.st.client.controllers;

import java.util.ArrayList;

import edu.st.client.controllers.single.SingleAvatarController;
import edu.st.client.services.FxService;
import edu.st.client.services.LoginService;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class LoginController extends BaseController {
  // all fxml properties
  public Button online_btn = null;
  public Button single_player_btn = null;
  public Button multiplayer_btn = null;
  public Button return_btn = null;
  public AnchorPane overlay = null;
  public AnchorPane root = null;
  public ImageView background_image = null;

  public LoginController() {
    backgrounds = new ArrayList<Image>();
    LoginService.readBackgrounds(backgrounds);
    FxService.setMedia("audio/title.mp3");
    FxService.playMedia();
  }

  @FXML
  public void initialize() {
    background_image.setImage(LoginService.getRandomBackground(backgrounds));

    return_btn.setOnAction(event -> {
      overlay.setVisible(false);
    });

    single_player_btn.setOnAction(event -> {
      FxService.switchViews("views/SingleAvatarPicker.fxml", new SingleAvatarController());
    });

    multiplayer_btn.setOnAction(event -> {
      FxService.switchViews("views/AvatarPicker.fxml", null);
    });

    online_btn.setOnAction(event -> {
      FxService.switchViews("views/GameLobby.fxml", null);
    });
  }

  private ArrayList<Image> backgrounds = null;
}
