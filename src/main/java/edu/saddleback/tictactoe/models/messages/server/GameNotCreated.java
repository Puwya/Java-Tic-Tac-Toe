package edu.saddleback.tictactoe.models.messages.server;

import edu.saddleback.tictactoe.models.messages.Message;
import edu.saddleback.tictactoe.models.messages.MessageType;

public class GameNotCreated extends Message {
  GameNotCreated() {
    super(MessageType.GameNotCreated);
  }
}
